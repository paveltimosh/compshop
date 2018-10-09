package org.vironit.timoshuk.computershop.model.entity.order;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = "id")

public class Order {

    private Long id;
    private Long idCustomer;
    private LocalDateTime dateTimeOfPayment;
    private int totalAmountOrder;
    private OrderStatus orderStatus;
    private PaymentDescription paymentDescription;

}
