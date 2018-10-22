package org.vironit.timoshuk.computershop.entity.products;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.vironit.timoshuk.computershop.entity.products.Components.*;

@Getter
@Setter
@EqualsAndHashCode()

public class Computer {

    private Long id;
    private Integer price;
    private String compDescription;
    private Case aCase;
    private CPU cpu;
    private MotherBoard motherBoard;
    private RAM ram;
    private VideoCard videoCard;

    public Computer() {
    }

    public Computer(Long id, Integer price, String compDescription, Case aCase, CPU cpu, MotherBoard motherBoard, RAM ram, VideoCard videoCard) {
        this.id = id;
        this.price = price;
        this.compDescription = compDescription;
        this.aCase = aCase;
        this.cpu = cpu;
        this.motherBoard = motherBoard;
        this.ram = ram;
        this.videoCard = videoCard;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", price=" + price +
                ", compDescription='" + compDescription + '\'' +"\n"+
                ", aCase=" + aCase + "\n"+
                ", cpu=" + cpu +"\n"+
                ", motherBoard=" + motherBoard +"\n"+
                ", ram=" + ram +"\n"+
                ", videoCard=" + videoCard +
                '}';
    }
}
