package com.example.user.service.Concrete;



import com.example.user.core.results.*;
import com.example.user.dao.UserDao;
import com.example.user.domain.Role;
import com.example.user.domain.User;
import com.example.user.service.Abstract.UserService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    @Autowired

    private UserDao userDao;

    @Autowired
    private EntityManager entityManager;


    @Override
    public DataResult<List<User>> getAll() {



        return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Users Listed");
    }



    @Override
    public DataResult<User> getById(int id) {
        return new SuccessDataResult<User>(this.userDao.findById(id).get(),"User Listed By Id");
    }



    @Override
    public DataResult<List<User>> getByRole(Role role) {
        return null;
    }



    @Override
    public DataResult<User> getByUserName(String userName) {

        return new SuccessDataResult<User>(this.userDao.findUsersByUserName(userName));
    }


    @Override
    public Result add(User user) {
        if (user.getRoles().isEmpty()){
            Role role=new Role();
            role.setId(1);
            role.setName("Operator");
            user.roles.add(role);
        }

        this.userDao.save(user);
        return new SuccessResult("User Added Successfully");
    }


    @Override
    public Result update(User user) {
        if(this.userDao.findById(user.getUserId()).isEmpty()){
            return new ErrorResult("User Doesn't Exist");
        }
        else{
            this.userDao.save(user);
            return new SuccessResult("User Updated Successfully");
        }

    }



    @Override
    public Result delete(int id) {

        this.userDao.softDelete(id);
        return new SuccessResult("User Deleted Successfully");
    }


}
