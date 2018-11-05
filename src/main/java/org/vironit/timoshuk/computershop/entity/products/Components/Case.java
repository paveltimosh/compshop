package org.vironit.timoshuk.computershop.entity.products.Components;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cases")
public class Case extends Component {

    @Column(name = "material")
    private String material;

    @Column(name = "type_of_case")
    private String typeOfCase;

    @Column(name = "power_supply_unit")
    private String powerSupplyUnit;

    public Case(){
    }

    public Case( Long id, Integer price, String model, String maker, String material, String typeOfCase, String powerSupplyUnit) {
        super( id, price, model, maker);
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
