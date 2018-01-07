/*
 * This file is generated by jOOQ.
*/
package com.phpbae.jooq.model;


import com.phpbae.jooq.model.tables.Customer;
import com.phpbae.jooq.model.tables.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Test extends SchemaImpl {

    private static final long serialVersionUID = 1845505912;

    /**
     * The reference instance of <code>test</code>
     */
    public static final Test TEST = new Test();

    /**
     * The table <code>test.customer</code>.
     */
    public final Customer CUSTOMER = com.phpbae.jooq.model.tables.Customer.CUSTOMER;

    /**
     * The table <code>test.product</code>.
     */
    public final Product PRODUCT = com.phpbae.jooq.model.tables.Product.PRODUCT;

    /**
     * No further instances allowed
     */
    private Test() {
        super("test", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Customer.CUSTOMER,
            Product.PRODUCT);
    }
}
