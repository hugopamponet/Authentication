package br.com.authentication.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.authentication.enumeration.SexEnum;
import br.com.authentication.enumeration.UsersRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "user")
@Entity(name = "user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsersModel implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "dtBirth", unique = true)
	private LocalDate dtBirth;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "sex", unique = true)
	private SexEnum sex;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "cpf", unique = true)
	private String cpf;
	
	@Column(name = "enterprise", unique = true)
	private String enterprise;
	
	@Column(name = "role", unique = true)
	private UsersRole role;
	
	@Column(name = "login", unique = true)
	private String login;
	
	@Column(name = "password", unique = true)
	private String password;
	
	public UsersModel(String name, LocalDate dtBirth, SexEnum sex, String email, String cpf, String enterprise, UsersRole role, String login, String password) {
		this.name = name;
		this.dtBirth = dtBirth;
		this.sex = sex;
		this.email = email;
		this.cpf = cpf;
		this.enterprise = enterprise;
		this.role = role;
		this.login = login;
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.role == UsersRole.ADMIN)
			return  List.of(
					new SimpleGrantedAuthority("ROLE_ADMIN"),
					new SimpleGrantedAuthority("ROLE_USER")
					);
		else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return login;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
}