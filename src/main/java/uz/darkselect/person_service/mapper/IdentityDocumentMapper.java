package uz.darkselect.person_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;
import uz.darkselect.person_service.dto.create.response.IdentityDocumentResponseDto;
import uz.darkselect.person_service.dto.update.response.IdentityDocumentUpdateResponseDto;
import uz.darkselect.person_service.entity.IdentityDocument;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Primary
public interface IdentityDocumentMapper {
    IdentityDocumentResponseDto toDto(IdentityDocument entity);
    IdentityDocumentUpdateResponseDto toUpdateDto(IdentityDocument entity);
}
