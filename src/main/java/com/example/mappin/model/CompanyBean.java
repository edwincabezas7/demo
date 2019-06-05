package com.example.mappin.model;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class CompanyBean {

    private String nombreCompania;
    private String direccionCompania;
    private String telefonoCompania;
    private String nitCompania;


}
