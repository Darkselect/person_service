package uz.darkselect.person_service.dto.update;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.darkselect.person_service.entity.ContactType;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ContactUpdateRequestDto {
    @NotNull(message = "id must not be null")
    private UUID id;
    private ContactType contactType;
    private String contactValue;
    private Boolean isPrimary;
}
