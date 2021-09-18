package com.shadow.order.service;

<<<<<<< HEAD
import static org.assertj.core.api.Assertions.assertThatThrownBy;
=======


import static org.junit.jupiter.api.Assertions.assertThrows;
>>>>>>> 88f3b1c (Atualizações de Exceções)
import static org.mockito.Mockito.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
<<<<<<< HEAD

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
=======
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
>>>>>>> 88f3b1c (Atualizações de Exceções)
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
<<<<<<< HEAD
=======
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



>>>>>>> 88f3b1c (Atualizações de Exceções)

import com.shadow.order.domain.models.Pedido;
import com.shadow.order.exception.ResourceNotFoundException;
import com.shadow.order.feature.ScenarioFactory;
import com.shadow.order.repository.PedidoRepository;
import com.shadow.order.util.CalcularPedido;
import com.shadow.order.validator.Validate;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PedidoServiceTest {
	
	
	@InjectMocks
	private PedidoService pedidoService;
	@Mock
	private PedidoRepository pedidoRepository;
	@Mock
	private ModelMapper modelMapper;
	@Mock
	private Validate validator;
	@Mock
	private CalcularPedido calcular;
	
	
	@Test
	public void findById_PedidoFindById_ExpectedSuccess() {
		var pedido = ScenarioFactory.newPedido();
		Optional<Pedido> pedidos = Optional.of(pedido);
		given(pedidoRepository.findById(1L)).willReturn(pedidos);
			pedidoService.findById(1L);
		
			verify(pedidoRepository, timeout(1)).findById(1L);
		
	}
	
	@Test
	public void findById_PedidoNotFindById_ExpectedThrownsException() {
		var pedido = ScenarioFactory.newPedido();
		given(pedidoRepository.findById(eq(pedido.getIdPedido()))).willReturn(Optional.empty());
		
			assertThatThrownBy(()-> pedidoService.findById(2L))
								.isInstanceOf(ResourceNotFoundException.class)
								.hasMessageContaining("Resource not found ", pedido.getIdPedido());
			
			verify(pedidoRepository, timeout(1)).findById(2L);
		
		
	}
	
	@Test
	public void delete_PedidoDeleteFindById_ExpectedSuccess(){
		var pedido = ScenarioFactory.newPedido();
		Optional<Pedido> pedidos = Optional.of(pedido);
			when(pedidoRepository.findById(eq(pedido.getIdPedido()))).thenReturn(pedidos);
			pedidoService.delete(1L);
			
			verify(pedidoRepository, timeout(1)).delete(pedido);
	}
	
	@Test
	public void delete_PedidoDeleteNotFindById_ExpectdThrownsException() {
		var pedido = ScenarioFactory.newPedido();
		given(pedidoRepository.findById(eq(pedido.getIdPedido()))).willReturn(Optional.empty());
		
			assertThatThrownBy(()-> pedidoService.delete(2L))
								.isInstanceOf(ResourceNotFoundException.class)
								.hasMessageContaining("Resource not found: ",pedido.getIdPedido());
			
			verify(pedidoRepository, timeout(1)).findById(2L);
	}
	@Test
	public void findAll_PedidoAllList_ExpectedSuccess() {
		var pedidos = ScenarioFactory.newListPedido();
		
		given(pedidoRepository.findAll()).willReturn(pedidos);
			pedidoService.getAll();
		
		verify(pedidoRepository, timeout(1)).findAll();
	}
	
	@Test
	public void save_SavePedido_ExpectedSuccess() {
		var pedido = ScenarioFactory.newPedido();
		var pedidoResponse = ScenarioFactory.newPedidoResponse();
		var pedidoRequest = ScenarioFactory.newPedidoRequest();
		
		given(pedidoRepository.save(pedido)).willReturn(pedido);
			validator.validator(pedido);
			calcular.calcularPedido(pedido);
			when(pedidoService.save(pedidoRequest)).thenReturn(pedidoResponse);
			
		verify(pedidoRepository, timeout(1)).save(any());
		
				}
	
	
	
}
