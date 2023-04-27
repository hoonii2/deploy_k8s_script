package com.k8s.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/productFallBack")
    public String productFallBackMethod() {
        return "죄송합니다. \n\n" +
                "Product Service 응답이 오래걸리고 있습니다.\n" +
                " 잠시 후에 시도해주세요.";
    }

    @GetMapping("/reservationFallBack")
    public String reservationFallBackMethod() {
        return "죄송합니다. \n\n" +
                "Reservation Service 응답이 오래걸리고 있습니다.\n" +
                " 잠시 후에 시도해주세요.";
    }
}
