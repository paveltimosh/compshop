package org.vironit.timoshuk.computershop.entity.products.Components;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "videocards")
public class VideoCard extends Component {

    @Column(name = "video_capacity")
    private String videoCapacity;

    @Column(name = "type_graphics_processor")
    private String typeGraphicsProcessor;

    @Column(name = "type_video_memory")
    private String typeVideoMemory;

    public VideoCard (){}

    public VideoCard(Long id, Integer price, String model, String maker, String videoCapacity, String typeGraphicsProcessor, String typeVideoMemory) {
        super(id, price, model, maker);
        this.videoCapacity = videoCapacity;
        this.typeGraphicsProcessor = typeGraphicsProcessor;
        this.typeVideoMemory = typeVideoMemory;
    }

    public VideoCard(String videoCapacity, String typeGraphicsProcessor, String typeVideoMemory) {
        this.videoCapacity = videoCapacity;
        this.typeGraphicsProcessor = typeGraphicsProcessor;
        this.typeVideoMemory = typeVideoMemory;
    }
}
