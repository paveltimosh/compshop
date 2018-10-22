package org.vironit.timoshuk.computershop.entity.products.Components;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString()
@EqualsAndHashCode(callSuper = true)
public class VideoCard extends Component {
    private String VideoCapacity;
    private String typeGraphicsProcessor;
    private String typeVideoMemory;

    public VideoCard (){}

    public VideoCard(Long id, Integer price, String model, String maker, String videoCapacity, String typeGraphicsProcessor, String typeVideoMemory) {
        super(id, price, model, maker);
        VideoCapacity = videoCapacity;
        this.typeGraphicsProcessor = typeGraphicsProcessor;
        this.typeVideoMemory = typeVideoMemory;
    }

    public VideoCard(String videoCapacity, String typeGraphicsProcessor, String typeVideoMemory) {
        VideoCapacity = videoCapacity;
        this.typeGraphicsProcessor = typeGraphicsProcessor;
        this.typeVideoMemory = typeVideoMemory;
    }
}
