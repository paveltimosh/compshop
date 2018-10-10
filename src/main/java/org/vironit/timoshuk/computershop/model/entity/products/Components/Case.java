package org.vironit.timoshuk.computershop.model.entity.products.Components;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString()
@EqualsAndHashCode(callSuper = true)
public class Case extends Component {
    private String material;
    private String typeOfCase;
    private String powerSupplyUnit;

    public Case(Long id, Integer price, String model, String maker, String material, String typeOfCase, String powerSupplyUnit) {
        super(id, price, model, maker);
        this.material = material;
        this.typeOfCase = typeOfCase;
        this.powerSupplyUnit = powerSupplyUnit;
    }
}
