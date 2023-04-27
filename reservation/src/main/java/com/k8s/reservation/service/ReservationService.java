package com.k8s.reservation.service;

import com.k8s.reservation.dto.ReservationDTO;

public interface ReservationService {
    ReservationDTO doCreateReservation(ReservationDTO reservationDTO);
}
