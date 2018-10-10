package org.vironit.timoshuk.computershop.model.entity.products.Components;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString()
@EqualsAndHashCode(callSuper = true)
public class CPU extends Component {
    private String processorType;
    private String numberCores;
    private String cpuSpeed;


    public CPU(Long id, Integer price, String model, String maker, String processorType, String numberCores, String cpuSpeed) {
        super(id, price, model, maker);
        this.processorType = processorType;
        this.numberCores = numberCores;
        this.cpuSpeed = cpuSpeed;
    }
}
