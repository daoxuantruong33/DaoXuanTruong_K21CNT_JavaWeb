package com.k21cnt.dxt.lesson11.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Dxt_account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String user;
    private String pass;
    private String name;
    private String email;
    private String phone;
    private String address;
    private boolean status;
}
