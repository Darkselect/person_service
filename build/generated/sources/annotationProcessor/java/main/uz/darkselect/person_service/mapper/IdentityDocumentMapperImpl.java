package uz.darkselect.person_service.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.darkselect.person_service.dto.create.response.IdentityDocumentResponseDto;
import uz.darkselect.person_service.dto.update.response.IdentityDocumentUpdateResponseDto;
import uz.darkselect.person_service.entity.IdentityDocument;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T13:32:38+0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class IdentityDocumentMapperImpl implements IdentityDocumentMapper {

    @Override
    public IdentityDocumentResponseDto toDto(IdentityDocument entity) {
        if ( entity == null ) {
            return null;
        }

        IdentityDocumentResponseDto.IdentityDocumentResponseDtoBuilder identityDocumentResponseDto = IdentityDocumentResponseDto.builder();

        identityDocumentResponseDto.id( entity.getId() );
        identityDocumentResponseDto.docType( entity.getDocType() );
        identityDocumentResponseDto.docNumber( entity.getDocNumber() );
        identityDocumentResponseDto.issuedBy( entity.getIssuedBy() );
        identityDocumentResponseDto.issueDate( entity.getIssueDate() );

        return identityDocumentResponseDto.build();
    }

    @Override
    public IdentityDocumentUpdateResponseDto toUpdateDto(IdentityDocument entity) {
        if ( entity == null ) {
            return null;
        }

        IdentityDocumentUpdateResponseDto.IdentityDocumentUpdateResponseDtoBuilder identityDocumentUpdateResponseDto = IdentityDocumentUpdateResponseDto.builder();

        identityDocumentUpdateResponseDto.id( entity.getId() );
        identityDocumentUpdateResponseDto.docType( entity.getDocType() );
        identityDocumentUpdateResponseDto.docNumber( entity.getDocNumber() );
        identityDocumentUpdateResponseDto.issuedBy( entity.getIssuedBy() );
        identityDocumentUpdateResponseDto.issueDate( entity.getIssueDate() );

        return identityDocumentUpdateResponseDto.build();
    }
}
