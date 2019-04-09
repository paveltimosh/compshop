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
@Table(name = "rams")
@NoArgsConstructor
@AllArgsConstructor
public class RAM extends Component implements Serializable {

    private static final long serialVersionUID = -4793103779061627845L;

    @Column(name = "type")
    private String type;

    @Column(name = "memory_capacity")
    private String memoryCapacity;
}
