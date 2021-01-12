package com.kglab.lmcp.repository;

import com.kglab.lmcp.entity.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

    // 基于Repository方法名称必须要遵循驼峰式命名规则，findBy（关键字）+属性名称（首字母大写）+查询条件（首字母大写）
    List<User> findByName(String name);

    List<User> findByNameLike(String name);

    User findByUsername(String name);

    User findByUsernameAndPassword(String username, String password);

    @Query(value = "select password from User where username = ?1", nativeQuery = false)
    String queryUserPassowrd(String username);
}
