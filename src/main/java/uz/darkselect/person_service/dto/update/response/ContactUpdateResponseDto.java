package uz.darkselect.person_service.dto.update.response;

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
public class ContactUpdateResponseDto {
    private UUID id;
    private ContactType contactType;
    private String contactValue;
    private Boolean isPrimary;
}
