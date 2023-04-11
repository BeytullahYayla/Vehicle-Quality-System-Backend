package com.bit.CVQS.resource;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.core.utils.results.SuccessResult;
import com.bit.CVQS.domain.Concrete.User;

import com.bit.CVQS.service.Abstract.UserService;



import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getById/{id}")
    public DataResult<User> getById(@PathVariable int id){
        if (this.userService.getById(id).isSuccess()){
            return this.userService.getById(id);
        }
        else return null;
    }


    @PostMapping("/add")
    public Result add(@RequestBody User user){


        this.userService.add(user);
        return new SuccessResult("User Added Successfully");
    }

    @PutMapping("/update")
    public Result update(@RequestBody User user){

        this.userService.update(user);
        return new SuccessResult("User Updated Successfully");
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
        this.userService.delete(id);
        return new SuccessResult("User Deleted Successfully");
    }
    @GetMapping("/getUserByUserName/{userName}")
    public DataResult<User> getByUserName(@PathVariable String userName){
        return this.userService.getByUserName(userName);
    }

}
