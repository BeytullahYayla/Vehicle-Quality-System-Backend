package com.bit.CVQS.core.services;

import com.bit.CVQS.service.Abstract.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements org.springframework.security.core.userdetails.UserDetailsService {


    @Autowired
    private UserService userService;








  //  private List<com.bit.CVQS.domain.Concrete.User> users=this.userService.getAll().getData();
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<com.bit.CVQS.domain.Concrete.User> users=this.userService.getAll().getData();

       if (users.contains(this.userService.getByUserName(username).getData())){
            return new User(username,this.userService.getByUserName(username).getData().getPassword(),new ArrayList<>());
        }

        throw new UsernameNotFoundException(username);

    }
}
