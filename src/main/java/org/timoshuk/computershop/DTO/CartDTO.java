package org.timoshuk.computershop.DTO;

import lombok.Data;
import org.timoshuk.computershop.entity.products.Item;

import java.util.Map;

@Data
public class CartDTO {
    private Map<String, Integer> cart;
    private Integer totalAmount;
}
