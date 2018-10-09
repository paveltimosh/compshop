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
    private Integer memoryCapacity;

    public RAM(Long id, Integer price, String model, String maker, String type, Integer memoryCapacity) {
        super(id, price, model, maker);
        this.type = type;
        this.memoryCapacity = memoryCapacity;
    }
}
