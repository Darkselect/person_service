package uz.darkselect.person_service.dto.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.darkselect.person_service.entity.AddressType;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonAddressRequestDto {
    @NotBlank
    private String region;

    @NotBlank
    private String city;

    @NotBlank
    private String street;
    private String building;
    private String apartment;

    @NotNull
    private AddressType type;
}
