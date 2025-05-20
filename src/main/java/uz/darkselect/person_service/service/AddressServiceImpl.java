package uz.darkselect.person_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.darkselect.person_service.asspect.annotation.AllAspect;
import uz.darkselect.person_service.dto.create.PersonAddressRequestDto;
import uz.darkselect.person_service.dto.update.PersonAddressUpdateRequestDto;
import uz.darkselect.person_service.entity.Address;
import uz.darkselect.person_service.exception.PersonAddressNotFoundException;
import uz.darkselect.person_service.repository.AddressRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Transactional
    @AllAspect
    public List<Address> createAddressEntities(List<PersonAddressRequestDto> addressDtos) {
        List<Address> savedAddresses = new ArrayList<>();
        if (addressDtos == null || addressDtos.isEmpty()) return savedAddresses;

        for (PersonAddressRequestDto dto : addressDtos) {
            Address address = Address.builder()
                    .city(dto.getCity())
                    .region(dto.getRegion())
                    .street(dto.getStreet())
                    .building(dto.getBuilding())
                    .apartment(dto.getApartment())
                    .build();

            savedAddresses.add(addressRepository.save(address));
        }

        return savedAddresses;
    }

    @Transactional
    @AllAspect
    public List<Address> updateAddressEntities(List<PersonAddressUpdateRequestDto> dtos) {
        List<Address> updatedAddresses = new ArrayList<>();
        for (PersonAddressUpdateRequestDto dto : dtos) {
            Address address = addressRepository.findById(dto.getAddressId())
                    .orElseThrow(() -> new PersonAddressNotFoundException(String.format("Address not found: %s", dto.getAddressId())));
            address.setRegion(dto.getRegion());
            address.setCity(dto.getCity());
            address.setStreet(dto.getStreet());
            address.setBuilding(dto.getBuilding());
            address.setApartment(dto.getApartment());
            updatedAddresses.add(addressRepository.save(address));
        }
        return updatedAddresses;
    }
}
