package com.example.mappin.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyDTO {

    private String nameCompany;
    private String addressCompany;
    private String telephoneCompany;
    private String nitCompany;
}
