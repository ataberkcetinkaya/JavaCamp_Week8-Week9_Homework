package coding.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import coding.hrms.business.adapters.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employer extends User {
	@NotBlank
	@Size(max = 100, min = 0)
	@Column(name = "company_name")
	private String companyName;

	@NotBlank
	@Size(max = 100, min = 0)
	@Column(name = "website")
	private String website;

	@NotBlank
	@Size(max = 100, min = 0)
	@Column(name = "corporate_email")
	private String corporateEmail;

	@NotBlank
	@Size(max = 15, min = 0)
	@Column(name = "phone")
	private String phone;

	@Builder(builderMethodName = "childBuilder")
	public Employer(@NotBlank @Email @Size(max = 100, min = 0) final String email,
			@NotBlank @Size(max = 100, min = 0) final String password, @NotBlank @Size(max = 100, min = 0) final String companyName,
			@NotBlank @Size(max = 100, min = 0) final String website, @NotBlank @Size(max = 100, min = 0) final String corporateEmail,
			@NotBlank @Size(max = 15, min = 0) final String phone) {
		super(email, password);
		this.companyName = companyName;
		this.website = website;
		this.corporateEmail = corporateEmail;
		this.phone = phone;
	}
}