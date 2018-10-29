package org.vironit.timoshuk.computershop.entity.order;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString()
@EqualsAndHashCode(of = {"id", "idOfCustomer"})

public class Order {

    private Long id;
    private Long idOfCustomer;
    private LocalDateTime dateTimeOfOrder;
    private Integer totalAmountOrder;
    private OrderStatus orderStatus;
    private PaymentDescription paymentDescription;

    public Order(){
    }

    public Order(Long id, Long idOfCustomer, LocalDateTime dateTimeOfOrder, int totalAmountOrder,
                 OrderStatus orderStatus, PaymentDescription paymentDescription) {
        this.id = id;
        this.idOfCustomer = idOfCustomer;
        this.dateTimeOfOrder = dateTimeOfOrder;
        this.totalAmountOrder = totalAmountOrder;
        this.orderStatus = orderStatus;
        this.paymentDescription = paymentDescription;
    }
}
