package com.qingjie.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.qingjie.model.security.Authority;
import com.qingjie.model.security.User;

public final class JwtUserFactory {

	private JwtUserFactory() {

	}

	public static JwtUser create(User user) {
		return new JwtUser(user.getId(), user.getUsername(), user.getPassword(), user.getFirstname(),
				user.getLastname(), user.getEmail(), user.getEnabled(), user.getLastPasswordResetDate(),
				mapToGrantedAuthorities(user.getAuthorities()));
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
		return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName().name()))
				.collect(Collectors.toList());

	}

}
