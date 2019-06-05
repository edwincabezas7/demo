package com.example.mappin.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class BankBean {

    private String name;
    private String addres;
    private Integer telephone;
    private Integer nit;

}
