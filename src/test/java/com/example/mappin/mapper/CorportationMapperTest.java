package com.example.mappin.mapper;

import com.example.mappin.model.BankDTO;
import com.example.mappin.model.CompanyDTO;
import com.example.mappin.model.CorporationBean;
import com.example.mappin.model.CorporationDTO;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.*;

@Slf4j
@RunWith(DataProviderRunner.class)
public class CorportationMapperTest {

    private CorportationMapper subject = Mappers.getMapper(CorportationMapper.class);

    @Test
    @UseDataProvider("constructCoporationDTO")
    public void shouldReturnMappingForCorporationsChilds(CorporationDTO corporationDTO){

        CorporationBean corporationBean = subject.sourceCorpDTOtoCorpBean(corporationDTO);

        log.info(corporationBean.toString());

    }

    @DataProvider
    public static Object[][] constructCoporationDTO(){

        CorporationDTO corporationDTO = CorporationDTO.builder().nameCorporation("myNameCorportationFromDTO")
                .bankDTO(constructBankDTO())
                .companyDTO(constructCompanyDTO())
                .build();
        return new Object[][] { {corporationDTO} };
    }


    public static BankDTO constructBankDTO(){
        BankDTO bankDTO = BankDTO.builder().addres("addresFromBankDTO")
                .name("MyBankDTO")
                .nit(111111)
                .telephone(1111111)
                .build();

       return bankDTO;

    }

   public static CompanyDTO constructCompanyDTO(){
        CompanyDTO companyDTO = CompanyDTO.builder().addressCompany("addresFromCompanyDTO")
                .nameCompany("MyCompanyDTO")
                .nitCompany("myNitFromCompanyDTO")
                .telephoneCompany("myTelephoneFromCompanyDTO")
                .build();

        return companyDTO;
    }

}