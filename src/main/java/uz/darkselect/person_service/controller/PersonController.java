package uz.darkselect.person_service.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import uz.darkselect.person_service.dto.create.PersonCreateRequestDto;
import uz.darkselect.person_service.dto.create.response.VerifyResponseDto;
import uz.darkselect.person_service.dto.update.PersonUpdateRequestDto;
import uz.darkselect.person_service.dto.create.response.PersonResponseDto;
import uz.darkselect.person_service.dto.update.response.PersonUpdateResponseDto;
import uz.darkselect.person_service.service.PersonService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/persons")
@Validated
public class PersonController {
    private final PersonService personService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PersonResponseDto create(@RequestBody @Valid PersonCreateRequestDto dto) {
        return personService.create(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{personId}")
    public PersonUpdateResponseDto update(@PathVariable UUID personId, @RequestBody @Valid PersonUpdateRequestDto dto) {
        return personService.update(personId, dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<PersonResponseDto> getAllVisiblePersons(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String region) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("lastName").ascending());
        return personService.getAllVisiblePersons(region, pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{personId}")
    public PersonResponseDto getPersonById(@PathVariable UUID personId) {
        return personService.getPersonById(personId);
    }

    @GetMapping("/verification")
    @ResponseStatus(HttpStatus.OK)
    public VerifyResponseDto verify(@RequestParam("name") String fullName, @RequestParam("passport") String passportNumber) {
        boolean valid = personService.verifyFullNameAndPassport(fullName, passportNumber);
        return new VerifyResponseDto(valid);
    }
}
