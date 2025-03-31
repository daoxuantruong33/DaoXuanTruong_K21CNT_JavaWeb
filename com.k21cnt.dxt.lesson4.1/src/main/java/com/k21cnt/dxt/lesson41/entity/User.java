package com.k21cnt.dxt.lesson41.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class User {
    Long id;
    String username;
    String password;
    String fullname;
    LocalDate birthday;
    String email;
    String phone;
    int age;
    boolean status;
}
