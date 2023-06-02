package com.example.user;


import com.example.user.core.results.DataResult;
import com.example.user.core.results.Result;
import com.example.user.dao.RoleDao;
import com.example.user.dao.UserDao;
import com.example.user.domain.Role;
import com.example.user.domain.User;
import com.example.user.service.Concrete.UserManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserManagerTests {


    @Mock
    private UserDao userDao;

    @Mock
    private RoleDao roleDao;

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
        user.setUserId(1);
        user.setUserName("user");
        user.setPassword("user.123");
        user.setDeleted(Boolean.FALSE);
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
        User user=new User();
        user.setUserName("Beytullah");
        user.setDeleted(Boolean.FALSE);
        user.setPassword("Beytullah.123");

        Role roles=new Role();
        roles.setId(1);
        roles.setName("OPERATOR");
        user.setRoles(Collections.singletonList(roles));


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
        verify(userDao).softDelete(userId);
    }
    @Test
    public void testUpdateUser() {
        // given
        User user = new User();
        user.setUserId(1);
        user.setUserName("John Doe");
        user.setPassword("John.123");
        Mockito.when(userDao.findById(user.getUserId())).thenReturn(Optional.of(user));

        // when
        Result result = userService.update(user);

        // then
        Mockito.verify(userDao, Mockito.times(1)).save(user);
        Assertions.assertTrue(result.isSuccess());
        Assertions.assertEquals("User Updated Successfully", result.getMessage());
    }


}
