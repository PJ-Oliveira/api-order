package com.shadow.order.service;



import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.domain.models.Pedido;
import com.shadow.order.exception.ResourceNotFoundException;
import com.shadow.order.feature.ScenarioFactory;
import com.shadow.order.repository.PedidoRepository;
import com.shadow.order.validator.ValidateOrder;

@RunWith(MockitoJUnitRunner.class)
public class PedidoServiceTest {
	
	
	@InjectMocks
	private PedidoService pedidoService;
	@Mock
	private PedidoRepository pedidoRepository;
	@Mock
	private ModelMapper modelMapper;
	@Mock
	private ValidateOrder validatorOrder;
	
	
	
	@Test
	public void findById_WhenReceiveValidIdOrder_ExpectedSuccess() {
		var pedido = ScenarioFactory.newPedido();
		var pedidoOptional = ScenarioFactory.newOptionalPedido();
		var pedidoResponse = ScenarioFactory.newPedidoResponse();
		
			when(pedidoRepository.findById(eq(pedido.getIdPedido()))).thenReturn(pedidoOptional);
			when(modelMapper.map(pedido, PedidoDtoResponse.class)).thenReturn(pedidoResponse);
			pedidoService.findById(1L);
		
			verify(pedidoRepository, timeout(1)).findById(1L);
		
	}
	
	@Test
	public void findById_WhenReceiveIdOrderNotValid_ExpectedThrownsException() {
		var pedido = ScenarioFactory.newPedido();
		given(pedidoRepository.findById(2L)).willReturn(Optional.empty());
		
			assertThatThrownBy(()-> pedidoService.findById(2L))
								.isInstanceOf(ResourceNotFoundException.class)
								.hasMessageContaining("Resource not found ", pedido.getIdPedido());
			
			verify(pedidoRepository, timeout(1)).findById(2L);
		
		
	}
	
	@Test
	public void delete_WhenReceiveIdOrderValid_ExpectedSuccess(){
		var pedido = ScenarioFactory.newPedido();
		Optional<Pedido> pedidoOptional = Optional.of(pedido);
			when(pedidoRepository.findById(eq(pedido.getIdPedido()))).thenReturn(pedidoOptional);
			pedidoService.delete(1L);
			
			verify(pedidoRepository, timeout(1)).delete(pedido);
	}
	
	@Test
	public void delete_WhenReceiveIdOrderNotValid_ExpectdThrownsException() {
		var pedido = ScenarioFactory.newPedido();
		given(pedidoRepository.findById(2L)).willReturn(Optional.empty());
		
			assertThatThrownBy(()-> pedidoService.delete(2L))
								.isInstanceOf(ResourceNotFoundException.class)
								.hasMessageContaining("Resource not found: ",pedido.getIdPedido());
			
			verify(pedidoRepository, timeout(1)).findById(2L);
	}
	
	
	@Test
	public void findAll_WhenSearchingAllOrders_ExpectedSuccess() {
		var listPedidos = ScenarioFactory.newListPedido();
		
		given(pedidoRepository.findAll()).willReturn(listPedidos);
		pedidoService.getAll();
		
		verify(pedidoRepository, timeout(1)).findAll();
	}
	
	@Test
	public void save_SavePedido_ExpectedSuccess() {
		var pedido = ScenarioFactory.newPedido();
		var pedidoResponse = ScenarioFactory.newPedidoResponse();
		var pedidoRequest = ScenarioFactory.newPedidoRequest();
		
		when(modelMapper.map(pedidoRequest, Pedido.class)).thenReturn(pedido);
		doNothing().when(validatorOrder).validator(pedido);
		when(pedidoRepository.save(pedido)).thenReturn(pedido);
		when(modelMapper.map(pedido, PedidoDtoResponse.class)).thenReturn(pedidoResponse);
		
		pedidoService.save(pedidoRequest);
			
		verify(pedidoRepository, timeout(1)).save(pedido);
		
	}
	
	
	


}
