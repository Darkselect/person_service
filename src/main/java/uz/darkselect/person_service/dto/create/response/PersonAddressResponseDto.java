package uz.darkselect.person_service.dto.create.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.darkselect.person_service.entity.AddressType;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonAddressResponseDto {
    private UUID id;
    private String region;
    private String city;
    private String street;
    private String building;
    private String apartment;
    private AddressType type;
}
