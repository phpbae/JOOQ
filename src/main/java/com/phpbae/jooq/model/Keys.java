/*
 * This file is generated by jOOQ.
*/
package com.phpbae.jooq.model;


import com.phpbae.jooq.model.tables.Customer;
import com.phpbae.jooq.model.tables.Product;
import com.phpbae.jooq.model.tables.records.CustomerRecord;
import com.phpbae.jooq.model.tables.records.ProductRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>test</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<CustomerRecord, Integer> IDENTITY_CUSTOMER = Identities0.IDENTITY_CUSTOMER;
    public static final Identity<ProductRecord, Integer> IDENTITY_PRODUCT = Identities0.IDENTITY_PRODUCT;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CustomerRecord> KEY_CUSTOMER_PRIMARY = UniqueKeys0.KEY_CUSTOMER_PRIMARY;
    public static final UniqueKey<ProductRecord> KEY_PRODUCT_PRIMARY = UniqueKeys0.KEY_PRODUCT_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ProductRecord, CustomerRecord> PRODUCT_FK = ForeignKeys0.PRODUCT_FK;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<CustomerRecord, Integer> IDENTITY_CUSTOMER = createIdentity(Customer.CUSTOMER, Customer.CUSTOMER.ID);
        public static Identity<ProductRecord, Integer> IDENTITY_PRODUCT = createIdentity(Product.PRODUCT, Product.PRODUCT.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<CustomerRecord> KEY_CUSTOMER_PRIMARY = createUniqueKey(Customer.CUSTOMER, "KEY_customer_PRIMARY", Customer.CUSTOMER.ID);
        public static final UniqueKey<ProductRecord> KEY_PRODUCT_PRIMARY = createUniqueKey(Product.PRODUCT, "KEY_product_PRIMARY", Product.PRODUCT.ID);
    }

    private static class ForeignKeys0 extends AbstractKeys {
        public static final ForeignKey<ProductRecord, CustomerRecord> PRODUCT_FK = createForeignKey(com.phpbae.jooq.model.Keys.KEY_CUSTOMER_PRIMARY, Product.PRODUCT, "PRODUCT_FK", Product.PRODUCT.CUSTOMER_ID);
    }
}
