package org.vironit.timoshuk.computershop.entity.products.Components;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cases")
@NoArgsConstructor
@AllArgsConstructor
public class Case extends Component implements Serializable {

    private static final long serialVersionUID = -5265907039198363238L;

    @Column(name = "material")
    private String material;

    @Column(name = "type_of_case")
    private String typeOfCase;

    @Column(name = "power_supply_unit")
    private String powerSupplyUnit;

}
