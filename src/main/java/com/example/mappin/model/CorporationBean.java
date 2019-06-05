package com.example.mappin.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class CorporationBean {

    private String nameCorporation;
    private CompanyBean companyBean;
    private BankBean bankBean;
}