package com.phpbae.repository;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    private final DSLContext dslContext;

    public ProductRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }


}
