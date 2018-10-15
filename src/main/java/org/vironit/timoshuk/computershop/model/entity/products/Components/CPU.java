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
    private Integer numberOfCores;
    private String cpuSpeed;

    public CPU (){}

    public CPU(Long id, Integer price, String model, String maker, String processorType, Integer numberOfCores, String cpuSpeed) {
        super(id, price, model, maker);
        this.processorType = processorType;
        this.numberOfCores = numberOfCores;
        this.cpuSpeed = cpuSpeed;
    }

    public CPU(String processorType, Integer numberOfCores, String cpuSpeed) {
        this.processorType = processorType;
        this.numberOfCores = numberOfCores;
        this.cpuSpeed = cpuSpeed;
    }
}
