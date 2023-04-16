package com.bit.CVQS.core.utils.security;



import com.bit.CVQS.core.utils.services.UserDetailService;
import com.bit.CVQS.core.utils.security.filters.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    AuthenticationConfiguration authConfiguration;

    @Autowired
    UserDetailService userDetailsService;

    @Autowired
    JwtAuthEntryPoint jwtAuthEntryPoint;


    @Autowired
    JwtFilter jwtFilter;




    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(this.jwtAuthEntryPoint)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                        .requestMatchers("/api/Authentication/authenticate","/api/Authentication/register").permitAll()
                //.requestMatchers("/api/User/**").hasRole("Admin")
                .requestMatchers("/api/Defects/add").hasRole("OPERATOR")
                .requestMatchers("/api/Defects/getAll","/api/Defects/getAllByPage/{pageNumber}/{pageSize}" ,
                        "/api/Defects/getAllBySortedPage/{pageNumber}/{pageSize}" ,
                        "/api/Defects/getDefectsWithFilter").hasRole("Team Lead")
                .requestMatchers("/**").permitAll()
                .anyRequest().authenticated().and()
                        .httpBasic();

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }







    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
