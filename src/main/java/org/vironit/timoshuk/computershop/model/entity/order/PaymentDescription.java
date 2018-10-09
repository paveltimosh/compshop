package org.vironit.timoshuk.computershop.model.entity.order;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = "id")

public class PaymentDescription {
    private Long id;
    private LocalDateTime dateTimePayment;
    private TypePayment typePayment;
}
