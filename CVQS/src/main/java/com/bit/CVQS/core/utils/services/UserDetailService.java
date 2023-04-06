package com.bit.CVQS.core.utils.services;

import com.bit.CVQS.domain.Concrete.User;

import com.bit.CVQS.service.Abstract.Abstract.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailService implements org.springframework.security.core.userdetails.UserDetailsService {


    @Autowired
    private UserService userService;








  //  private List<com.bit.CVQS.domain.Concrete.User> users=this.userService.getAll().getData();
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*
        List<com.bit.CVQS.domain.Concrete.User> users=this.userService.getAll().getData();

       if (users.contains(this.userService.getByUserName(username).getData())){
            return new User(username,this.userService.getByUserName(username).getData().getPassword(),new ArrayList<>());
        }
*/
        User user=this.userService.getByUserName(username).getData();
        if(username.toString()=="iremx"){
            return new org.springframework.security.core.userdetails.User(username,this.userService.getByUserName(username).getData().getPassword(),new ArrayList<>());
        }

        throw new UsernameNotFoundException(username);

    }
}
