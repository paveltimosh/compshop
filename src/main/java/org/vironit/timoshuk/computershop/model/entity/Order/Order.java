package org.vironit.timoshuk.computershop.model.entity.Order;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = "id")

public class Order {

    private Long id;
    private Date dateOfPayment;
    private int totalAmount;
    private boolean isConfirmed;
    private boolean isPayed;

}
