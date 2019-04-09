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
@Table(name = "videocards")
@NoArgsConstructor
@AllArgsConstructor
public class VideoCard extends Component implements Serializable {

    private static final long serialVersionUID = 2526239902823792887L;

    @Column(name = "video_capacity")
    private String videoCapacity;

    @Column(name = "type_graphics_processor")
    private String typeGraphicsProcessor;

    @Column(name = "type_video_memory")
    private String typeVideoMemory;

}
