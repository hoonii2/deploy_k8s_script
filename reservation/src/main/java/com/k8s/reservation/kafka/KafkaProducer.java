package com.k8s.reservation.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.k8s.reservation.dto.ReservationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;


    // reservationDTO 를 String 으로 send 하는 메서드
    public ReservationDTO send(String topic, ReservationDTO reservationDTO) {

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";

        try {
            // reservationDTO 를 JSON String 으로 직렬화
            jsonInString = mapper.writeValueAsString(reservationDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        kafkaTemplate.send(topic, jsonInString);

        return reservationDTO;
    }
}
