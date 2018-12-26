package org.timoshuk.computershop.entity.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.timoshuk.computershop.util.LocalDateAttributeConverter;
import org.timoshuk.computershop.util.LocalTimeAttributeConverter;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Getter
@Setter
@ToString()
@EqualsAndHashCode(of = {"id", "idOfCustomer"})
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    private static final long serialVersionUID = -4319131179207728616L;

    @Id
    @Setter(value = AccessLevel.PRIVATE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_id")
    @SequenceGenerator(name = "orders_id", sequenceName = "orders_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_of_customer")
    private Long idOfCustomer;

    @Column(name = "order_description")
    private String orderDescription;

    @Column(name = "date_of_order")
    @Convert(converter = LocalDateAttributeConverter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfOrder;

    @Column(name = "time_of_order")
    @Convert(converter = LocalTimeAttributeConverter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
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

}
