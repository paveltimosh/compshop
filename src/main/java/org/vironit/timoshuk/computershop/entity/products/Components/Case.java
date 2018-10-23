package org.vironit.timoshuk.computershop.entity.products.Components;

import lombok.*;

@Getter
@Setter
@ToString()
@EqualsAndHashCode(callSuper = true)
public class Case extends Component {
    private String material;
    private String typeOfCase;
    private String powerSupplyUnit;

    public Case(){

    }

    public Case(Long id, Integer price, String model, String maker, String material, String typeOfCase, String powerSupplyUnit) {
        super(id, price, model, maker);
        this.material = material;
        this.typeOfCase = typeOfCase;
        this.powerSupplyUnit = powerSupplyUnit;
    }

    public Case(String material, String typeOfCase, String powerSupplyUnit) {
        this.material = material;
        this.typeOfCase = typeOfCase;
        this.powerSupplyUnit = powerSupplyUnit;
    }
}
