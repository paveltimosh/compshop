package org.vironit.timoshuk.computershop.entity.products.Components;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "rams")
public class RAM extends Component implements Serializable {

    private static final long serialVersionUID = -4793103779061627845L;

    @Column(name = "type")
    private String type;

    @Column(name = "memory_capacity")
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
