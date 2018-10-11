package org.vironit.timoshuk.computershop.model.entity.order;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Getter
@Setter
@ToString()
@EqualsAndHashCode()

public class PaymentDescription {
    private Long id;
//TODO    private LocalDateTime datePayment;
    private Timestamp dateTimeOfPayment;

    private TypePayment typePayment;
}
