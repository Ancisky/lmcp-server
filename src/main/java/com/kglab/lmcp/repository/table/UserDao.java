package com.kglab.lmcp.repository.table;

import com.kglab.lmcp.entity.table.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/**
 * TODO 用户表数据操作接口
 * @author sc
 * @date 2021/1/14
 */
public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

    // 基于Repository方法名称必须要遵循驼峰式命名规则，findBy（关键字）+属性名称（首字母大写）+查询条件（首字母大写）
    List<User> findByName(String name);

    List<User> findByNameLike(String name);

    User findByUsername(String name);

    User findByUsernameAndPassword(String username, String password);

    @Query(value = "select password from User where username = ?1", nativeQuery = false)
    String queryUserPassowrd(String username);
}
