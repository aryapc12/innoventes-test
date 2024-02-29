package com.innoventes.test.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "company")
@Entity
public class Company extends BaseEntity {

	@Id
	@SequenceGenerator(sequenceName = "company_seq", allocationSize = 1, name = "company_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	private Long id;

	@Column(name = "company_name")
	@NotBlank(message = "company name can not be empty and is mandatory")
	@size(min = 5, message="company name must be at least 5 character long")
	private String companyName;

	@Column(name = "email")
	@NotBlank(message = "email is mandatory")
	@Email(message="email should be valid")
	private String email;
	
	@Column(name = "strength")
	@Min(value=0,message="strength must be positive or zero")
	private Integer strength;
	
	@Column(name = "website_url")
	private String webSiteURL;
	
	@Column(name = "company_code", unique=true)
	@Pattern(regexp="^[A-Za-z]{2}\\d{2}[EeNn]$", message="Invalid company code")
	private String companyCode;
}
