package coding.hrms.entities.dtos;

import javax.validation.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceSaveDto {
    private int resumeId;

    @NotEmpty
    @NotBlank
    private String companyName;

    @NotEmpty
    @NotBlank
    private String positionName;

    @NotEmpty
    @NotBlank
    private int startYear;

    private int endYear;
}
