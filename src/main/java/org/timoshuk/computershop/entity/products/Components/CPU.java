package org.timoshuk.computershop.entity.products.Components;

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
@Table(name = "cpu")
@NoArgsConstructor
@AllArgsConstructor
public class CPU extends Component implements Serializable {

    private static final long serialVersionUID = -4239668863693050420L;

    @Column(name = "processor_type")
    private String processorType;

    @Column(name = "number_of_cores")
    private Integer numberOfCores;

    @Column(name = "speed")
    private String cpuSpeed;

}
