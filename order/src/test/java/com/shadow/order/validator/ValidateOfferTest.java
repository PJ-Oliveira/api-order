package com.shadow.order.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.shadow.order.ScenarioFactory;
import com.shadow.order.configuration.OfferClientConfig;
import com.shadow.order.domain.models.Item;
import com.shadow.order.domain.models.Offer;
import com.shadow.order.domain.models.Pedido;
import com.shadow.order.exception.InvalidOrderException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ValidateOffer.class, Validate.class})
@ExtendWith(MockitoExtension.class)
class ValidateOfferTest {

    @Mock
    private OfferClientConfig offerClientConfig;
    @Mock
    private Validate validate;
    @InjectMocks
    private ValidateOffer validateOffer;

    @Test
    void validatePedido_WhenValidatedPedido_SucessExpected() {
        var pedido = ScenarioFactory.newPedido();
        this.validateOffer.validate(pedido);
        assertEquals(1L, pedido.getIdPedido().longValue());
        assertEquals("Pedido(idPedido=1, item=[], totalPedido=2)", pedido.toString());
        assertTrue(pedido.getItem().isEmpty());
    }

    @Test
    void validatePedido2_WhenValidatedPedido_SucessExpected() {
        var item = ScenarioFactory.newItem();
        var pedido = ScenarioFactory.newPedido2();
        doNothing().when(this.validate).validator((Pedido) pedido);
        when(this.offerClientConfig.verifyIfOfferExist((Long) 1L)).thenReturn(Optional.<Offer>of(new Offer()));
        this.validateOffer.validate(pedido);
        verify(this.validate, atLeast(1)).validator((Pedido) pedido);
        verify(this.offerClientConfig).verifyIfOfferExist((Long) 1L);
    }

    @Test
    void verifyOffer_WhenOfferExist_SucessExpected() {
        var pedido = ScenarioFactory.newPedido();
        assertEquals(1L, pedido.getIdPedido().longValue());
        assertEquals("Pedido(idPedido=1, item=[], totalPedido=2)", pedido.toString());
        assertTrue(pedido.getItem().isEmpty());
    }

    @Test
    void verifyOffer_WhenOfferExist_SucessExpected2() {
        var item = ScenarioFactory.newItem();
        var pedido = ScenarioFactory.newPedido2();
        doNothing().when(this.validate).validator((Pedido) any());
        when(this.offerClientConfig.verifyIfOfferExist((Long) any())).thenReturn(Optional.<Offer>of(new Offer()));
        this.validateOffer.verifyIfOfferExist(pedido);
        verify(this.validate).validator((Pedido) pedido);
        verify(this.offerClientConfig).verifyIfOfferExist((Long) 1L);

    }










}

