package com.spect.config;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.stereotype.Service;

import com.spect.dao.UserRepository;
import com.spect.model.CustomUserDetails;
import com.spect.model.SpUserEntity;
import com.spect.util.Constants;

@Service
@PropertySource({ "classpath:application.properties" })
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * This method is used to load a user by accessing userName
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDetails userDetails = null;
		// Find by username
		try {
			SpUserEntity userEntity = userRepository.findByPhMobileOrLoginNameOrEmailId(username, username , username);
			if (!(userEntity == null)) {

				String role = userEntity.getUserType() == 1 ? Constants.DOCTER : Constants.ADMIN;

				// assign grant authority based on role
				GrantedAuthority authority = new SimpleGrantedAuthority(role);

				userDetails = new CustomUserDetails(userEntity.getUserId(), userEntity.getPhMobile(), userEntity.getLoginPassword(), true, true,
						true, true, Arrays.asList(authority));

			} else {
				throw new UnapprovedClientAuthenticationException("Username " + username + " not Active");
			}
			return userDetails;
		} catch (Exception e) {
			throw new UsernameNotFoundException("Username " + username + " not found");
		}
	}
}
