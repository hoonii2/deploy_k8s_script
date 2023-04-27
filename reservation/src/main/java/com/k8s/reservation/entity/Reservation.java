package com.k8s.reservation.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "reservation")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;

    @Column(name = "reservation_name", columnDefinition = "VARCHAR(60)")
    private String name;

    @Column(name = "reservation_amount")
    private Long amount;

    @Column(name = "reservation_product_id")
    private Long productId;
}
