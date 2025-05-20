package uz.darkselect.person_service.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.darkselect.person_service.asspect.annotation.AllAspect;
import uz.darkselect.person_service.dto.create.PersonCreateRequestDto;
import uz.darkselect.person_service.dto.create.response.PersonResponseDto;
import uz.darkselect.person_service.dto.update.PersonUpdateRequestDto;
import uz.darkselect.person_service.dto.update.response.PersonUpdateResponseDto;
import uz.darkselect.person_service.entity.Address;
import uz.darkselect.person_service.entity.Contact;
import uz.darkselect.person_service.entity.IdentityDocument;
import uz.darkselect.person_service.entity.Person;
import uz.darkselect.person_service.entity.PersonAddress;
import uz.darkselect.person_service.exception.PersonNotFoundException;
import uz.darkselect.person_service.mapper.AddressMapper;
import uz.darkselect.person_service.mapper.ContactMapper;
import uz.darkselect.person_service.mapper.IdentityDocumentMapper;
import uz.darkselect.person_service.mapper.PersonMapper;
import uz.darkselect.person_service.repository.PersonRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final IdentityDocumentService identityService;
    private final ContactService contactService;
    private final AddressService addressService;
    private final PersonAddressService personAddressService;
    private final IdentityDocumentMapper documentMapper;
    private final PersonMapper personMapper;
    private final ContactMapper contactMapper;
    private final AddressMapper addressMapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @AllAspect
    public PersonResponseDto create(PersonCreateRequestDto dto) {
        Person toSave = personMapper.toEntity(dto);
        Person saved = personRepository.save(toSave);

        Person managed = entityManager.getReference(Person.class, saved.getId());

        List<IdentityDocument> docs = identityService
                .createDocumentsForPerson(dto.getDocuments(), managed);

        List<Contact> contacts = contactService
                .createContactsForPerson(dto.getContacts(), managed);

        List<Address> addresses = addressService
                .createAddressEntities(dto.getAddresses());

        List<PersonAddress> links = personAddressService
                .linkPersonWithAddresses(dto.getAddresses(), addresses, managed);

        managed.setDocuments(docs);
        managed.setContacts(contacts);
        managed.setPersonAddresses(links);

        return mapToPersonResponseDto(managed, docs, contacts, links);
    }

    @Transactional
    @AllAspect
    public PersonUpdateResponseDto update(UUID personId, PersonUpdateRequestDto dto) {
        Person person = getPerson(personId, dto);

        List<IdentityDocument> docs = identityService.updateDocumentsForPerson(dto.getDocuments());
        List<Contact> contacts = contactService.updateContactEntities(dto.getContacts());
        List<Address> addresses = addressService.updateAddressEntities(dto.getAddresses());

        List<PersonAddress> links = personAddressService.updatePersonAddresses(dto.getAddresses(), addresses, person);

        Person saved = personRepository.save(person);

        return mapToPersonUpdateResponseDto(saved, docs, contacts, links);
    }

    @AllAspect
    public Page<PersonResponseDto> getAllVisiblePersons(String region, Pageable pageable) {
        return personRepository.findAllVisibleAndFilterByRegion(region, pageable)
                .map(personMapper::toDto);
    }

    @AllAspect
    public PersonResponseDto getPersonById(UUID personId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException(String.format("Person not found: %s", personId)));
        return personMapper.toDto(person);
    }

    @AllAspect
    public boolean verifyFullNameAndPassport(String fullName, String passportNumber) {
        return personRepository
                .findByFullNameAndPassport(fullName, passportNumber)
                .isPresent();
    }

    private Person getPerson(UUID personId, PersonUpdateRequestDto dto) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException(String.format("Person not found: %s", personId)));

        if (Boolean.TRUE.equals(person.getHidden())) {
            throw new IllegalStateException("Cannot update a hidden person: " + personId);
        }

        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setMiddleName(dto.getMiddleName());
        person.setBornDate(dto.getBornDate());
        person.setHidden(dto.getHidden());
        return person;
    }

    private PersonUpdateResponseDto mapToPersonUpdateResponseDto(Person managed, List<IdentityDocument> docs, List<Contact> contacts,
            List<PersonAddress> links) {

        PersonUpdateResponseDto response = personMapper.toResponseDto(managed);
        response.setDocuments(docs.stream()
                .map(documentMapper::toUpdateDto)
                .toList());

        response.setContacts(contacts.stream()
                .map(contactMapper::toUpdateDto)
                .toList());

        response.setAddresses(links.stream()
                .map(addressMapper::toUpdateDto)
                .toList());

        return response;
    }

    private PersonResponseDto mapToPersonResponseDto(Person managed, List<IdentityDocument> docs,
                                                     List<Contact> contacts, List<PersonAddress> links) {
        PersonResponseDto response = personMapper.toDto(managed);
        response.setDocuments(docs.stream()
                .map(documentMapper::toDto)
                .toList());

        response.setContacts(contacts.stream()
                .map(contactMapper::toDto)
                .toList());

        response.setAddresses(links.stream()
                .map(addressMapper::toDto)
                .toList());
        return response;
    }
}
