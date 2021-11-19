package io.murad.email.manager.service;

import io.murad.email.manager.model.User;
import io.murad.email.manager.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> checkUser = userRepository.findByUsername(username);
        User user = checkUser.orElseThrow(() -> new UsernameNotFoundException("User name not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }

    public void register(User user) {
        userRepository.save(user);
    }
}