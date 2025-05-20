package uz.darkselect.person_service.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.darkselect.person_service.dto.create.PersonCreateRequestDto;
import uz.darkselect.person_service.dto.create.response.PersonResponseDto;
import uz.darkselect.person_service.dto.update.PersonUpdateRequestDto;
import uz.darkselect.person_service.dto.update.response.PersonUpdateResponseDto;

import java.util.UUID;

public interface PersonService {
    PersonResponseDto create(PersonCreateRequestDto dto);
    PersonUpdateResponseDto update(UUID personId, PersonUpdateRequestDto dto);
    Page<PersonResponseDto> getAllVisiblePersons(String region, Pageable pageable);
    PersonResponseDto getPersonById(UUID personId);
    boolean verifyFullNameAndPassport(String fullName, String passportNumber);
}
