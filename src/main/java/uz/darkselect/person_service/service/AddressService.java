package uz.darkselect.person_service.service;

import uz.darkselect.person_service.dto.create.PersonAddressRequestDto;
import uz.darkselect.person_service.dto.update.PersonAddressUpdateRequestDto;
import uz.darkselect.person_service.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> createAddressEntities(List<PersonAddressRequestDto> addressDtos);
    List<Address> updateAddressEntities(List<PersonAddressUpdateRequestDto> dtos);
}
