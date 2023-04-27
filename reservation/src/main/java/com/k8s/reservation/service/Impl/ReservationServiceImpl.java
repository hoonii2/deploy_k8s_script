package com.k8s.reservation.service.Impl;

import com.k8s.reservation.dto.ReservationDTO;
import com.k8s.reservation.entity.Reservation;
import com.k8s.reservation.kafka.KafkaProducer;
import com.k8s.reservation.repository.ReservationRepository;
import com.k8s.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final KafkaProducer kafkaProducer;

    @Override
    public ReservationDTO doCreateReservation(ReservationDTO reservationDTO) {
        Reservation reservation = ReservationDTO.toEntity(reservationDTO);

        reservationRepository.save(reservation);

        kafkaProducer.send("changeProductAmount",reservationDTO);

        return reservationDTO;
    }
}
