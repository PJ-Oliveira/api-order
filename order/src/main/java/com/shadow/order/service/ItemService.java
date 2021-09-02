package com.shadow.order.service;

import com.shadow.order.client.OfferClient;
import com.shadow.order.client.ProductClient;
import com.shadow.order.domain.dto.dtorequest.ItemDtoRequest;
import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.ItemDtoResponse;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.domain.models.Item;
import com.shadow.order.domain.models.Pedido;
import com.shadow.order.repository.ItemRepository;
import com.shadow.order.repository.PedidoRepository;
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


}
