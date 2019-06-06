package com.example.mappin.mapper;

import com.example.mappin.model.BankBean;
import com.example.mappin.model.BankDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(uses = CompanyMapper.class)
public interface BankMapper {

    //SIMPLE MAPPING EXAMPLES
    BankBean sourceBankDTOtoBankBeanDestination(BankDTO bankDTO);

    BankDTO sourceBankBeantoBankDTODestination(BankBean bankBean);

    @Mapping( target = "haveToBeConstant", constant = "ESTO ES UNA CONSTANTE")
    BankBean mapFieldsTransformation(BankDTO bankDTO);


    /**
     * Should be tramsformed in the field haveToBeConstant with implementation executed in "formNamed"
     * @param bankDTO
     * @return
     */
    @Mapping( target = "haveToBeConstant", qualifiedByName = "formNamed")
    BankBean mapFieldsWithNamed(BankDTO bankDTO);

    @Named("formNamed")
    default String mapWithNamedExample(BankDTO bankDTO){
        return " ESTO ES UNA PRUEBA: " + bankDTO.getName().concat(" ").concat(bankDTO.getTelephone().toString());

    }


}
