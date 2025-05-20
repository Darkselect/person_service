package uz.darkselect.person_service.service;

import uz.darkselect.person_service.dto.create.ContactRequestDto;
import uz.darkselect.person_service.dto.update.ContactUpdateRequestDto;
import uz.darkselect.person_service.entity.Contact;
import uz.darkselect.person_service.entity.Person;

import java.util.List;

public interface ContactService {
    List<Contact> createContactsForPerson(List<ContactRequestDto> dtos, Person person);
    List<Contact> updateContactEntities(List<ContactUpdateRequestDto> dtos);
}
