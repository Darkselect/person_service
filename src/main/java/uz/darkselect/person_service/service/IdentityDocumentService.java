package uz.darkselect.person_service.service;

import uz.darkselect.person_service.dto.create.IdentityDocumentRequestDto;
import uz.darkselect.person_service.dto.update.IdentityDocumentUpdateRequestDto;
import uz.darkselect.person_service.entity.IdentityDocument;
import uz.darkselect.person_service.entity.Person;

import java.util.List;

public interface IdentityDocumentService {
    List<IdentityDocument> createDocumentsForPerson(List<IdentityDocumentRequestDto> dtoList, Person person);
    List<IdentityDocument> updateDocumentsForPerson(List<IdentityDocumentUpdateRequestDto> dtoList);
}
