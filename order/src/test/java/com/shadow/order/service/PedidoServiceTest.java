package com.shadow.order.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.shadow.order.client.OfferClient;
import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.exception.OrderException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {PedidoService.class, ModelMapper.class})
@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {


    @Mock
    @Autowired
    private ModelMapper modelMapper;

    @Mock
    private OfferClient offerClient;

    @InjectMocks
    private PedidoService pedidoService;



}

