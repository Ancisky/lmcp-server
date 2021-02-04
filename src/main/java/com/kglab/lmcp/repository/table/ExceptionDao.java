package com.kglab.lmcp.repository.table;

import com.kglab.lmcp.entity.table.ExceptionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * TODO 异常记录表接口
 * @author sc
 * @date 2021/1/14
 */
public interface ExceptionDao extends JpaRepository<ExceptionLog,Integer>, JpaSpecificationExecutor<ExceptionLog> {
}
