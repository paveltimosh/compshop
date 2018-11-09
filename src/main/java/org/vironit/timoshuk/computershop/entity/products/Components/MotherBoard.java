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
@Table(name = "motherboards")
public class MotherBoard extends Component implements Serializable {

    private static final long serialVersionUID = 7133899839366163513L;

    @Column(name = "form_factor")
    private String formFactor;

    @Column(name = "memory_technology")
    private String memoryTechnology;

    @Column(name = "cpu_socket_type")
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
