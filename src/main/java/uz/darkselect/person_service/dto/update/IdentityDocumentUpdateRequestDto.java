package uz.darkselect.person_service.dto.update;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class IdentityDocumentUpdateRequestDto {
    @NotNull(message = "id must not be null")
    private UUID id;

    @NotBlank(message = "Document type is required")
    private String docType;

    @NotBlank(message = "Document number is required")
    private String docNumber;
    private String issuedBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate issueDate;
}
