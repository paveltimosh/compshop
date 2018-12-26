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
@Data
@Embeddable
@Table(name = "orders")
public class PaymentDescription implements Serializable {

    private static final long serialVersionUID = 7977952600198651569L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dateOfPayment;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @Convert(converter = LocalTimeAttributeConverter.class)
    private LocalTime timeOfPayment;

    @Enumerated(EnumType.STRING)
    private TypePayment typePayment;

    public PaymentDescription(LocalDate dateOfPayment, LocalTime timeOfPayment, TypePayment typePayment) {
        this.dateOfPayment = dateOfPayment;
        this.timeOfPayment = timeOfPayment;
        this.typePayment = typePayment;
    }

    public PaymentDescription() {

    }
}
