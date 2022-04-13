package com.taejupark.dreambank.service;

import com.taejupark.dreambank.model.User;
import com.taejupark.dreambank.security.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);
    User save(UserRegistrationDto registration);
}

