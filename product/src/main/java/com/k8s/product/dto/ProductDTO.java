package com.k8s.product.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.k8s.product.entity.Product;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductDTO {

    private String productName;
    private Integer productAmount;

    public static Product toEntity(ProductDTO productDTO){
        return Product.builder()
                .name(productDTO.getProductName())
                .amount(productDTO.getProductAmount().longValue())
                .build();
    }
}
