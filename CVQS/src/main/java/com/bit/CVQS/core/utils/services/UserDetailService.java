package com.bit.CVQS.core.utils.services;

import com.bit.CVQS.dao.Abstract.UserDao;
import com.bit.CVQS.domain.Abstract.Entity;
import com.bit.CVQS.domain.Concrete.Role;
import com.bit.CVQS.domain.Concrete.User;

import com.bit.CVQS.service.Abstract.Abstract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailService implements org.springframework.security.core.userdetails.UserDetailsService {


    @Autowired
    private UserDao userDao;








  //  private List<com.bit.CVQS.domain.Concrete.User> users=this.userService.getAll().getData();
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=this.userDao.findUsersByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));


    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
       return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }
}
