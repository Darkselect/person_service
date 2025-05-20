package uz.darkselect.person_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import uz.darkselect.person_service.dto.create.PersonCreateRequestDto;
import uz.darkselect.person_service.dto.create.response.PersonResponseDto;
import uz.darkselect.person_service.dto.update.response.PersonUpdateResponseDto;
import uz.darkselect.person_service.entity.Person;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = { IdentityDocumentMapper.class, ContactMapper.class, AddressMapper.class })
public interface PersonMapper {
    Person toEntity(PersonCreateRequestDto dto);

    @Mapping(target = "documents", source = "documents")
    @Mapping(target = "contacts", source = "contacts")
    @Mapping(target = "addresses", source = "personAddresses")
    PersonResponseDto toDto(Person person);

    @Mapping(target = "documents",  source = "documents")
    @Mapping(target = "contacts",   source = "contacts")
    @Mapping(target = "addresses",  source = "personAddresses")
    PersonUpdateResponseDto toResponseDto(Person person);
}
