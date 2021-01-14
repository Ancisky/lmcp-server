package com.kglab.lmcp.entity.table;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="user")
public class User {

    @Id	//主键id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//主键生成策略
    private Integer id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="username",unique = true)
    private String username;

    @Column(name="password")
    private String password;
}
