package com.phpbae.service;

import com.phpbae.DTO.CustomerDTO;
import com.phpbae.repository.CustomerRepository;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

    public void getCustomersInfoByJoin() {
        customerRepository.customerFindJoinProduct();
    }

    public void insertCustomerInfo() {
        customerRepository.insertCustomerInfo();
    }

    public Integer insertCustomerInfo2() {
        return customerRepository.insertReturnIdxCustomerInfo();
    }

    public void updateCustomerInfo(){
        customerRepository.updateCustomerInfo();
    }

    public void deleteCustomerInfo(int id){
        customerRepository.deleteCustomerInfo(id);
    }

}
