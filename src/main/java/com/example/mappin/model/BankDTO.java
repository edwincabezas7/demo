package com.example.mappin.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class BankDTO {

    private String name;
    private String addres;
    private Integer telephone;
    private Integer nit;




}
