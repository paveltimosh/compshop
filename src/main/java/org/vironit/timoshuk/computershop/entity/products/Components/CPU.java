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
@Table(name = "cpu")
public class CPU extends Component implements Serializable {

    private static final long serialVersionUID = -4239668863693050420L;

    @Column(name = "processor_type")
    private String processorType;

    @Column(name = "number_of_cores")
    private Integer numberOfCores;

    @Column(name = "speed")
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
