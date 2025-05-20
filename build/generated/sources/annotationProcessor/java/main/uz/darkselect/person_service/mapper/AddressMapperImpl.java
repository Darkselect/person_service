package uz.darkselect.person_service.mapper;

import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.darkselect.person_service.dto.create.response.PersonAddressResponseDto;
import uz.darkselect.person_service.dto.update.response.PersonAddressUpdateResponseDto;
import uz.darkselect.person_service.entity.Address;
import uz.darkselect.person_service.entity.PersonAddress;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T13:32:38+0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public PersonAddressResponseDto toDto(PersonAddress entity) {
        if ( entity == null ) {
            return null;
        }

        PersonAddressResponseDto.PersonAddressResponseDtoBuilder personAddressResponseDto = PersonAddressResponseDto.builder();

        personAddressResponseDto.id( entity.getId() );
        personAddressResponseDto.region( entityAddressRegion( entity ) );
        personAddressResponseDto.city( entityAddressCity( entity ) );
        personAddressResponseDto.street( entityAddressStreet( entity ) );
        personAddressResponseDto.building( entityAddressBuilding( entity ) );
        personAddressResponseDto.apartment( entityAddressApartment( entity ) );
        personAddressResponseDto.type( entity.getType() );

        return personAddressResponseDto.build();
    }

    @Override
    public PersonAddressUpdateResponseDto toUpdateDto(PersonAddress entity) {
        if ( entity == null ) {
            return null;
        }

        PersonAddressUpdateResponseDto.PersonAddressUpdateResponseDtoBuilder personAddressUpdateResponseDto = PersonAddressUpdateResponseDto.builder();

        personAddressUpdateResponseDto.addressId( entityAddressId( entity ) );
        personAddressUpdateResponseDto.personAddressId( entity.getId() );
        personAddressUpdateResponseDto.region( entityAddressRegion( entity ) );
        personAddressUpdateResponseDto.city( entityAddressCity( entity ) );
        personAddressUpdateResponseDto.street( entityAddressStreet( entity ) );
        personAddressUpdateResponseDto.building( entityAddressBuilding( entity ) );
        personAddressUpdateResponseDto.apartment( entityAddressApartment( entity ) );
        personAddressUpdateResponseDto.type( entity.getType() );

        return personAddressUpdateResponseDto.build();
    }

    private String entityAddressRegion(PersonAddress personAddress) {
        if ( personAddress == null ) {
            return null;
        }
        Address address = personAddress.getAddress();
        if ( address == null ) {
            return null;
        }
        String region = address.getRegion();
        if ( region == null ) {
            return null;
        }
        return region;
    }

    private String entityAddressCity(PersonAddress personAddress) {
        if ( personAddress == null ) {
            return null;
        }
        Address address = personAddress.getAddress();
        if ( address == null ) {
            return null;
        }
        String city = address.getCity();
        if ( city == null ) {
            return null;
        }
        return city;
    }

    private String entityAddressStreet(PersonAddress personAddress) {
        if ( personAddress == null ) {
            return null;
        }
        Address address = personAddress.getAddress();
        if ( address == null ) {
            return null;
        }
        String street = address.getStreet();
        if ( street == null ) {
            return null;
        }
        return street;
    }

    private String entityAddressBuilding(PersonAddress personAddress) {
        if ( personAddress == null ) {
            return null;
        }
        Address address = personAddress.getAddress();
        if ( address == null ) {
            return null;
        }
        String building = address.getBuilding();
        if ( building == null ) {
            return null;
        }
        return building;
    }

    private String entityAddressApartment(PersonAddress personAddress) {
        if ( personAddress == null ) {
            return null;
        }
        Address address = personAddress.getAddress();
        if ( address == null ) {
            return null;
        }
        String apartment = address.getApartment();
        if ( apartment == null ) {
            return null;
        }
        return apartment;
    }

    private UUID entityAddressId(PersonAddress personAddress) {
        if ( personAddress == null ) {
            return null;
        }
        Address address = personAddress.getAddress();
        if ( address == null ) {
            return null;
        }
        UUID id = address.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
