package com.k8s.product.controller;

import com.k8s.product.dto.ProductDTO;
import com.k8s.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> doCreateProduct(
            @RequestBody ProductDTO productDTO
    ) {
        productService.doCreateProduct(productDTO);

        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
}
