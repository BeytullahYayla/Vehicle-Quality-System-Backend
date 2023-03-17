package com.bit.CVQS.resource;

import com.bit.CVQS.core.services.UserDetailService;
import com.bit.CVQS.core.utils.jwt.JwtUtility;
import com.bit.CVQS.core.utils.requests.JwtRequest;
import com.bit.CVQS.core.utils.responses.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Authentication")
public class AuthenticationController {
    @Autowired
    JwtUtility jwtUtility;

    @Autowired
    UserDetailService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
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
}
