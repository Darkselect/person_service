package uz.darkselect.person_service.dto.create.response;

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
public class ContactResponseDto {
    private UUID id;
    private ContactType contactType;
    private String contactValue;
    private Boolean isPrimary;
}
