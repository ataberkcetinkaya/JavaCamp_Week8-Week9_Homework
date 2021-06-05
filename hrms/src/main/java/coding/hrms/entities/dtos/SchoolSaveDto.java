package coding.hrms.entities.dtos;

import javax.validation.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolSaveDto {
    private int resumeId;

    @NotEmpty
    @NotBlank
    private String school_name;

    @NotEmpty
    @NotBlank
    private String school_department;

    @NotEmpty
    @NotBlank
    private int startYear;


    private int endYear;
}
