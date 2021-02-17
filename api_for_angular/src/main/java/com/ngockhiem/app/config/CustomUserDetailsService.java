package com.ngockhiem.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ngockhiem.app.entity.UserEntity;
import com.ngockhiem.app.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findByUserName(username);
		if(userEntity == null) {
			throw new UsernameNotFoundException("Not Found This UserName!"); 
		}
		return new CustomeUserDetails(userEntity);
	}

}
