package coding.hrms.business.adapters.mernisService;

import com.sun.istack.NotNull;

import coding.hrms.business.adapters.NotBlank;
import coding.hrms.business.adapters.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonForValidateFromMernisService {
	@NotNull
	private long identification_number;

	@NotBlank
	String name;

	@NotBlank
	String surname;

	@Past
	int birthdate;
}
