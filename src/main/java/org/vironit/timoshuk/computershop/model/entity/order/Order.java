package org.vironit.timoshuk.computershop.model.entity.order;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString()
@EqualsAndHashCode(of = {"id", "idOfCustomer"})

public class Order {

    private Long id;
    private Long idOfCustomer;
//TODO    private LocalDateTime dateOrder;
    private Timestamp dateTimeOfOrder;
    private int totalAmountOrder;
    private OrderStatus orderStatus;
    private PaymentDescription paymentDescription;

    public Order(){

    }

    public Order(Long id, Long idOfCustomer, Timestamp dateTimeOfOrder,
                 int totalAmountOrder, OrderStatus orderStatus, PaymentDescription paymentDescription) {
        this.id = id;
        this.idOfCustomer = idOfCustomer;
        this.dateTimeOfOrder = dateTimeOfOrder;
        this.totalAmountOrder = totalAmountOrder;
        this.orderStatus = orderStatus;
        this.paymentDescription = paymentDescription;
    }
}
