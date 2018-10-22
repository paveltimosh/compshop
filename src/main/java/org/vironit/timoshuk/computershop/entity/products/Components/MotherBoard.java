package org.vironit.timoshuk.computershop.entity.products.Components;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString()
@EqualsAndHashCode(callSuper = true)
public class MotherBoard extends Component {
    private String formFactor;
    private String memoryTechnology;
    private String cpuSocketType;

    public MotherBoard (){}

    public MotherBoard(Long id, Integer price, String model, String maker,
                       String formFactor, String memoryTechnology, String cpuSocketType) {
        super(id, price, model, maker);
        this.formFactor = formFactor;
        this.memoryTechnology = memoryTechnology;
        this.cpuSocketType = cpuSocketType;
    }

    public MotherBoard(String formFactor, String memoryTechnology, String cpuSocketType) {
        this.formFactor = formFactor;
        this.memoryTechnology = memoryTechnology;
        this.cpuSocketType = cpuSocketType;
    }
}
