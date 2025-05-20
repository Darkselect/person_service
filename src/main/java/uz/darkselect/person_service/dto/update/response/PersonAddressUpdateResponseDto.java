package uz.darkselect.person_service.dto.update.response;

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
public class PersonAddressUpdateResponseDto {
    private UUID personAddressId;
    private UUID addressId;
    private String region;
    private String city;
    private String street;
    private String building;
    private String apartment;
    private AddressType type;
}
