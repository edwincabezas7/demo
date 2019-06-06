package com.example.mappin.demo;


import com.example.mappin.mapper.BankMapper;
import com.example.mappin.model.BankBean;
import com.example.mappin.model.BankDTO;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.RunAs;

@RunWith(DataProviderRunner.class)
@Slf4j
public class BankMapperTest {

    @Autowired
    private BankMapper mapper
            = Mappers.getMapper(BankMapper.class);


    /**
     * Test: SimplingTest BankDTO to BankBean
     * @param bankDTO
     */
    @Test
    @UseDataProvider("constructBankDTO")
    public void shouldReturnBankBeanWithbankDTOInformation(BankDTO bankDTO){
        BankBean bankBean = mapper.sourceBankDTOtoBankBeanDestination(bankDTO);
        log.info("****************Should return bankBean class converted from BankDTO ****************");
        log.info("DATA: " + BankBean.class.getSimpleName().toString() + " " + bankBean.toString());


        bankBean = mapper.mapFieldsTransformation(bankDTO);

        log.info("LA CONSTANTE ES: " + bankBean.getHaveToBeConstant());

        /**
         * Transform data with we own method
         */
        log.info("PRUEBA CON NAMED: " + mapper.mapWithNamedExample(bankDTO));

        Assertions.assertThat(bankBean.getAddres()).isEqualTo(bankDTO.getAddres());
        Assertions.assertThat(bankBean.getName()).isEqualTo(bankDTO.getName());
        Assertions.assertThat(bankBean.getNit()).isEqualTo(bankDTO.getNit());
        Assertions.assertThat(bankBean.getTelephone()).isEqualTo(bankDTO.getTelephone());
    }

    /**
     * Test: SimplingTest BankBean to BankDTO
     * @param bankBean
     */
    @Test
    @UseDataProvider("constructBankBean")
    public void shouldReturnBankDTOWithbankBeanInformation(BankBean bankBean){
        BankDTO bankDTO = mapper.sourceBankBeantoBankDTODestination(bankBean);
        log.info("****************Should return bankDTO class converted from BankBean****************");
        log.info("DATA: " + BankDTO.class.getSimpleName().toString() + " " + bankDTO.toString());

        Assertions.assertThat(bankDTO.getAddres()).isEqualTo(bankBean.getAddres());
        Assertions.assertThat(bankDTO.getName()).isEqualTo(bankBean.getName());
        Assertions.assertThat(bankDTO.getNit()).isEqualTo(bankBean.getNit());
        Assertions.assertThat(bankDTO.getTelephone()).isEqualTo(bankBean.getTelephone());
    }

    @DataProvider
    public static Object[][] constructBankDTO(){
        BankDTO bankDTO = BankDTO.builder().addres("addresFromBankDTO")
                .name("MyBankDTO")
                .nit(111111)
                .telephone(1111111)
                .build();

        return new Object[][] { {bankDTO}  };

    }

    @DataProvider
    public static Object[][] constructBankBean(){
        BankBean bankBean = BankBean.builder().addres("addresFromBankBean")
                .name("MyBankBean")
                .nit(222222)
                .telephone(222222)
                .build();

        return new Object[][] { {bankBean}  };

    }

}
