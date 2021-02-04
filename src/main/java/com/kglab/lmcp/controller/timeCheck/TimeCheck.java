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


@RestController
@ResponseBody
@Validated
@RequestMapping(value = "/test")
public class TimeCheck extends BaseAction {


    @RequestMapping(value = "/timecheck",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public JSONObject TimeSend(@RequestBody JSONObject checkMessage) throws SQLException {

        System.out.println("Computer Name: "+checkMessage.getString("computername"));
        System.out.println("Scan Dire: "+checkMessage.getString("lastdire"));

        JSONObject returnJson = GetParaFromDB(checkMessage.getString("computername"), checkMessage.getString("lastdire"));
        System.out.println(returnJson);

        return returnJson;
    }

    @Autowired
    private LastScanTime lastScanTime;

    private JSONObject GetParaFromDB(String Computer, String Dire){
        JSONObject jsOB = new JSONObject();

        //查询数据，按照主机名和路径查询
        List<Computer> searchResult = lastScanTime.findByComputerAndLastdire(Computer,Dire);
        if(searchResult.size() == 0){
            Computer computer = new Computer();
            computer.setComputer(Computer);
            computer.setLasttime(null);
            computer.setLastdire(Dire);
            lastScanTime.save(computer);
            jsOB.put("lastdire",Dire);
            jsOB.put("lasttime",null);
            return jsOB;
        }
        jsOB.put("lastdire",Dire);
        jsOB.put("lasttime",searchResult.get(0).getLasttime());
        return jsOB;
    }

    @Test
    public void GetParaFromDBTest(){
        String Computer = "desktop-1234";
        String Dire = "D:\\项目测试\\Wpf窗口";
        //System.out.println(lastScanTime.findByComputer(Computer));
        //查询数据，按照主机名和路径查询

        List<Computer> searchResult = lastScanTime.findByComputer(Computer);
        for(int r = 0; r<searchResult.size();r++){
            System.out.println(searchResult.get(r));
        }
    }


}
