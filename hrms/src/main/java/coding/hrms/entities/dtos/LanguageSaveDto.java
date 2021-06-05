package coding.hrms.entities.dtos;

import javax.validation.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageSaveDto {
    private int resumeId;

    @NotEmpty
    @NotBlank
    private String languageName;

    @NotEmpty
    @NotBlank
    private int languageLevel;
}