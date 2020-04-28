package com.fms.fmsevent.model;

import java.beans.Transient;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private String employeeId;
	
	private String email;
	
	private String mobileNo;
	
	private String EmpName;
	
	private String username;
	
	private String password;

	@JsonIgnore
	private boolean enabled;
	
	@JsonInclude(Include.NON_EMPTY)
	private String role;
	
	@JsonIgnore
	private List<Role> roles;

	@Transient
	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles.stream().map(i -> new SimpleGrantedAuthority(i.name())).collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Transient
	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		return false;
	}

	@Transient
	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return false;
	}

	@Transient
	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Transient
	@Override
	@JsonIgnore
	public boolean isEnabled() {
		return this.enabled;
	}
}
