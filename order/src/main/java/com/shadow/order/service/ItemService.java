package com.shadow.order.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadow.order.domain.dto.dtorequest.ItemDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.ItemDtoResponse;
import com.shadow.order.domain.models.Item;
import com.shadow.order.repository.ItemRepository;

@Service
public class ItemService {

 
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ModelMapper modelMapper;
    

    public ItemDtoResponse save(ItemDtoRequest itemDtoRequest){
        Item item = modelMapper.map(itemDtoRequest, Item.class);
        itemRepository.save(item);
        return modelMapper.map(item, ItemDtoResponse.class);
    }
   


}
