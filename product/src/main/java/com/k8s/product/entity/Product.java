package com.k8s.product.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", columnDefinition = "VARCHAR(60)")
    private String name;

    @Column(name = "product_amount")
    private Long amount;

    public void updateAmount(Long amount){
        this.amount = amount;
    }
}
