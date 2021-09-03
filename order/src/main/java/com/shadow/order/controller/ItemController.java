package com.shadow.order.controller;

import com.shadow.order.client.OfferClient;
import com.shadow.order.client.ProductClient;
import com.shadow.order.domain.dto.dtorequest.ItemDtoRequest;
import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.ItemDtoResponse;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/item")
@RequiredArgsConstructor
@Api(tags = {"ITEM"}, value = "Controller ITEM")
public class ItemController {

    @Autowired
    private final ProductClient productClient;
    @Autowired
    private final OfferClient offerClient;
    @Autowired
    private final ItemService itemService;


    @Transactional
    @PostMapping
    @ApiOperation(tags = {"Cadastro de Itens"}, value="Cadastro de Itens")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
    public ResponseEntity<ItemDtoResponse> create(@Valid @RequestBody ItemDtoRequest itemDtoRequest){
        ItemDtoResponse itemDtoResponse = itemService.save(itemDtoRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(itemDtoResponse.getIdItem()).toUri();
        return ResponseEntity.created(uri).body(itemDtoResponse);
    }

    @GetMapping("{id}")
    @ApiOperation(httpMethod = "GET", notes = "Busque a item pelo seu respectivo ID",tags = {"Busque pelo ID"}, value="Encontre item por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
    public ResponseEntity<ItemDtoResponse> findOneOffer(@Valid @PathVariable long id){
        ItemDtoResponse itemDtoResponse = itemService.getById(id);
        return ResponseEntity.ok().body(itemDtoResponse);
    }


}
