package com.bit.CVQS.service.Concrete;

import com.bit.CVQS.core.utils.results.*;
import com.bit.CVQS.dao.Abstract.UserDao;
import com.bit.CVQS.domain.Concrete.Role;
import com.bit.CVQS.domain.Concrete.User;


import com.bit.CVQS.service.Abstract.Abstract.UserService;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManager implements UserService {
    @Autowired

    private UserDao userDao;

    @Autowired
    private EntityManager entityManager;


    @Override
    public DataResult<List<User>> getAll() {

        List<User> users=this.userDao.findAll();

        return new SuccessDataResult<List<User>>(users,"Users Listed");
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
