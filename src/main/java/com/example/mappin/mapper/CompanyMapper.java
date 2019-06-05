package com.example.mappin.mapper;

import com.example.mappin.model.BankBean;
import com.example.mappin.model.BankDTO;
import com.example.mappin.model.CompanyBean;
import com.example.mappin.model.CompanyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CompanyMapper {


    @Mappings({
            @Mapping(target = "nameCompany", source = "nombreCompania"),
            @Mapping(target = "addressCompany", source = "direccionCompania"),
            @Mapping(target = "telephoneCompany", source = "telefonoCompania"),
            @Mapping(target = "nitCompany", source = "nitCompania")

    })
    CompanyDTO sourceCompanyBeantoCompanyDTODestination(CompanyBean companyBean);

    @Mappings({
            @Mapping(target = "nombreCompania", source = "nameCompany"),
            @Mapping(target = "direccionCompania", source = "addressCompany"),
            @Mapping(target = "telefonoCompania", source = "telephoneCompany"),
            @Mapping(target = "nitCompania", source = "nitCompany")
    })
    CompanyBean sourceCompanyDTOtoCompanyBeanDestination(CompanyDTO bankDTO);


}
