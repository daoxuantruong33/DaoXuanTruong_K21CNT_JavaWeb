package com.k21cnt.dxt.lesson11.dto;
import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dxt_accountDTO {
    private Long id;
    private String user;
    private String pass;
    private String name;
    private String email;
    private String phone;
    private String address;
    private boolean status;
}
