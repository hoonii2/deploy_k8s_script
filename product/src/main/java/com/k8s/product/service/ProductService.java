package com.k8s.product.service;

import com.k8s.product.dto.ProductDTO;

public interface ProductService {
    ProductDTO doCreateProduct(ProductDTO productDTO);

    void doUpdateProductAmount(String kafkaMessage);
}
