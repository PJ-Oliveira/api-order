package com.shadow.order.service;



import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.shadow.order.advice.exception.OrderException;
import com.shadow.order.client.OfferClient;
import com.shadow.order.client.ProductClient;
import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.domain.models.Item;
import com.shadow.order.domain.models.Pedido;
import com.shadow.order.repository.ItemRepository;
import com.shadow.order.repository.PedidoRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(classes = {PedidoService.class, ModelMapper.class})
@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {


    @MockBean
    private ItemRepository itemRepository;

    @MockBean
    private PedidoRepository pedidoRepository;

    @MockBean
    private ProductClient productClient;
    @Mock
    @Autowired
    private ModelMapper modelMapper;

    @Mock
    private OfferClient offerClient;

    @InjectMocks
    private PedidoService pedidoService;

    @Test
    public void testSave() {
        when(this.modelMapper.map((Object) any(), (Class<Object>) any())).thenThrow(new OrderException());
        assertThrows(OrderException.class, () -> this.pedidoService.save(new PedidoDtoRequest()));
        verify(this.modelMapper).map((Object) any(), (Class<Object>) any());
    }





}

