package org.timoshuk.computershop.DTO;

import lombok.Data;

@Data
public class CartPositionDTO {
    private String modelOfItem;
    private Integer count;
    private Integer price;

}
