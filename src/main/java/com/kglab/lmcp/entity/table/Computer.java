package com.kglab.lmcp.entity.table;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="computer")
public class Computer {

    @Id	//主键id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//主键生成策略
    private Integer uid;

    @Column(name="computer",nullable = false)
    private String computer;

    @Column(name="lasttime",nullable = true)
    private String lasttime;

    @Column(name="lastdire",nullable = true)
    private String lastdire;

}
