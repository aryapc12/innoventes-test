package com.innoventes.test.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CompanyDTO {

	@Id
	private Long id;

	@NotBlank(message = "company name can not be empty and is mandatory")
	@size(min = 5, message="company name must be at least 5 character long")
	private String companyName;

	@NotBlank(message = "email is mandatory")
	@Email(message="email should be valid")
	private String email;

	@Column(name = "strength")
	@Min(value=0,message="strength must be positive or zero")
	private Integer strength;
	
	private String webSiteURL;
}
