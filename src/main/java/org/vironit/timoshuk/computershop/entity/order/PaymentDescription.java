package org.vironit.timoshuk.computershop.entity.order;

import lombok.*;
import org.vironit.timoshuk.computershop.util.LocalDateAttributeConverter;
import org.vironit.timoshuk.computershop.util.LocalTimeAttributeConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Getter
@Setter
@ToString()
@EqualsAndHashCode()
@Embeddable
@Table(name = "orders")
public class PaymentDescription implements Serializable {

    private static final long serialVersionUID = 7977952600198651569L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dateOfPayment;

    @Convert(converter = LocalTimeAttributeConverter.class)
    private LocalTime timeOfPayment;

    @Enumerated(EnumType.STRING)
    private TypePayment typePayment;

    public PaymentDescription(){

    }

    public PaymentDescription(Long id, LocalDate dateOfPayment, LocalTime timeOfPayment,
                              TypePayment typePayment) {
        this.id = id;
        this.dateOfPayment = dateOfPayment;
        this.timeOfPayment = timeOfPayment;
        this.typePayment = typePayment;
    }
}
