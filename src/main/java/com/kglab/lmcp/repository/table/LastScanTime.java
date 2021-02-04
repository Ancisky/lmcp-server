package com.kglab.lmcp.repository.table;

import com.kglab.lmcp.entity.table.Computer;
import com.kglab.lmcp.entity.table.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/**
 * TODO 主机表数据操作接口
 * @author sc
 * @date 2021/1/14
 */
public interface LastScanTime extends JpaRepository<Computer,Integer>, JpaSpecificationExecutor<Computer>{

    List<Computer> findByComputer(String name);

    List<Computer> findByComputerAndLastdire(String name, String dire);


}
