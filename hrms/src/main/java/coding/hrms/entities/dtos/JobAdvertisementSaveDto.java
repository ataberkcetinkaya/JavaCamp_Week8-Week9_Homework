package coding.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementSaveDto {
    private String description;
    private int cityId;
    private int positionId;
    private int employerId;
    private Date deadline;
    private int minSalary;
    private int maxSalary;
    private int openPositionsAmount;
}
