package com.phpbae.repository;

import com.phpbae.DTO.CustomerDTO;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.phpbae.jooq.model.tables.Customer.CUSTOMER;

@Repository
public class CustomerRepository {

    private final DSLContext dslContext;

    public CustomerRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public Optional<CustomerDTO> customerFindOne(int id) {
        return dslContext.select(CUSTOMER.ID, CUSTOMER.NAME, CUSTOMER.EMAIL).from(CUSTOMER).where().fetchOptionalInto(CustomerDTO.class);
    }
}
