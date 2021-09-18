package com.shadow.order.service;

import com.shadow.order.advice.exception.OrderException;
import com.shadow.order.client.OfferClient;
import com.shadow.order.client.ProductClient;
import com.shadow.order.domain.dto.dtorequest.ItemDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.ItemDtoResponse;
import com.shadow.order.domain.models.Item;
import com.shadow.order.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private OfferClient offerClient;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductClient productClient;

    public ItemDtoResponse save(ItemDtoRequest itemDtoRequest){
        Item item = modelMapper.map(itemDtoRequest, Item.class);
        itemRepository.save(item);
        return modelMapper.map(item, ItemDtoResponse.class);
    }


    public ItemDtoResponse getById(Long id){
        Item item = itemRepository.findById(id)
                .orElseThrow(()-> new OrderException("Resource with id: " + id + "not found"));
        return modelMapper.map(item, ItemDtoResponse.class);
    }


}
