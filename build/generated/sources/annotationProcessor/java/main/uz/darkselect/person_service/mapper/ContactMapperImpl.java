package uz.darkselect.person_service.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.darkselect.person_service.dto.create.response.ContactResponseDto;
import uz.darkselect.person_service.dto.update.response.ContactUpdateResponseDto;
import uz.darkselect.person_service.entity.Contact;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T13:32:38+0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class ContactMapperImpl implements ContactMapper {

    @Override
    public ContactResponseDto toDto(Contact entity) {
        if ( entity == null ) {
            return null;
        }

        ContactResponseDto.ContactResponseDtoBuilder contactResponseDto = ContactResponseDto.builder();

        contactResponseDto.id( entity.getId() );
        contactResponseDto.contactType( entity.getContactType() );
        contactResponseDto.contactValue( entity.getContactValue() );
        contactResponseDto.isPrimary( entity.getIsPrimary() );

        return contactResponseDto.build();
    }

    @Override
    public ContactUpdateResponseDto toUpdateDto(Contact entity) {
        if ( entity == null ) {
            return null;
        }

        ContactUpdateResponseDto.ContactUpdateResponseDtoBuilder contactUpdateResponseDto = ContactUpdateResponseDto.builder();

        contactUpdateResponseDto.id( entity.getId() );
        contactUpdateResponseDto.contactType( entity.getContactType() );
        contactUpdateResponseDto.contactValue( entity.getContactValue() );
        contactUpdateResponseDto.isPrimary( entity.getIsPrimary() );

        return contactUpdateResponseDto.build();
    }
}
