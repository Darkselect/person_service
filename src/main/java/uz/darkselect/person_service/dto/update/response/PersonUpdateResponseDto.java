package uz.darkselect.person_service.dto.update.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonUpdateResponseDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String middleName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate bornDate;

    private List<IdentityDocumentUpdateResponseDto> documents;
    private List<PersonAddressUpdateResponseDto> addresses;
    private List<ContactUpdateResponseDto> contacts;
    private Boolean hidden;
}
