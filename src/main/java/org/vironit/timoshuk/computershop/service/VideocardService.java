package org.vironit.timoshuk.computershop.service;

import org.vironit.timoshuk.computershop.entity.products.Components.RAM;
import org.vironit.timoshuk.computershop.entity.products.Components.VideoCard;

import java.util.List;

public interface VideocardService {
    VideoCard findById(Long id);
    List<VideoCard> findAll();
    void create(final VideoCard videoCard);
    void update(final VideoCard videoCard);
    void delete(final VideoCard videoCard);
    void deleteById(Long id);
}
