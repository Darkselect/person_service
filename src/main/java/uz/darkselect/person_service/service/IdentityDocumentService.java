package uz.darkselect.person_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.darkselect.person_service.asspect.annotation.AllAspect;
import uz.darkselect.person_service.dto.create.IdentityDocumentRequestDto;
import uz.darkselect.person_service.dto.update.IdentityDocumentUpdateRequestDto;
import uz.darkselect.person_service.entity.IdentityDocument;
import uz.darkselect.person_service.entity.Person;
import uz.darkselect.person_service.exception.IdentityDocumentNotFoundException;
import uz.darkselect.person_service.repository.IdentityDocumentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IdentityDocumentService {
    private final IdentityDocumentRepository identityDocumentRepository;

    @Transactional
    @AllAspect
    public List<IdentityDocument> createDocumentsForPerson(List<IdentityDocumentRequestDto> dtoList, Person person) {
        if (dtoList == null || dtoList.isEmpty()) return List.of();

        List<IdentityDocument> documents = dtoList.stream()
                .map(dto -> IdentityDocument.builder()
                        .person(person)
                        .docType(dto.getDocType())
                        .docNumber(dto.getDocNumber())
                        .issuedBy(dto.getIssuedBy())
                        .issueDate(dto.getIssueDate())
                        .build()
                ).toList();

        return identityDocumentRepository.saveAll(documents);
    }

    @Transactional
    @AllAspect
    public List<IdentityDocument> updateDocumentsForPerson(List<IdentityDocumentUpdateRequestDto> dtoList) {
        List<IdentityDocument> documents = new ArrayList<>();

        for (IdentityDocumentUpdateRequestDto dto : dtoList) {
            IdentityDocument document = identityDocumentRepository.findById(dto.getId())
                    .orElseThrow(() -> new IdentityDocumentNotFoundException(String.format("Identity document not found: %s", dto.getId())));
            document.setDocType(dto.getDocType());
            document.setDocNumber(dto.getDocNumber());
            document.setIssuedBy(dto.getIssuedBy());
            document.setIssueDate(dto.getIssueDate());

            documents.add(identityDocumentRepository.save(document));
        }
        return documents;
    }
}
