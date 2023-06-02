package com.example.user.resource;




import com.example.user.core.results.DataResult;
import com.example.user.core.results.ErrorResult;
import com.example.user.core.results.Result;
import com.example.user.core.results.SuccessResult;
import com.example.user.domain.User;
import com.example.user.service.Abstract.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/User")

public class UserController {

    UserService userService;//Dependency Inversion
    public UserController(UserService userService){
        this.userService=userService;//Constructor Injection
    }


    @GetMapping("/getAll")
    public DataResult<List<User>> getAll(){
        log.debug("getAll() method executed");
        if (this.userService.getAll().isSuccess()){
            log.info("getAll() method successfully completed");
            return this.userService.getAll();
        }
        else return null;
    }

    @GetMapping("/getById/{id}")
    public DataResult<User> getById(@PathVariable int id){
        log.debug("getById() method executed");
        if (this.userService.getById(id).isSuccess()){
            log.info("getById() method successfully completed");
            return this.userService.getById(id);
        }
        else return null;
    }


    @PostMapping("/add")
    public Result add(@RequestBody User user){

        try{
            this.userService.add(user);
            log.info("User added successfully");
            return new SuccessResult("User Added Successfully");
        }
        catch (Exception e){
            log.error("Error occured while adding user. User id:"+user.getUserId());
            return new ErrorResult("An error occured while adding user");
        }



    }

    @PutMapping("/update")
    public Result update(@RequestBody User user){

            try{
                this.userService.update(user);
                log.info("User updated successfully. User Id: "+user.getUserId());
                return new SuccessResult("User updated successfully.");
            }
            catch (Exception e){

                log.error("Error occurred while updating user. User Id: " + user.getUserId(), e);
                return new ErrorResult("An error occurred while deleting user");

            }





    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
        try {
            this.userService.delete(id);
            log.info("User Deleted Successfully. User Id: " + id);
            return new SuccessResult("User Deleted Successfully");
        } catch (Exception ex) {
            log.error("Error occurred while deleting user. User Id: " + id, ex);
            return new ErrorResult("An error occurred while deleting user");
        }

    }
    @GetMapping("/getUserByUserName/{userName}")
    public DataResult<User> getByUserName(@PathVariable String userName){
        return this.userService.getByUserName(userName);
    }

}
