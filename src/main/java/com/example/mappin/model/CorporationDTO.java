package com.example.mappin.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class CorporationDTO {

    private String nameCorporation;
    private BankDTO bankDTO;
    private CompanyDTO companyDTO;
}