package com.bit.CVQS.service.Concrete;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.core.utils.results.SuccessDataResult;
import com.bit.CVQS.core.utils.results.SuccessResult;
import com.bit.CVQS.dao.Abstract.UserDao;
import com.bit.CVQS.domain.Concrete.Role;
import com.bit.CVQS.domain.Concrete.User;
import com.bit.CVQS.service.Abstract.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    UserDao userDao;
    public UserManager(UserDao userDao){
        this.userDao=userDao;
    }
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
    public Result add(User user) {
        Role role=new Role();
        role.setId(1);
        role.setName("Operator");
        user.roles.add(role);
        this.userDao.save(user);
        return new SuccessResult("User Added Successfully");
    }

    @Override
    public Result update(User user) {
        return null;
    }
}
