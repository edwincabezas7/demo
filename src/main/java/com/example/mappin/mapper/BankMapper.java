package com.example.mappin.mapper;

import com.example.mappin.model.BankBean;
import com.example.mappin.model.BankDTO;
import org.mapstruct.Mapper;

@Mapper(uses = CompanyMapper.class)
public interface BankMapper {

    //SIMPLE MAPPING EXAMPLES
    BankBean sourceBankDTOtoBankBeanDestination(BankDTO bankDTO);

    BankDTO sourceBankBeantoBankDTODestination(BankBean bankBean);


}
