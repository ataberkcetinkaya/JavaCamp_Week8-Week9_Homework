package coding.hrms.entities.dtos;

import java.time.LocalDateTime;

import coding.hrms.business.adapters.NotBlank;
import coding.hrms.business.adapters.Past;
import coding.hrms.core.entities.Dto;
import coding.hrms.entities.concretes.Future;
import coding.hrms.entities.concretes.Positive;
import coding.hrms.entities.concretes.Size;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class JobAdvertForListDto implements Dto {
	@NotBlank
	@Size(max = 100, min = 0)
	private String companyName;

	@NotBlank
	@Size(max = 50, min = 0)
	private String title;

	@Positive
	private int numberOfOpenPositions;

	@Past
	private LocalDateTime createdAt;

	@Future
	private LocalDateTime applicationDeadline;

	@Builder
	public JobAdvertForListDto(@NotBlank @Size(max = 100, min = 0) final String companyName,
			@NotBlank @Size(max = 50, min = 0) final String title, @Positive final int numberOfOpenPositions,
			@Past final LocalDateTime createdAt, @Future final LocalDateTime applicationDeadline) {
		this.companyName = companyName;
		this.title = title;
		this.numberOfOpenPositions = numberOfOpenPositions;
		this.createdAt = createdAt;
		this.applicationDeadline = applicationDeadline;
	}
}
