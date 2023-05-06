package com.bit.CVQS.dto;

import com.bit.CVQS.domain.Concrete.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    public int userId;
    public String userName;
    public String password;
    public List<RoleDto> roles;
    public Boolean deleted;


}
