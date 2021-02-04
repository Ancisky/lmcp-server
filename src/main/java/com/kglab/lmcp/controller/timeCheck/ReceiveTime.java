package com.kglab.lmcp.controller.timeCheck;

import com.alibaba.fastjson.JSONObject;
import com.kglab.lmcp.controller.BaseAction;
import com.kglab.lmcp.entity.table.Computer;
import com.kglab.lmcp.repository.table.LastScanTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;

@RestController
@Validated
@RequestMapping(value = "/test")
public class ReceiveTime {
    @Autowired
    private LastScanTime lastScanTime;

    @RequestMapping(value = "/timepush",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public void GetTime(@RequestBody JSONObject timejosn){
        Computer computer = new Computer();
        computer.setComputer(timejosn.getString("computername"));
        computer.setLastdire(timejosn.getString("lastdire"));
        computer.setLasttime(timejosn.getString("lasttime"));
        List<Computer> queryresult = lastScanTime.findByComputerAndLastdire(timejosn.getString("computername"),timejosn.getString("lastdire"));
        if(queryresult.size() == 0){
            lastScanTime.save(computer);
            System.out.println("Has no time.");
        }
        else {
            computer.setUid(queryresult.get(0).getUid());
            lastScanTime.save(computer);
            System.out.println("Alter time.");
        }
    }
}
