package com.cykj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Tblpower {

    private int powerId;
    private String powerName;
    private String url;
    private int parentId;

    private int roleId;
    private List<Integer> powerList;


}
