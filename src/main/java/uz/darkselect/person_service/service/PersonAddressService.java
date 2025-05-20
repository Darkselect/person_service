package uz.darkselect.person_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.darkselect.person_service.asspect.annotation.AllAspect;
import uz.darkselect.person_service.dto.create.PersonAddressRequestDto;
import uz.darkselect.person_service.dto.update.PersonAddressUpdateRequestDto;
import uz.darkselect.person_service.entity.Address;
import uz.darkselect.person_service.entity.Person;
import uz.darkselect.person_service.entity.PersonAddress;
import uz.darkselect.person_service.exception.PersonAddressNotFoundException;
import uz.darkselect.person_service.repository.PersonAddressRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonAddressService {
    private final PersonAddressRepository personAddressRepository;

    @Transactional
    @AllAspect
    public List<PersonAddress> linkPersonWithAddresses(List<PersonAddressRequestDto> addressDtos, List<Address> savedAddresses, Person person) {
        List<PersonAddress> linked = new ArrayList<>(addressDtos.size());
        for (int i = 0; i < addressDtos.size(); i++) {
            PersonAddress pa = PersonAddress.builder()
                    .person(person)
                    .address(savedAddresses.get(i))
                    .type(addressDtos.get(i).getType())
                    .build();
            PersonAddress saved = personAddressRepository.save(pa);
            linked.add(saved);
        }
        return linked;
    }

    @Transactional
    @AllAspect
    public List<PersonAddress> updatePersonAddresses(List<PersonAddressUpdateRequestDto> dtos, List<Address> addresses, Person person) {
        List<PersonAddress> updatedPersonAddresses = new ArrayList<>();
        for (int i = 0; i < dtos.size(); i++) {
            PersonAddressUpdateRequestDto dto = dtos.get(i);
            Address address = addresses.get(i);

            if (dto.getPersonAddressId() != null) {
                PersonAddress link = personAddressRepository.findById(dto.getPersonAddressId())
                        .orElseThrow(() -> new PersonAddressNotFoundException(String.format("PersonAddress not found: %s", dto.getPersonAddressId())));
                link.setAddress(address);
                link.setType(dto.getType());
                updatedPersonAddresses.add(personAddressRepository.save(link));

            } else {
                PersonAddress newLink = PersonAddress.builder()
                        .person(person)
                        .address(address)
                        .type(dto.getType())
                        .build();
                updatedPersonAddresses.add(personAddressRepository.save(newLink));
            }
        }
        return updatedPersonAddresses;
    }
}
