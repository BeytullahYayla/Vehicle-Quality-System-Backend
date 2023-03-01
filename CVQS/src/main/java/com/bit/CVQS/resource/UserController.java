package com.bit.CVQS.resource;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.domain.concrete.User;
import com.bit.CVQS.service.Abstract.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/api/User")

public class UserController {

    UserService userService;//Dependency Inversion
    public UserController(UserService userService){
        this.userService=userService;//Constructor Injection
    }


    @GetMapping("/getAll")
    public DataResult<List<User>> getAll(){
        if (this.userService.getAll().isSuccess()){
            return this.userService.getAll();
        }
        else return null;
    }

    /*
    @PostMapping("/add")
    public Result add(@RequestBody User user){
        user.roles.add()
        return null;
    }*/


}
