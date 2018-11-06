package org.vironit.timoshuk.computershop.entity.order;

import lombok.*;
import org.vironit.timoshuk.computershop.util.LocalDateAttributeConverter;
import org.vironit.timoshuk.computershop.util.LocalTimeAttributeConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Builder
@Getter
@Setter
@ToString()
@EqualsAndHashCode(of = {"id", "idOfCustomer"})
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = -4319131179207728616L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_id")
    @SequenceGenerator(name = "orders_id", sequenceName = "orders_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_of_customer")
    private Long idOfCustomer;

    @Column(name = "order_description")
    String orderDescription;

    @Column(name = "date_of_order")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dateOfOrder;

    @Column(name = "time_of_order")
    @Convert(converter = LocalTimeAttributeConverter.class)
    private LocalTime timeOfOrder;

    @Column(name = "total_amount_of_order")
    private Integer totalAmountOrder;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="id", column=@Column(name="id_of_payment")),
            @AttributeOverride(name="dateOfPayment", column=@Column(name="date_of_payment")),
            @AttributeOverride(name="timeOfPayment", column=@Column(name="time_of_payment")),
            @AttributeOverride(name="typePayment", column=@Column(name="payment_type"))
    })
    private PaymentDescription paymentDescription;

    public Order(){
    }

    public Order(Long id, Long idOfCustomer, String orderDescription, LocalDate dateOfOrder, LocalTime timeOfOrder,
                 Integer totalAmountOrder, OrderStatus orderStatus, PaymentDescription paymentDescription) {
        this.id = id;
        this.idOfCustomer = idOfCustomer;
        this.orderDescription = orderDescription;
        this.dateOfOrder = dateOfOrder;
        this.timeOfOrder = timeOfOrder;
        this.totalAmountOrder = totalAmountOrder;
        this.orderStatus = orderStatus;
        this.paymentDescription = paymentDescription;
    }
}
