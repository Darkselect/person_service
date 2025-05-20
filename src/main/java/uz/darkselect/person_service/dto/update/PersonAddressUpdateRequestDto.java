package uz.darkselect.person_service.dto.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class PersonAddressUpdateRequestDto {
    @NotNull(message = "id must not be null")
    private UUID personAddressId;

    @NotNull(message = "id must not be null")
    private UUID addressId;

    @NotBlank(message = "Region is required")
    private String region;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "Street is required")
    private String street;
    private String building;
    private String apartment;

    @NotNull
    private AddressType type;
}
