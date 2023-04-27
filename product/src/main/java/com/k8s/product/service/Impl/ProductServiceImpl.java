package com.k8s.product.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.k8s.product.dto.ProductDTO;
import com.k8s.product.entity.Product;
import com.k8s.product.repository.ProductRepository;
import com.k8s.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDTO doCreateProduct(ProductDTO productDTO) {
        Product product = ProductDTO.toEntity(productDTO);

        productRepository.save(product);

        return productDTO;
    }

    @Override
    @KafkaListener(topics = "changeProductAmount")
    public void doUpdateProductAmount(String kafkaMessage) {
        Map<Object, Object> map = new HashMap<>();

        ObjectMapper mapper = new ObjectMapper();

        try {
            // JSON String 을 Map 으로 직렬화
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // kafka Integer 데이터를 Long 변환 시 Class Cast 에러 방지를 위해 미리 타입 지정
        Object productIdObject = map.get("productId");
        Long productId = null;
        if (productIdObject instanceof Integer) {
            productId = ((Integer) productIdObject).longValue();
        } else if (productIdObject instanceof Long) {
            productId = (Long) productIdObject;
        }
        Object reservationAmountObject = map.get("reservationAmount");
        Long reservationAmount = null;
        if (reservationAmountObject instanceof Integer) {
            reservationAmount = ((Integer) reservationAmountObject).longValue();
        } else if (reservationAmountObject instanceof Long) {
            reservationAmount = (Long) reservationAmountObject;
        }

        Product product = productRepository.findById(productId).get();

        product.updateAmount(product.getAmount() - reservationAmount);
        productRepository.save(product);
    }
}
