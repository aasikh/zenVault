package com.example.zenVault.entity;

import java.time.LocalDate;

@Entity
@Table(name="Users")
public class UserEntity {
    private Long ID;

    private String name;

    private String Number;

    private String Email;

    private String password;

    private Enum role;

    private Enum status;

    private LocalDate creatAt;
}
