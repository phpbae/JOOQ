package com.phpbae.jooq_test;


import com.phpbae.DTO.CustomerDTO;
import com.phpbae.DTO.ProductDTO;
import com.phpbae.service.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JooqTest {

    @Autowired
    private CustomerService customerService;


    @Test
    public void 고객서비스SelectTest() {

        //select test
        Optional<CustomerDTO> customerDTO = customerService.getCustomerInfo(1);
        Assert.assertNotNull(customerDTO);

        List<CustomerDTO> customerDTOList = customerService.getCustomersInfo();
        Assert.assertNotNull(customerDTOList);

        List<CustomerDTO> customerDTOList2 = customerService.getCustomersInfo2();
        Assert.assertNotNull(customerDTOList2);

        //select join
        List<ProductDTO> productDTOList = customerService.getCustomersInfoByJoin();
        for (ProductDTO dto : productDTOList) {
            System.out.println(dto.getId());
            System.out.println(dto.getProductName());
            System.out.println(dto.getCustomerId());
            System.out.println(dto.getName());
            System.out.println(dto.getEmail());
            System.out.println(dto.getCustomerDTOFiledId());
        }
        System.out.println("------------------------------------------------------");
        List<ProductDTO> productDTOList2 = customerService.getCustomersInfoByJoin2();
        for (ProductDTO dto : productDTOList2) {
            System.out.println(dto.getId());
            System.out.println(dto.getProductName());
            System.out.println(dto.getCustomerId());
            System.out.println(dto.getName());
            System.out.println(dto.getEmail());
            System.out.println(dto.getCustomerDTOFiledId());
        }

    }

    @Test
    public void 고객서비스InsertTest(){
        //insert test
        customerService.insertCustomerInfo();
        Integer insertedIdx = customerService.insertCustomerInfo2();
        Optional<CustomerDTO> insertedCustomerDTO = customerService.getCustomerInfo(insertedIdx);
        Assert.assertEquals("name : ", "return insert", insertedCustomerDTO.get().getName());
        Assert.assertEquals("email : ", "return insert@naver.com", insertedCustomerDTO.get().getEmail());

    }

    @Test
    public void 고객서비스UpdateTest(){
        //update test
        customerService.updateCustomerInfo();
        Optional<CustomerDTO> updatedCustomerDTO = customerService.getCustomerInfo(1);
        Assert.assertEquals("name : ", "전설의죽음", updatedCustomerDTO.get().getName());
        Assert.assertEquals("email : ", "전설의이메일@naver.com", updatedCustomerDTO.get().getEmail());
    }

    @Test
    public void 고객서비스DeleteTest(){
        //delete test
        customerService.deleteCustomerInfo(3);
        Optional<CustomerDTO> deletedCustomerDTO = customerService.getCustomerInfo(3);
        Assert.assertNull(deletedCustomerDTO.orElse(null));
    }

}
