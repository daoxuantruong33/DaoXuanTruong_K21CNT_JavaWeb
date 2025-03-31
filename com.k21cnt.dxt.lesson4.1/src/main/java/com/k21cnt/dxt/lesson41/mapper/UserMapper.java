package com.k21cnt.dxt.lesson41.mapper;

import com.k21cnt.dxt.lesson41.dto.UserDTO;
import com.k21cnt.dxt.lesson41.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", constant = "0L")
    User toUser(UserDTO userDTO);
    UserDTO toUserDTO (User user);
}