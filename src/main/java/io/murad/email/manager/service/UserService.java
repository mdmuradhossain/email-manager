package io.murad.email.manager.service;

import io.murad.email.manager.model.User;
import io.murad.email.manager.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> checkUser = userRepository.findByUsername(username);
        User user = checkUser.orElseThrow(() -> new UsernameNotFoundException("User name not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }

    public void register(User user) {
        User saveUser = new User();
        saveUser.setUsername(user.getUsername());
        saveUser.setPassword(passwordEncoder.encode(user.getPassword()));
        saveUser.setFullname(user.getFullname());
        userRepository.save(saveUser);
    }
}