package com.phpbae.repository;

import com.phpbae.DTO.CustomerDTO;
import com.phpbae.DTO.ProductDTO;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.conf.RenderNameStyle;
import org.jooq.conf.Settings;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.phpbae.jooq.model.tables.Customer.CUSTOMER;
import static com.phpbae.jooq.model.tables.Product.PRODUCT;
import static org.jooq.impl.DSL.row;

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

    public List<CustomerDTO> customerFindOne2(int id) {
        return dslContext.select(CUSTOMER.ID, CUSTOMER.NAME, CUSTOMER.EMAIL).from(CUSTOMER).where(CUSTOMER.ID.eq(id)).fetch().into(CustomerDTO.class);
    }

    public List<CustomerDTO> customerFindAll(){
        return dslContext.select(CUSTOMER.ID, CUSTOMER.NAME, CUSTOMER.EMAIL).from(CUSTOMER).fetch().into(CustomerDTO.class);
    }

    public List<CustomerDTO> customerFindAll2(){
        return dslContext.selectFrom(CUSTOMER).fetch().into(CustomerDTO.class);
    }

    public void customerFindJoinProduct(){

         List<ProductDTO> productDTOList =  dslContext.select().from(CUSTOMER).join(PRODUCT).on(CUSTOMER.ID.eq(PRODUCT.CUSTOMER_ID)).fetch().into(ProductDTO.class);

    }

    @Transactional
    public void insertCustomerInfo(){
        dslContext.insertInto(CUSTOMER).columns(CUSTOMER.NAME, CUSTOMER.EMAIL).values("업데이트이름!", "zzzz5555@naver.com").execute();
        dslContext.insertInto(CUSTOMER, CUSTOMER.NAME, CUSTOMER.EMAIL).values("업데이트의 대왕!", "xxxxxx@naver.com").execute();

        //multiple row
        dslContext.insertInto(CUSTOMER, CUSTOMER.NAME, CUSTOMER.EMAIL)
                .values("multi1", "mulit1@naver.com")
                .values("multi2", "mulit2@naver.com")
                .execute();
    }

    @Transactional
    public Integer insertReturnIdxCustomerInfo(){
        Result<?> result = dslContext.insertInto(CUSTOMER, CUSTOMER.NAME, CUSTOMER.EMAIL)
                .values("return insert", "return insert@naver.com")
                .returning(CUSTOMER.ID, CUSTOMER.NAME, CUSTOMER.EMAIL)
                .fetch();
        return result.getValue(0, CUSTOMER.ID);
    }

    @Transactional
    public void updateCustomerInfo(){
        dslContext.update(CUSTOMER)
                .set(CUSTOMER.NAME, "전설의죽음")
                .set(CUSTOMER.EMAIL, "전설의이메일@naver.com")
                .where(CUSTOMER.ID.eq(1))
                .execute();
    }

    @Transactional
    public void deleteCustomerInfo(int id){
        dslContext.delete(CUSTOMER).where(CUSTOMER.ID.eq(id)).execute();
    }


}
