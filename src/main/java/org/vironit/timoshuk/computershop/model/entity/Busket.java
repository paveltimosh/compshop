package org.vironit.timoshuk.computershop.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.vironit.timoshuk.computershop.model.entity.products.Product;
import java.util.List;

@Getter
@Setter
@ToString()
@EqualsAndHashCode()

public class Busket {

    private int totalAmount;
    private List <Product> products;

}
