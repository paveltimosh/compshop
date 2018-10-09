package org.vironit.timoshuk.computershop.model.entity.products;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.vironit.timoshuk.computershop.model.entity.products.Components.*;

@Getter
@Setter
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = "id")

public class Computer {

    private Long id;
    private Integer price;
    private Case aCase;
    private CPU cpu;
    private MotherBoard motherBoard;
    private RAM ram;
    private VideoCard videoCard;

}
