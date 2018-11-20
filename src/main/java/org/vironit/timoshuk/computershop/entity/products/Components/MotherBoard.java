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
@Table(name = "motherboards")
@NoArgsConstructor
@AllArgsConstructor
public class MotherBoard extends Component implements Serializable {

    private static final long serialVersionUID = 7133899839366163513L;

    @Column(name = "form_factor")
    private String formFactor;

    @Column(name = "memory_technology")
    private String memoryTechnology;

    @Column(name = "cpu_socket_type")
    private String cpuSocketType;

}
