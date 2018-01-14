package com.phpbae.service;

import com.phpbae.DTO.CustomerDTO;
import com.phpbae.DTO.ProductDTO;
import com.phpbae.repository.CustomerRepository;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.phpbae.jooq.model.Tables.CUSTOMER;
import static com.phpbae.jooq.model.Tables.PRODUCT;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Optional<CustomerDTO> getCustomerInfo(int id) {
        return customerRepository.customerFindOne(id);
    }

    public List<CustomerDTO> getCustomersInfo() {
        return customerRepository.customerFindAll();
    }

    public List<CustomerDTO> getCustomersInfo2() {
        return customerRepository.customerFindAll2();
    }

    public List<ProductDTO> getCustomersInfoByJoin() {
        return customerRepository.customerFindJoinProduct();
    }

    public List<ProductDTO> getCustomersInfoByJoin2() {
        Result<Record> recordResult = customerRepository.customerFindJoinProduct2();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Record record : recordResult) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(record.get(PRODUCT.ID));
            productDTO.setProductName(record.get(PRODUCT.PRODUCT_NAME));
            productDTO.setCustomerId(record.get(PRODUCT.CUSTOMER_ID));
            productDTO.setCustomerDTOFiledId(record.get(CUSTOMER.ID));
            productDTO.setName(record.get(CUSTOMER.NAME));
            productDTO.setEmail(record.get(CUSTOMER.EMAIL));
            productDTOList.add(productDTO);
        }

        return productDTOList;
    }

    public void insertCustomerInfo() {
        customerRepository.insertCustomerInfo();
    }

    public Integer insertCustomerInfo2() {
        return customerRepository.insertReturnIdxCustomerInfo();
    }

    public void updateCustomerInfo() {
        customerRepository.updateCustomerInfo();
    }

    public void deleteCustomerInfo(int id) {
        customerRepository.deleteCustomerInfo(id);
    }

}
