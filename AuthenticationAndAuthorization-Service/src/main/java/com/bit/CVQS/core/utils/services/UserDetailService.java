package com.bit.CVQS.core.utils.services;

import com.bit.CVQS.dao.Abstract.UserDao;
import com.bit.CVQS.domain.Concrete.Role;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.bit.CVQS.domain.Concrete.User user=this.userDao.findUsersByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));


    }


    @Transactional
    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }
}
