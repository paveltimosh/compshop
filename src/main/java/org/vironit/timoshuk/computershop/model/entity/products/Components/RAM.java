package org.vironit.timoshuk.computershop.model.entity.products.Components;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString()
@EqualsAndHashCode(callSuper = true)
public class RAM extends Component {
    private String type;
    private String memoryCapacity;

    public RAM (){}

    public RAM(Long id, Integer price, String model, String maker, String type, String memoryCapacity) {
        super(id, price, model, maker);
        this.type = type;
        this.memoryCapacity = memoryCapacity;
    }

    public RAM(String type, String memoryCapacity) {
        this.type = type;
        this.memoryCapacity = memoryCapacity;
    }
}
