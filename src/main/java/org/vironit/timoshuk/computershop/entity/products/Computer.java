package org.vironit.timoshuk.computershop.entity.products;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.vironit.timoshuk.computershop.entity.products.Components.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, of = {"id", "model"})
public class Computer extends Item{

    private Long id;
    private Integer price;
    private String model;
    private Case cases;
    private CPU cpu;
    private MotherBoard motherBoard;
    private RAM ram;
    private VideoCard videoCard;

    public Computer() {
    }

    public Computer(Long id, Integer price, String model, Case aCase, CPU cpu, MotherBoard motherBoard, RAM ram, VideoCard videoCard) {
        super(id);
        this.id = id;
        this.price = price;
        this.model = model;
        this.cases = aCase;
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
                ", compDescription='" + model + '\'' +"\n"+
                ", aCase=" + cases + "\n"+
                ", cpu=" + cpu +"\n"+
                ", motherBoard=" + motherBoard +"\n"+
                ", ram=" + ram +"\n"+
                ", videoCard=" + videoCard +
                '}';
    }
}