package org.timoshuk.computershop.entity.products;

import lombok.*;
import org.timoshuk.computershop.entity.products.Components.*;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, of = {"id"})
@Entity
@Table(name = "computers")
@NoArgsConstructor
@AllArgsConstructor
public class Computer extends Item implements Serializable {

    private static final long serialVersionUID = 2967751437487461522L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "comp_seq")
    @SequenceGenerator(name = "comp_seq", sequenceName = "id_component_seq", allocationSize = 1)
    private Long id;

    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String model;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_case", referencedColumnName = "id")
    private Case cases;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cpu", referencedColumnName = "id")
    private CPU cpu;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_motherboard", referencedColumnName = "id")
    private MotherBoard motherBoard;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ram", referencedColumnName = "id")
    private RAM ram;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_videocard", referencedColumnName = "id")
    private VideoCard videoCard;

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", price=" + price +
                ", compDescription='" + model + '\'' +"\n"+
                ", aCase=" + cases + "\n"+
                ", cpu=" + cpu +"\n"+
                ", motherBoard=" + motherBoard +"\n"+
                ", ram=" + ram +"\n"+
                ", videoCard=" + videoCard +
                '}';
    }
}
