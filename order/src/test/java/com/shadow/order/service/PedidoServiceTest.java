package com.shadow.order.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.shadow.order.advice.exception.OrderException;
import com.shadow.order.client.OfferClient;
import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
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

    @Test
    public void testSave() {
        when(this.offerClient.getIdOffer((Long) any())).thenReturn(1L);
        when(this.modelMapper.map((Object) any(), (Class<Object>) any())).thenThrow(new OrderException());
        PedidoDtoRequest pedidoDtoRequest = new PedidoDtoRequest();
        assertNull(this.pedidoService.save(1L, pedidoDtoRequest));
        verify(this.offerClient).getIdOffer((Long) any());
        verify(this.modelMapper).map((Object) any(), (Class<Object>) any());
        assertEquals(1L, pedidoDtoRequest.getIdOffer().longValue());
    }

}

