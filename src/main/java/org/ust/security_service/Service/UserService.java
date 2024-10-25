package org.ust.security_service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.ust.security_service.repo.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder =new BCryptPasswordEncoder(12);
    @Autowired
   private AuthenticationManagerBuilder authenticationManagerBuilder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public User register(User user) {
        user.getPassword();//some action left
         repo.save(user);
        return  user;
    }
    public String verify(User user)
    {
        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated())
        {
            return jwtService .generatedToken(user.getUsername());
        }
        else {
            return "failed";
        }
    }
}
