package com.shadow.order.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shadow.order.client.OfferClient;
import com.shadow.order.domain.dto.dtorequest.ItemDtoRequest;
import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.ItemDtoResponse;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.domain.models.Offer;
import com.shadow.order.service.ItemService;
import com.shadow.order.service.PedidoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/order")
public class PedidoController {
	
	
	@Autowired
	private ItemService itemService;

    @Autowired
    private OfferClient offerClient;
   
   



   


    @GetMapping("/oferta/{id}")
    public Offer getOffer(@PathVariable Long id){

        return offerClient.getById(id);
    }

    
    

}