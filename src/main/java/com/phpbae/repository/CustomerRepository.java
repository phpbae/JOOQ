package com.phpbae.repository;

import com.phpbae.DTO.CustomerDTO;
import org.jooq.DSLContext;
import org.jooq.conf.RenderNameStyle;
import org.jooq.conf.Settings;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.phpbae.jooq.model.tables.Customer.CUSTOMER;

@Repository
public class CustomerRepository {

    private final DSLContext dslContext;

    public CustomerRepository(DSLContext dslContext) {
        Settings settings = new Settings();
        settings.setRenderNameStyle(RenderNameStyle.LOWER);
        this.dslContext = dslContext;
    }

    public Optional<CustomerDTO> customerFindOne(int id) {
        return dslContext.select(CUSTOMER.ID, CUSTOMER.NAME, CUSTOMER.EMAIL).from(CUSTOMER).where(CUSTOMER.ID.eq(id)).fetchOptionalInto(CustomerDTO.class);
    }
}
