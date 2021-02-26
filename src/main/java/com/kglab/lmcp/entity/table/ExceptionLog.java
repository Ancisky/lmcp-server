package com.kglab.lmcp.entity.table;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="translog")
public class ExceptionLog {
    @Id	//主键id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//主键生成策略
    private Integer uid;

    @Column(name="time",nullable = false)
    private String time;

    @Column(name="data",nullable = true)
    private String data;

    @Column(name="exception",nullable = true)
    private String exce;

}
