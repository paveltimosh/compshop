package org.vironit.timoshuk.computershop.entity.products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Item {
    private Long id;

    public Item(Long id) {
    }
    public Item(){}
}
