package com.bit.CVQS;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.dao.Abstract.UserDao;
import com.bit.CVQS.domain.Concrete.User;
import com.bit.CVQS.service.Concrete.UserManager;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserManagerTests {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserManager userService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testUserGetAll(){
        User user1=new User();
        User user2=new User();

        List<User> users= Arrays.asList(user1,user2);

        when(userDao.findAll()).thenReturn(users);

        DataResult<List<User>> result=this.userService.getAll();
        assertNotNull(result);
        assertEquals(users.size(),result.getData().size());
        assertEquals(users,result.getData());

        Mockito.verify(this.userDao,Mockito.times(1)).findAll();



    }
    @Test
    public void testGetById() {
        // Arrange
        int userId = 1;
        User user = new User();
        when(userDao.findById(userId)).thenReturn(Optional.of(user));

        // Act
        DataResult<User> result = userService.getById(userId);

        // Assert
        assertNotNull(result);
        assertTrue(result.isSuccess());
        assertEquals("User Listed By Id", result.getMessage());
        assertEquals(user, result.getData());
    }
    @Test
    public void testGetByUserName() {
        // Arrange
        String userName = "john";
        User user = new User();
        when(userDao.findUsersByUserName(userName)).thenReturn(user);

        // Act
        DataResult<User> result = userService.getByUserName(userName);

        // Assert
        assertNotNull(result);
        assertTrue(result.isSuccess());
        assertEquals(user, result.getData());


    }
    @Test
    public void testAdd() {
        // Arrange
        User user = new User();
        when(userDao.save(user)).thenReturn(user);

        // Act
        Result result = userService.add(user);

        // Assert
        assertNotNull(result);
        assertTrue(result.isSuccess());
        assertEquals("User Added Successfully", result.getMessage());
        verify(userDao, Mockito.times(1)).save(user);
    }
    @Test
    public void testUpdate_ExistingUser() {
        // Arrange
        User user = new User();
        user.setUserId(1);
        when(userDao.findById(user.getUserId())).thenReturn(Optional.of(user));
        when(userDao.save(user)).thenReturn(user);

        // Act
        Result result = userService.update(user);

        // Assert
        assertNotNull(result);
        assertTrue(result.isSuccess());
        assertEquals("User Updated Successfully", result.getMessage());
        verify(userDao, Mockito.times(1)).save(user);
    }

    @Test
    public void testDelete() {
        int userId = 1;

        Result result = userService.delete(userId);

        assertEquals("User Deleted Successfully", result.getMessage());
        verify(userDao).deleteById(userId);
    }

}
