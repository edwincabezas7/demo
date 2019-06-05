package com.example.mappin.demo;


import com.example.mappin.mapper.BankMapper;
import com.example.mappin.mapper.CompanyMapper;
import com.example.mappin.model.BankBean;
import com.example.mappin.model.BankDTO;
import com.example.mappin.model.CompanyBean;
import com.example.mappin.model.CompanyDTO;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;

@RunWith(DataProviderRunner.class)
@Slf4j
public class CompanyMapperTest {

    private CompanyMapper mapper
            = Mappers.getMapper(CompanyMapper.class);


    /**
     * Test: SimplingTest BankDTO to BankBean
     * @param companyDTO
     */
    @Test
    @UseDataProvider("constructCompanyDTO")
    public void shouldReturnBankBeanWithbankDTOInformation(CompanyDTO companyDTO){
        CompanyBean companyBean = mapper.sourceCompanyDTOtoCompanyBeanDestination(companyDTO);
        log.info("****************Should return campanyBean class converted from CompanyDTO ****************");
        log.info("DATA: " + CompanyBean.class.getSimpleName().toString() + " " + companyBean.toString());

        Assertions.assertThat(companyBean.getDireccionCompania() ).isEqualTo(companyDTO.getAddressCompany());
        Assertions.assertThat(companyBean.getNombreCompania()).isEqualTo(companyDTO.getNameCompany());
        Assertions.assertThat(companyBean.getNitCompania()).isEqualTo(companyDTO.getNitCompany());
        Assertions.assertThat(companyBean.getTelefonoCompania()).isEqualTo(companyDTO.getTelephoneCompany());
    }

    /**
     * Test: With annotations BankBean to BankDTO
     * @param companyBean
     */
    @Test
    @UseDataProvider("constructCompanyBean")
    public void shouldReturnBankDTOWithbankBeanInformation(CompanyBean companyBean){
        CompanyDTO companyDTO = mapper.sourceCompanyBeantoCompanyDTODestination(companyBean);
        log.info("****************Should return companyDTO class converted from CompanyBean****************");
        log.info("DATA: " + CompanyDTO.class.getSimpleName().toString() + " " + companyDTO.toString());

        Assertions.assertThat(companyDTO.getAddressCompany() ).isEqualTo(companyBean.getDireccionCompania());
        Assertions.assertThat(companyDTO.getNameCompany()).isEqualTo(companyBean.getNombreCompania());
        Assertions.assertThat(companyDTO.getTelephoneCompany()).isEqualTo(companyBean.getTelefonoCompania());
        Assertions.assertThat(companyDTO.getNitCompany()).isEqualTo(companyBean.getNitCompania());
    }

    @DataProvider
    public static Object[][] constructCompanyDTO(){
        CompanyDTO companyDTO = CompanyDTO.builder().addressCompany("addresFromCompanyDTO")
                .nameCompany("MyCompanyDTO")
                .nitCompany("myNitFromCompanyDTO")
                .telephoneCompany("myTelephoneFromCompanyDTO")
                .build();

        return new Object[][] { {companyDTO}  };

    }

    @DataProvider
    public static Object[][] constructCompanyBean(){
        CompanyBean companyBean = CompanyBean.builder().direccionCompania("addresFromCompanyBean")
                .nombreCompania("MyCompanyBean")
                .nitCompania("nitFromMyCompanyBean")
                .telefonoCompania("telefonoFromMyCompanyBean")
                .build();

        return new Object[][] { {companyBean}  };
    }
}
