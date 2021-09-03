package com.shadow.order.service;

import com.shadow.order.advice.exception.OrderException;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.Date;

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
