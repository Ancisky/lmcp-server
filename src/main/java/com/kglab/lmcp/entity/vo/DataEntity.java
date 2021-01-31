package com.kglab.lmcp.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;

@Data
@Validated

public class DataEntity {


    @NotBlank(message = "编号为空")
    private String id;

    @NotNull(message = "Mg为空")
    @JsonProperty("Mg")
    private Float Mg;
    @NotNull(message = "Al为空")
    @JsonProperty("Al")
    private Float Al;
    @NotNull(message = "Fe为空")
    @JsonProperty("Fe")
    private Float Fe;
    @NotNull(message = "Co为空")
    @JsonProperty("Co")
    private Float Co;
    @NotNull(message = "Ni为空")
    @JsonProperty("Ni")
    private Float Ni;
    @NotNull(message = "Cu为空")
    @JsonProperty("Cu")
    private Float Cu;
    @NotNull(message = "Zn为空")
    @JsonProperty("Zn")
    private Float Zn;
    @NotNull(message = "Ga为空")
    @JsonProperty("Ga")
    private Float Ga;
    @NotNull(message = "Ag为空")
    @JsonProperty("Ag")
    private Float Ag;
    @NotNull(message = "In为空")
    @JsonProperty("In")
    private Float In;
    @NotNull(message = "Sn为空")
    @JsonProperty("Sn")
    private Float Sn;
    @NotNull(message = "Bi为空")
    @JsonProperty("Bi")
    private Float Bi;

    @NotNull(message = "电导率为空")
    private Float c;
    @NotNull(message = "硬度为空")
    private Float hb;
    @NotNull(message = "密度为空")
    private Float p;
    @NotNull(message = "热导率为空")
    private Float k;
    @NotNull(message = "粘度为空")
    private Float v;

}
