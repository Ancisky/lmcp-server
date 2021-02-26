package com.kglab.lmcp.service.calculate;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kglab.lmcp.global.handle.exception.result.SuccessResultMessage;
import com.kglab.lmcp.repository.graph.SampleRepository;
import com.kglab.lmcp.service.BaseService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Service
public class CalculateentryService extends BaseService {

    final SampleRepository sampleRepository;
    final RestTemplate restTemplate;
    @Autowired
    public CalculateentryService(SampleRepository sampleRepository,RestTemplate restTemplate){
        this.sampleRepository = sampleRepository;
        this.restTemplate = restTemplate;
    }

    @Value("${user.setting.CALCULATE_SERVICE.BASE_URL}")
    private String CAL_BASE_URL;
    private String COMPUTE_API = "compute/";


    public void calculate(JSONObject data){
        String url = CAL_BASE_URL + COMPUTE_API;
        JSONObject res = new JSONObject();
        JSONObject dataCget = getPost(data,"电导率");
        JSONObject dataPget = getPost(data,"密度");
        JSONObject dataKget = getPost(data,"热导率");
        JSONObject dataHDget = getPost(data,"硬度");
        JSONObject dataVget = getPost(data,"粘度");

        JSONObject CRes = restTemplate.postForObject(url, dataCget, JSONObject.class);
        JSONObject PRes = restTemplate.postForObject(url, dataPget, JSONObject.class);
        JSONObject HDRes = restTemplate.postForObject(url, dataHDget, JSONObject.class);
        JSONObject KRes = restTemplate.postForObject(url, dataKget, JSONObject.class);
        JSONObject VRes = restTemplate.postForObject(url, dataVget, JSONObject.class);

        String v_c = CRes.getString("data");
        String v_p = PRes.getString("data");
        String v_k = KRes.getString("data");
        String v_v = VRes.getString("data");
        String v_hd = HDRes.getString("data");

        res.put("c",v_c);
        res.put("p",v_p);
        res.put("v",v_v);
        res.put("k",v_k);
        res.put("hd",v_hd);
        // System.out.println("result1==================" + CRes);
        success("查询成功",res);
    }

    public JSONObject getPost(JSONObject json, String prop){
        JSONObject dataRes = new JSONObject();
        float v_ga = json.getFloat("v_ga");
        float v_in = json.getFloat("v_in");
        float v_al = json.getFloat("v_al");
        float v_fe = json.getFloat("v_fe");
        float v_co = json.getFloat("v_co");
        float v_ni = json.getFloat("v_ni");
        float v_cu = json.getFloat("v_cu");
        float v_zn = json.getFloat("v_zn");
        float v_mg = json.getFloat("v_mg");
        float v_ag = json.getFloat("v_ag");
        float v_bi = json.getFloat("v_bi");
        float v_sn = json.getFloat("v_sn");
        // restTemplate.get
        dataRes.put("Ga",v_ga);
        dataRes.put("In",v_in);
        dataRes.put("Al",v_al);
        dataRes.put("Fe",v_fe);
        dataRes.put("Co",v_co);
        dataRes.put("Ni",v_ni);
        dataRes.put("Cu",v_cu);
        dataRes.put("Zn",v_zn);
        dataRes.put("Mg",v_mg);
        dataRes.put("Ag",v_ag);
        dataRes.put("Bi",v_bi);
        dataRes.put("Sn",v_sn);
        dataRes.put("prop",prop);

        /**
         * data = {
         *     hd: 23213,
         * }
         */
        return dataRes;
    }
}

    // Map<String, Object> dataRes = new HashMap<>();

//    public JSONObject getJson(@Valid JSONObject json){
//
//        JSONObject data = new JSONObject();
//        JSONObject v_c = new JSONObject();
//        JSONObject v_p = new JSONObject();
//        JSONObject v_v = new JSONObject();
//        JSONObject v_k = new JSONObject();
//        JSONObject v_hd = new JSONObject();
//
//        v_c = getPost(json,"电导率");
//
//
//
////        v_p = getPost(json,"密度");
////        v_v = getPost(json,"粘度");
////        v_k = getPost(json,"热导率");
////        v_hd = getPost(json,"硬度");
//
//
////        daodianlu = api(v_co);xxx
////        float v_ga = json.getFloat("v_ga");
////        float v_in = json.getFloat("v_in");
////        float v_al = json.getFloat("v_al");
////        float v_fe = json.getFloat("v_fe");
////        float v_co = json.getFloat("v_co");
////        float v_ni = json.getFloat("v_ni");
////        float v_cu = json.getFloat("v_cu");
////        float v_zn = json.getFloat("v_zn");
////        float v_mg = json.getFloat("v_mg");
////        float v_ag = json.getFloat("v_ag");
////        float v_bi = json.getFloat("v_bi");
////        float v_sn = json.getFloat("v_sn");
//////        restTemplate.get
//////        data.put("c",99);
//////        data.put("v",99);
//////        data.put("hd",99);
//////        data.put("p",99);
//////        data.put("k",99);
////
////        success("输入完成！正在计算性能...", data);
//        return data;
//    }


