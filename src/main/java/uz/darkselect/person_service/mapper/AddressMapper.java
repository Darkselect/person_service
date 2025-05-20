package uz.darkselect.person_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;
import uz.darkselect.person_service.dto.create.response.PersonAddressResponseDto;
import uz.darkselect.person_service.dto.update.PersonAddressUpdateRequestDto;
import uz.darkselect.person_service.dto.update.response.PersonAddressUpdateResponseDto;
import uz.darkselect.person_service.entity.Address;
import uz.darkselect.person_service.entity.PersonAddress;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Primary
public interface AddressMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "region", source = "address.region")
    @Mapping(target = "city", source = "address.city")
    @Mapping(target = "street", source = "address.street")
    @Mapping(target = "building", source = "address.building")
    @Mapping(target = "apartment", source = "address.apartment")
    PersonAddressResponseDto toDto(PersonAddress entity);

    @Mapping(target = "addressId", source = "address.id")
    @Mapping(target = "personAddressId", source = "id")
    @Mapping(target = "region", source = "address.region")
    @Mapping(target = "city", source = "address.city")
    @Mapping(target = "street", source = "address.street")
    @Mapping(target = "building", source = "address.building")
    @Mapping(target = "apartment", source = "address.apartment")
    PersonAddressUpdateResponseDto toUpdateDto(PersonAddress entity);
}
