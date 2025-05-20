package uz.darkselect.person_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import uz.darkselect.person_service.dto.create.response.ContactResponseDto;
import uz.darkselect.person_service.dto.update.response.ContactUpdateResponseDto;
import uz.darkselect.person_service.entity.Contact;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactMapper {
    ContactResponseDto toDto(Contact entity);
    ContactUpdateResponseDto toUpdateDto(Contact entity);
}
