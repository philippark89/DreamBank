package com.taejupark.dreambank.user;

import com.taejupark.dreambank.security.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);
    User save(UserRegistrationDto registration);
}

