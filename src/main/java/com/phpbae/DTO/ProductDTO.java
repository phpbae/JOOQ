package com.phpbae.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO extends CustomerDTO{

    private int id;
    private String productName;
    private int customerId;

}
