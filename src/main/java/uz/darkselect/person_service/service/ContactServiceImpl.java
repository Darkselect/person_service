package uz.darkselect.person_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.darkselect.person_service.asspect.annotation.AllAspect;
import uz.darkselect.person_service.dto.create.ContactRequestDto;
import uz.darkselect.person_service.dto.update.ContactUpdateRequestDto;
import uz.darkselect.person_service.entity.Contact;
import uz.darkselect.person_service.entity.Person;
import uz.darkselect.person_service.exception.ContactNofFoundException;
import uz.darkselect.person_service.repository.ContactRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{
    private final ContactRepository contactRepository;

    @Transactional
    @AllAspect
    public List<Contact> createContactsForPerson(List<ContactRequestDto> dtos, Person person) {
        if (dtos == null || dtos.isEmpty()) return List.of();
        List<Contact> contacts = dtos.stream()
                .map(dto -> Contact.builder()
                        .person(person)
                        .contactType(dto.getContactType())
                        .contactValue(dto.getContactValue())
                        .isPrimary(dto.getIsPrimary())
                        .build())
                .toList();
        return contactRepository.saveAll(contacts);
    }

    @Transactional
    @AllAspect
    public List<Contact> updateContactEntities(List<ContactUpdateRequestDto> dtos) {
        List<Contact> updatedContacts = new ArrayList<>();
        for (ContactUpdateRequestDto dto : dtos) {
            Contact contact = contactRepository.findById(dto.getId())
                    .orElseThrow(() -> new ContactNofFoundException(String.format("Contact with id %s not found", dto.getId())));

            contact.setContactType(dto.getContactType());
            contact.setContactValue(dto.getContactValue());
            contact.setIsPrimary(dto.getIsPrimary());

            updatedContacts.add(contactRepository.save(contact));
        }
        return updatedContacts;
    }
}
