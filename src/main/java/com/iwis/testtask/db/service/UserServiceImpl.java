package com.iwis.testtask.db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iwis.testtask.db.entity.Role;
import com.iwis.testtask.db.entity.RoleType;
import com.iwis.testtask.db.entity.User;
import com.iwis.testtask.db.repository.RoleRepo;
import com.iwis.testtask.db.repository.UserRepoImpl;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserRepoImpl userRepo;

	@Autowired
	private RoleRepo roleRepo;

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(userId);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		Set<GrantedAuthority> grantedAuthorities = this.getAuthorities(user);

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}

	private Set<GrantedAuthority> getAuthorities(User user) {
		Set<Role> roleByUserId = user.getRoles();
		final Set<GrantedAuthority> authorities = roleByUserId.stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName().toString().toUpperCase()))
				.collect(Collectors.toSet());
		return authorities;
	}
	
	public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepo.findAll().iterator().forEachRemaining(user -> users.add(user));
        return users;
    }
	@Override
    public User findOne(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public User save(User user) {
        User userWithDuplicateUsername = userRepo.findByUsername(user.getUsername());
        if(userWithDuplicateUsername != null && user.getId() != userWithDuplicateUsername.getId()) {
            throw new RuntimeException("Duplicate username.");
        }
        User userWithDuplicateEmail = userRepo.findByEmail(user.getEmail());
        if(userWithDuplicateEmail != null && user.getId() != userWithDuplicateEmail.getId()) {
            throw new RuntimeException("Duplicate email.");
        }
        
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        List<RoleType> roleTypes = new ArrayList<>();
        newUser.getRoles().stream().map(role -> roleTypes.add(RoleType.valueOf(role)));
        user.setRoles(roleRepo.findAll(user.getRoles()));
        userRepo.save(user);
        return user;
    }

}
