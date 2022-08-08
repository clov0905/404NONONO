package com.cykj.bean;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ApiModel("商品实体类")
public class Tblgoods {

  private int id;
  private String goodsName;
  private String goodsImg;
  private double goodsPrice;
  private String goodsDesc;




}
