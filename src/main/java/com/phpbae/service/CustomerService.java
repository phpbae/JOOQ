package com.phpbae.service;

import com.phpbae.DTO.CustomerDTO;
import com.phpbae.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Optional<CustomerDTO> getCustomerInfo() {
        return customerRepository.customerFindOne(1);
    }

}
