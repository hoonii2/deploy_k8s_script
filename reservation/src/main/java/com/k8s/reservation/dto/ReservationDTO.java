package com.k8s.reservation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.k8s.reservation.entity.Reservation;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReservationDTO {

    private Integer reservationId;
    private String reservationName;
    private Integer reservationAmount;
    private Integer productId;

    public static Reservation toEntity(ReservationDTO reservationDTO){
        return Reservation.builder()
                .name(reservationDTO.getReservationName())
                .amount(reservationDTO.getReservationAmount().longValue())
                .productId(reservationDTO.getProductId().longValue())
                .build();
    }
}
