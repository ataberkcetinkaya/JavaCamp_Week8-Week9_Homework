package coding.hrms.entities.dtos;

import coding.hrms.business.adapters.NotBlank;
import coding.hrms.core.entities.Dto;
import coding.hrms.entities.concretes.Email;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class EmailActivationForVerifyDto implements Dto {
	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String activationCode;

	@Builder
	public EmailActivationForVerifyDto(@NotBlank @Email final String email, @NotBlank final String activationCode) {
		this.email = email;
		this.activationCode = activationCode;
	}
}
