package org.vironit.timoshuk.computershop.entity.order;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString()
@EqualsAndHashCode()

public class PaymentDescription {
    private Long id;
    private LocalDateTime dateTimeOfPayment;
    private TypePayment typePayment;
}
