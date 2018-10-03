package org.vironit.timoshuk.computershop.model.entity.products;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "id")
@EqualsAndHashCode(callSuper = false, exclude = "id")

public class Computer extends Product{

    private Long id;
    private int price;
    private String maker;
    private int ram;
    private int memoryHd;
    private int processorSpeed;

}
