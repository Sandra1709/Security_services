package org.ust.security_service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.ust.security_service.model.User_access;
import org.ust.security_service.repo.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder =new BCryptPasswordEncoder(12);


    public User_access register(User_access user) {
        user.getPassword();//some action left
         repo.save(user);
        return  user;
    }
    public String verify(String user)
    {

            return jwtService.generatedToken(user);

    }
}
