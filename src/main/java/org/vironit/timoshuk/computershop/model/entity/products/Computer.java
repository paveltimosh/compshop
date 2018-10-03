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

    public Computer(Long id, int price, String maker, int ram, int memoryHd, int processorSpeed) {
        this.id = id;
        this.price = price;
        this.maker = maker;
        this.ram = ram;
        this.memoryHd = memoryHd;
        this.processorSpeed = processorSpeed;
    }
}
