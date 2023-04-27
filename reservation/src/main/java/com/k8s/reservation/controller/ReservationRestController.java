package com.k8s.reservation.controller;

import com.k8s.reservation.dto.ReservationDTO;
import com.k8s.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationRestController {

    private final ReservationService reservationService;

    @PostMapping("/reservation")
    public ResponseEntity<ReservationDTO> doCreateReservation(
            @RequestBody ReservationDTO reservationDTO
    ){
        reservationService.doCreateReservation(reservationDTO);

        return new ResponseEntity<>(reservationDTO, HttpStatus.OK);
    }

}
