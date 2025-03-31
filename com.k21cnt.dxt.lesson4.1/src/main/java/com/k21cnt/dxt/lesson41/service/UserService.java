package com.k21cnt.dxt.lesson41.service;

import com.k21cnt.dxt.lesson41.dto.UserDTO;
import com.k21cnt.dxt.lesson41.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class UserService {
    List<User> userList = new ArrayList<User>();
    public UserService(){
        userList.add(new User(1L, "user1", "pass1", "John Doe", LocalDate.parse("1990-01-01"), "john@example.com", "1234567890", 34, true));


        userList.add(new User(2L, "user2", "pass2", "Jane Smith", LocalDate.parse("1992-05-15"), "jane@example.com", "0976845854", 24, false));


        userList.add(new User(3L, "user3", "pass3", "Alice Johnson", LocalDate.parse("1993-04-11"), "alice@example.com", "0333333333", 37, true));


        userList.add(new User(4L, "user4", "pass4", "Charlie White", LocalDate.parse("1944-11-17"), "charlie@example.com", "0254125421", 45, true));


       userList.add(new User(5L, "user5", "pass5", "Bob Brown", LocalDate.parse("1947-07-19"), "brown@example.com", "0876543210", 11, false));
    }
    public List<User> findAll(){
        return userList;
    }
    public Boolean create (UserDTO userDTO){
        try {
            User user = new User();
            user.setId(userList.stream().count()+1);
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setEmail(userDTO.getEmail());
            user.setFullname(userDTO.getFullname());
            user.setPhone(userDTO.getPhone());
            user.setAge(userDTO.getAge());
            user.setBirthday(userDTO.getBirthday());
            user.setStatus(userDTO.getStatus());
            userList.add(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
