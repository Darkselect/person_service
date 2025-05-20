package uz.darkselect.person_service.service;

import uz.darkselect.person_service.dto.create.PersonAddressRequestDto;
import uz.darkselect.person_service.dto.update.PersonAddressUpdateRequestDto;
import uz.darkselect.person_service.entity.Address;
import uz.darkselect.person_service.entity.Person;
import uz.darkselect.person_service.entity.PersonAddress;

import java.util.List;

public interface PersonAddressService {
    List<PersonAddress> linkPersonWithAddresses(List<PersonAddressRequestDto> addressDtos, List<Address> savedAddresses, Person person);
    List<PersonAddress> updatePersonAddresses(List<PersonAddressUpdateRequestDto> dtos, List<Address> addresses, Person person);
}
