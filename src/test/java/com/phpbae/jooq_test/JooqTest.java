package com.phpbae.jooq_test;


import com.phpbae.DTO.CustomerDTO;
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
    public void 고객서비스CRUDTest(){

        //select test
        Optional<CustomerDTO> customerDTO = customerService.getCustomerInfo(1);
        Assert.assertNotNull(customerDTO);

        List<CustomerDTO> customerDTOList = customerService.getCustomersInfo();
        Assert.assertNotNull(customerDTOList);

        List<CustomerDTO> customerDTOList2 = customerService.getCustomersInfo2();
        Assert.assertNotNull(customerDTOList2);

        //select join
        customerService.getCustomersInfoByJoin();

        //insert test
        customerService.insertCustomerInfo();
        Integer insertedIdx = customerService.insertCustomerInfo2();
        Optional<CustomerDTO> insertedCustomerDTO = customerService.getCustomerInfo(insertedIdx);
        Assert.assertEquals("name : ", "return insert", insertedCustomerDTO.get().getName());
        Assert.assertEquals("email : ", "return insert@naver.com", insertedCustomerDTO.get().getEmail());


        //update test
        customerService.updateCustomerInfo();
        Optional<CustomerDTO> updatedCustomerDTO = customerService.getCustomerInfo(1);
        Assert.assertEquals("name : ", "전설의죽음", updatedCustomerDTO.get().getName());
        Assert.assertEquals("email : ", "전설의이메일@naver.com", updatedCustomerDTO.get().getEmail());

        //delete test
        customerService.deleteCustomerInfo(insertedIdx);
        Optional<CustomerDTO> deletedCustomerDTO = customerService.getCustomerInfo(insertedIdx);
        Assert.assertNull(deletedCustomerDTO.orElse(null));
    }

}
