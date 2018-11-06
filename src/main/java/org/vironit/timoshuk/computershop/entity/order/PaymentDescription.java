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

    /*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_of_payment")
    @SequenceGenerator(name = "id_of_payment", sequenceName = "id_of_payment_seq", allocationSize = 1)
    private Long id;*/

    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dateOfPayment;

    @Convert(converter = LocalTimeAttributeConverter.class)
    private LocalTime timeOfPayment;

    @Enumerated(EnumType.STRING)
    private TypePayment typePayment;

    public PaymentDescription(){
    }

    public PaymentDescription( LocalDate dateOfPayment, LocalTime timeOfPayment, TypePayment typePayment) {

        this.dateOfPayment = dateOfPayment;
        this.timeOfPayment = timeOfPayment;
        this.typePayment = typePayment;
    }


}
