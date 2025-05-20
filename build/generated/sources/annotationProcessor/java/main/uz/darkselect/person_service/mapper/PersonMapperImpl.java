package uz.darkselect.person_service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.darkselect.person_service.dto.create.ContactRequestDto;
import uz.darkselect.person_service.dto.create.IdentityDocumentRequestDto;
import uz.darkselect.person_service.dto.create.PersonCreateRequestDto;
import uz.darkselect.person_service.dto.create.response.ContactResponseDto;
import uz.darkselect.person_service.dto.create.response.IdentityDocumentResponseDto;
import uz.darkselect.person_service.dto.create.response.PersonAddressResponseDto;
import uz.darkselect.person_service.dto.create.response.PersonResponseDto;
import uz.darkselect.person_service.dto.update.response.ContactUpdateResponseDto;
import uz.darkselect.person_service.dto.update.response.IdentityDocumentUpdateResponseDto;
import uz.darkselect.person_service.dto.update.response.PersonAddressUpdateResponseDto;
import uz.darkselect.person_service.dto.update.response.PersonUpdateResponseDto;
import uz.darkselect.person_service.entity.Contact;
import uz.darkselect.person_service.entity.IdentityDocument;
import uz.darkselect.person_service.entity.Person;
import uz.darkselect.person_service.entity.PersonAddress;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T13:32:38+0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Autowired
    private IdentityDocumentMapper identityDocumentMapper;
    @Autowired
    private ContactMapper contactMapper;
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Person toEntity(PersonCreateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Person.PersonBuilder person = Person.builder();

        person.lastName( dto.getLastName() );
        person.firstName( dto.getFirstName() );
        person.middleName( dto.getMiddleName() );
        person.bornDate( dto.getBornDate() );
        person.documents( identityDocumentRequestDtoListToIdentityDocumentList( dto.getDocuments() ) );
        person.contacts( contactRequestDtoListToContactList( dto.getContacts() ) );

        return person.build();
    }

    @Override
    public PersonResponseDto toDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonResponseDto.PersonResponseDtoBuilder personResponseDto = PersonResponseDto.builder();

        personResponseDto.documents( identityDocumentListToIdentityDocumentResponseDtoList( person.getDocuments() ) );
        personResponseDto.contacts( contactListToContactResponseDtoList( person.getContacts() ) );
        personResponseDto.addresses( personAddressListToPersonAddressResponseDtoList( person.getPersonAddresses() ) );
        personResponseDto.id( person.getId() );
        personResponseDto.firstName( person.getFirstName() );
        personResponseDto.lastName( person.getLastName() );
        personResponseDto.middleName( person.getMiddleName() );
        personResponseDto.bornDate( person.getBornDate() );
        personResponseDto.hidden( person.getHidden() );

        return personResponseDto.build();
    }

    @Override
    public PersonUpdateResponseDto toResponseDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonUpdateResponseDto.PersonUpdateResponseDtoBuilder personUpdateResponseDto = PersonUpdateResponseDto.builder();

        personUpdateResponseDto.documents( identityDocumentListToIdentityDocumentUpdateResponseDtoList( person.getDocuments() ) );
        personUpdateResponseDto.contacts( contactListToContactUpdateResponseDtoList( person.getContacts() ) );
        personUpdateResponseDto.addresses( personAddressListToPersonAddressUpdateResponseDtoList( person.getPersonAddresses() ) );
        personUpdateResponseDto.id( person.getId() );
        personUpdateResponseDto.firstName( person.getFirstName() );
        personUpdateResponseDto.lastName( person.getLastName() );
        personUpdateResponseDto.middleName( person.getMiddleName() );
        personUpdateResponseDto.bornDate( person.getBornDate() );
        personUpdateResponseDto.hidden( person.getHidden() );

        return personUpdateResponseDto.build();
    }

    protected IdentityDocument identityDocumentRequestDtoToIdentityDocument(IdentityDocumentRequestDto identityDocumentRequestDto) {
        if ( identityDocumentRequestDto == null ) {
            return null;
        }

        IdentityDocument.IdentityDocumentBuilder identityDocument = IdentityDocument.builder();

        identityDocument.docType( identityDocumentRequestDto.getDocType() );
        identityDocument.docNumber( identityDocumentRequestDto.getDocNumber() );
        identityDocument.issuedBy( identityDocumentRequestDto.getIssuedBy() );
        identityDocument.issueDate( identityDocumentRequestDto.getIssueDate() );

        return identityDocument.build();
    }

    protected List<IdentityDocument> identityDocumentRequestDtoListToIdentityDocumentList(List<IdentityDocumentRequestDto> list) {
        if ( list == null ) {
            return null;
        }

        List<IdentityDocument> list1 = new ArrayList<IdentityDocument>( list.size() );
        for ( IdentityDocumentRequestDto identityDocumentRequestDto : list ) {
            list1.add( identityDocumentRequestDtoToIdentityDocument( identityDocumentRequestDto ) );
        }

        return list1;
    }

    protected Contact contactRequestDtoToContact(ContactRequestDto contactRequestDto) {
        if ( contactRequestDto == null ) {
            return null;
        }

        Contact.ContactBuilder contact = Contact.builder();

        contact.contactType( contactRequestDto.getContactType() );
        contact.contactValue( contactRequestDto.getContactValue() );
        contact.isPrimary( contactRequestDto.getIsPrimary() );

        return contact.build();
    }

    protected List<Contact> contactRequestDtoListToContactList(List<ContactRequestDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Contact> list1 = new ArrayList<Contact>( list.size() );
        for ( ContactRequestDto contactRequestDto : list ) {
            list1.add( contactRequestDtoToContact( contactRequestDto ) );
        }

        return list1;
    }

    protected List<IdentityDocumentResponseDto> identityDocumentListToIdentityDocumentResponseDtoList(List<IdentityDocument> list) {
        if ( list == null ) {
            return null;
        }

        List<IdentityDocumentResponseDto> list1 = new ArrayList<IdentityDocumentResponseDto>( list.size() );
        for ( IdentityDocument identityDocument : list ) {
            list1.add( identityDocumentMapper.toDto( identityDocument ) );
        }

        return list1;
    }

    protected List<ContactResponseDto> contactListToContactResponseDtoList(List<Contact> list) {
        if ( list == null ) {
            return null;
        }

        List<ContactResponseDto> list1 = new ArrayList<ContactResponseDto>( list.size() );
        for ( Contact contact : list ) {
            list1.add( contactMapper.toDto( contact ) );
        }

        return list1;
    }

    protected List<PersonAddressResponseDto> personAddressListToPersonAddressResponseDtoList(List<PersonAddress> list) {
        if ( list == null ) {
            return null;
        }

        List<PersonAddressResponseDto> list1 = new ArrayList<PersonAddressResponseDto>( list.size() );
        for ( PersonAddress personAddress : list ) {
            list1.add( addressMapper.toDto( personAddress ) );
        }

        return list1;
    }

    protected List<IdentityDocumentUpdateResponseDto> identityDocumentListToIdentityDocumentUpdateResponseDtoList(List<IdentityDocument> list) {
        if ( list == null ) {
            return null;
        }

        List<IdentityDocumentUpdateResponseDto> list1 = new ArrayList<IdentityDocumentUpdateResponseDto>( list.size() );
        for ( IdentityDocument identityDocument : list ) {
            list1.add( identityDocumentMapper.toUpdateDto( identityDocument ) );
        }

        return list1;
    }

    protected List<ContactUpdateResponseDto> contactListToContactUpdateResponseDtoList(List<Contact> list) {
        if ( list == null ) {
            return null;
        }

        List<ContactUpdateResponseDto> list1 = new ArrayList<ContactUpdateResponseDto>( list.size() );
        for ( Contact contact : list ) {
            list1.add( contactMapper.toUpdateDto( contact ) );
        }

        return list1;
    }

    protected List<PersonAddressUpdateResponseDto> personAddressListToPersonAddressUpdateResponseDtoList(List<PersonAddress> list) {
        if ( list == null ) {
            return null;
        }

        List<PersonAddressUpdateResponseDto> list1 = new ArrayList<PersonAddressUpdateResponseDto>( list.size() );
        for ( PersonAddress personAddress : list ) {
            list1.add( addressMapper.toUpdateDto( personAddress ) );
        }

        return list1;
    }
}
