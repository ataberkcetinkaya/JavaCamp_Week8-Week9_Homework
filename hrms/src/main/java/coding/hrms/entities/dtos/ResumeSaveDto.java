package coding.hrms.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeSaveDto {
    private int employeeId;
    private String description;
    private String githubUrl;
    private String linkedinUrl;

    private List<Integer> abilities;
    private List<Integer> images;
    private List<Integer> schools;
    private List<Integer> jobExperiences;
    private List<Integer> languages;
}
