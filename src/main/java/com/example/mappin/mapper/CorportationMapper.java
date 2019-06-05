package com.example.mappin.mapper;

import com.example.mappin.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = CompanyMapper.class)
public interface CorportationMapper {


    @Mappings({
            @Mapping(source = "companyDTO.nameCompany", target = "companyBean.nombreCompania"),
            @Mapping(source = "companyDTO.addressCompany", target = "companyBean.direccionCompania"),
            @Mapping(source = "companyDTO.telephoneCompany", target = "companyBean.telefonoCompania"),
            @Mapping(source = "companyDTO.nitCompany", target = "companyBean.nitCompania"),
            @Mapping(source = "bankDTO", target = "bankBean")

    })
    CorporationBean sourceCorpDTOtoCorpBean(CorporationDTO corporationDTO);

    CorporationDTO sourceCorpBeantoCorpDTO(CorporationBean corporationBean);




}
