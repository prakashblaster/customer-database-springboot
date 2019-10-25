package in.dotworld.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.dotworld.database.exception.ResourceNotFoundException;
import in.dotworld.database.model.User;
import in.dotworld.database.model.UserPrincipal;
import in.dotworld.database.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository uRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = uRepository.findByUsernameOrEmail(username, username).orElseThrow(
				() -> new UsernameNotFoundException("User not found with username or email : " + username));
		return UserPrincipal.create(user);
	}

	@Transactional
	public UserDetails loadUserById(Long id) {
		User user = uRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return UserPrincipal.create(user);
	}
}