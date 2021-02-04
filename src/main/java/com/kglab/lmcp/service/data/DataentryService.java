package com.kglab.lmcp.service.data;

import com.alibaba.fastjson.JSONObject;
import com.kglab.lmcp.entity.graph.nodes.ElementNode;
import com.kglab.lmcp.entity.graph.nodes.PropertyValueNode;
import com.kglab.lmcp.entity.graph.nodes.SampleNode;
import com.kglab.lmcp.entity.graph.relation.AttrIsRelation;
import com.kglab.lmcp.entity.graph.relation.HasElRelation;
import com.kglab.lmcp.entity.vo.DataEntity;
import com.kglab.lmcp.global.handle.exception.result.SuccessResultMessage;
import com.kglab.lmcp.repository.graph.SampleRepository;
import com.kglab.lmcp.repository.table.UserDao;
import com.kglab.lmcp.service.BaseService;
import org.assertj.core.api.Fail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

//import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataentryService extends BaseService {

    final SampleRepository sampleRepository;
    @Autowired
    public DataentryService(SampleRepository sampleRepository){
        this.sampleRepository = sampleRepository;
    }

    public void SaveOneSample(DataEntity json){

        String sampleCode = json.getId();

        float mgPercent = json.getMg();
        float alPercent = json.getAl();
        float fePercent = json.getFe();
        float coPercent = json.getCo();
        float niPercent = json.getNi();
        float cuPercent = json.getCu();
        float znPercent = json.getZn();
        float gaPercent = json.getGa();
        float agPercent = json.getAg();
        float inPercent = json.getIn();
        float snPercent = json.getSn();
        float biPercent = json.getBi();

        float cValue = json.getC();
        float hbValue = json.getHb();
        float pValue = json.getP();
        float kValue = json.getK();
        float vValue = json.getV();


        /**1.构建元素节点*/
        ElementNode mgNode = ElementNode.builder().elName("Mg").build();
        // 创建一条边指向Mg
        HasElRelation rel_to_mg = HasElRelation.builder()
                .percent(mgPercent)
                .targetNode(mgNode)
                .build();

        ElementNode alNode = ElementNode.builder().elName("Al").build();
        // 创建一条边指向Al
        HasElRelation rel_to_al = HasElRelation.builder()
                .percent(alPercent)
                .targetNode(alNode)
                .build();

        ElementNode feNode = ElementNode.builder().elName("Fe").build();
        // 创建一条边指向Fe
        HasElRelation rel_to_fe = HasElRelation.builder()
                .percent(fePercent)
                .targetNode(feNode)
                .build();

        ElementNode coNode = ElementNode.builder().elName("Co").build();
        // 创建一条边指向Co
        HasElRelation rel_to_co = HasElRelation.builder()
                .percent(coPercent)
                .targetNode(coNode)
                .build();

        ElementNode niNode = ElementNode.builder().elName("Ni").build();
        // 创建一条边指向Ni
        HasElRelation rel_to_ni = HasElRelation.builder()
                .percent(niPercent)
                .targetNode(niNode)
                .build();

        ElementNode cuNode = ElementNode.builder().elName("Cu").build();
        // 创建一条边指向Mg
        HasElRelation rel_to_cu = HasElRelation.builder()
                .percent(cuPercent)
                .targetNode(cuNode)
                .build();

        ElementNode znNode = ElementNode.builder().elName("Zn").build();
        // 创建一条边指向Zn
        HasElRelation rel_to_zn = HasElRelation.builder()
                .percent(znPercent)
                .targetNode(znNode)
                .build();

        ElementNode gaNode = ElementNode.builder().elName("Ga").build();
        // 创建一条边指向Ga
        HasElRelation rel_to_ga = HasElRelation.builder()
                .percent(gaPercent)
                .targetNode(gaNode)
                .build();

        ElementNode agNode = ElementNode.builder().elName("Ag").build();
        // 创建一条边指向Ag
        HasElRelation rel_to_ag = HasElRelation.builder()
                .percent(agPercent)
                .targetNode(agNode)
                .build();

        ElementNode inNode = ElementNode.builder().elName("In").build();
        // 创建一条边指向In
        HasElRelation rel_to_in = HasElRelation.builder()
                .percent(inPercent)
                .targetNode(inNode)
                .build();

        ElementNode snNode = ElementNode.builder().elName("Sn").build();
        // 创建一条边指向Sn
        HasElRelation rel_to_sn = HasElRelation.builder()
                .percent(snPercent)
                .targetNode(snNode)
                .build();

        ElementNode biNode = ElementNode.builder().elName("Bi").build();
        // 创建一条边指向Bi
        HasElRelation rel_to_bi = HasElRelation.builder()
                .percent(biPercent)
                .targetNode(biNode)
                .build();


        /**2.构建属性节点*/
        PropertyValueNode propCvalueNode = PropertyValueNode.builder()
                .propValue(cValue).build();
        // 创建电导率属性边指向电导率节点
        AttrIsRelation rel_to_cValue = AttrIsRelation.builder()
                .attrName("电导率").targetNode(propCvalueNode).build();

        PropertyValueNode propHBvalueNode = PropertyValueNode.builder()
                .propValue(hbValue).build();
        // 创建硬度属性边指向硬度节点
        AttrIsRelation rel_to_hbValue = AttrIsRelation.builder()
                .attrName("硬度").targetNode(propHBvalueNode).build();

        PropertyValueNode propPvalueNode = PropertyValueNode.builder()
                .propValue(pValue).build();
        // 创建密度属性边指向密度节点
        AttrIsRelation rel_to_pValue = AttrIsRelation.builder()
                .attrName("密度").targetNode(propPvalueNode).build();

        PropertyValueNode propKvalueNode = PropertyValueNode.builder()
                .propValue(kValue).build();
        // 创建电导率属性边指向热导率节点
        AttrIsRelation rel_to_kValue = AttrIsRelation.builder()
                .attrName("热导率").targetNode(propKvalueNode).build();

        PropertyValueNode propVvalueNode = PropertyValueNode.builder()
                .propValue(vValue).build();
        // 创建电导率属性边指向粘度节点
        AttrIsRelation rel_to_vValue = AttrIsRelation.builder()
                .attrName("粘度").targetNode(propVvalueNode).build();



        /** 3.创建样本节点*/
        // 指向元素的边的列表
        List<HasElRelation> relations1 = new ArrayList<>();
        // 指向属性值节点的边的列表
        List<AttrIsRelation> relations2 = new ArrayList<>();

        relations1.add(rel_to_mg);
        relations1.add(rel_to_al);
        relations1.add(rel_to_fe);
        relations1.add(rel_to_co);
        relations1.add(rel_to_ni);
        relations1.add(rel_to_cu);
        relations1.add(rel_to_zn);
        relations1.add(rel_to_ga);
        relations1.add(rel_to_ag);
        relations1.add(rel_to_in);
        relations1.add(rel_to_sn);
        relations1.add(rel_to_bi);

        relations2.add(rel_to_cValue);
        relations2.add(rel_to_hbValue);
        relations2.add(rel_to_pValue);
        relations2.add(rel_to_kValue);
        relations2.add(rel_to_vValue);

        SampleNode sampleNode = SampleNode.builder()
                .code(sampleCode)
                .relations1(relations1)  // 指向元素的边的列表
                .relations2(relations2)  // 指向属性值节点的边的列表
                .build();

        SampleNode insertEntity = sampleRepository.save(sampleNode);

        fail("录入成功！");
    }
}
