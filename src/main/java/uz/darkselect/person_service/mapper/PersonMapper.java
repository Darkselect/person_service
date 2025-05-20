package uz.darkselect.person_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import uz.darkselect.person_service.dto.create.PersonCreateRequestDto;
import uz.darkselect.person_service.dto.create.response.PersonResponseDto;
import uz.darkselect.person_service.dto.update.PersonUpdateRequestDto;
import uz.darkselect.person_service.dto.update.response.PersonUpdateResponseDto;
import uz.darkselect.person_service.entity.Person;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface PersonMapper {
    Person toEntity(PersonCreateRequestDto dto);
    Person toEntity(PersonUpdateRequestDto dto);

    @Mapping(target = "documents", source = "documents")
    @Mapping(target = "contacts", source = "contacts")
    @Mapping(target = "addresses", source = "personAddresses")
    PersonResponseDto toDto(Person person);
    PersonUpdateResponseDto toResponseDto(Person person);
    PersonUpdateRequestDto toUpdateDto(Person person);
}
