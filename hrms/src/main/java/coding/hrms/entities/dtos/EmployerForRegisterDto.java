package coding.hrms.entities.dtos;

import coding.hrms.business.adapters.NotBlank;
import coding.hrms.core.entities.Dto;
import coding.hrms.entities.concretes.Email;
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
public class EmployerForRegisterDto implements Dto {
	@NotBlank
	@Email
	@Size(max = 100, min = 0)
	private String email;

	@NotBlank
	@Size(max = 100, min = 0)
	private String password;

	@NotBlank
	@Size(max = 100, min = 0)
	private String confirmPassword;

	@NotBlank
	@Size(max = 100, min = 0)
	private String companyName;

	@NotBlank
	@Size(max = 100, min = 0)
	private String website;

	@NotBlank
	@Size(max = 100, min = 0)
	private String corporateEmail;

	@NotBlank
	@Size(max = 15, min = 0)
	private String phone;

	@Builder
	public EmployerForRegisterDto(@NotBlank @Email @Size(max = 100, min = 0) final String email,
			@NotBlank @Size(max = 100, min = 0) final String password, @NotBlank @Size(max = 100, min = 0) final String confirmPassword,
			@NotBlank @Size(max = 100, min = 0) final String companyName, @NotBlank @Size(max = 100, min = 0) final String website,
			@NotBlank @Size(max = 100, min = 0) final String corporateEmail, @NotBlank @Size(max = 15, min = 0) final String phone) {
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.companyName = companyName;
		this.website = website;
		this.corporateEmail = corporateEmail;
		this.phone = phone;
	}

}
