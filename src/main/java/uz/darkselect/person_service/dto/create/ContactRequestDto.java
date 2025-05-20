package uz.darkselect.person_service.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.darkselect.person_service.entity.ContactType;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ContactRequestDto {
    private ContactType contactType;
    private String contactValue;
    private Boolean isPrimary;
}
