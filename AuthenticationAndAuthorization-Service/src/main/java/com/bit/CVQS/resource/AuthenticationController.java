package com.bit.CVQS.resource;

import com.bit.CVQS.core.utils.results.ErrorResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.core.utils.results.SuccessResult;
import com.bit.CVQS.core.utils.services.UserDetailService;
import com.bit.CVQS.core.utils.security.jwt.JwtUtility;
import com.bit.CVQS.core.utils.requests.JwtRequest;
import com.bit.CVQS.core.utils.responses.JwtResponse;
import com.bit.CVQS.dao.Abstract.RoleDao;
import com.bit.CVQS.dao.Abstract.UserDao;
import com.bit.CVQS.domain.Concrete.Role;
import com.bit.CVQS.domain.Concrete.User;
import com.bit.CVQS.dto.RegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/Authentication")
public class AuthenticationController {
    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private UserDetailService userDetailsService;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    @PostMapping("/register")
    public Result register(@RequestBody RegisterDto registerDto){
        if (this.userDao.existsByUserName(registerDto.getUserName())){
            return new ErrorResult("Username is already taken!");
        }
        User user=new User();
        user.setUserName(registerDto.getUserName());
        user.setDeleted(Boolean.FALSE);
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        com.bit.CVQS.domain.Concrete.Role roles=roleDao.findByName("OPERATOR").get();
        user.setRoles(Collections.singletonList(roles));

        this.userDao.save(user);

        return new SuccessResult("Registered Successfully");


    }


    @PostMapping("/token")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(),
                    jwtRequest.getPassword()));



        }catch (
                BadCredentialsException e
        ){
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails=userDetailsService.loadUserByUsername(jwtRequest.getUserName());
        final String token=jwtUtility.generateToken(userDetails);

        return new JwtResponse(token);



    }
    @GetMapping("/validate")
    public String validateToken(@RequestParam String token) {
        // Kullanıcı ayrıntılarını elde etmek için UserDetails nesnesini kullanmanız gerekiyor.
        // UserDetails nesnesini nasıl alacağınıza bağlı olarak, bu örnekte yeni bir sınıf örneği oluşturabilir veya önceki bir kullanıcıya dayalı olarak alabilirsiniz.
        final UserDetails userDetails=userDetailsService.loadUserByUsername(jwtUtility.getUsernameFromToken(token));



        if (jwtUtility.validateToken(token, userDetails)) {
            return "Token is valid";
        } else {
            return  "Token is invalid";
        }


    }


}
