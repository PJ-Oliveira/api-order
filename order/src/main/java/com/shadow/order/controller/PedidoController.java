package com.shadow.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shadow.order.client.OfferClient;
import com.shadow.order.client.ProductClient;
import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.service.OfferService;
import feign.FeignException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/order")
@Api(tags = {"Order"}, value = "Order Controller")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private final OfferService offerService;
    @Autowired
    private final OfferClient offerClient;
    @Autowired
    private final ProductClient productClient;


    @GetMapping("status/{id}")
    @ApiOperation(tags = {"Busque pelo ID apenas o Status"}, value="Mostre apenas o status")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
    public Object status(@PathVariable long id){
        Object object = offerClient.getStatusOffer(id);
        return object;
    }

    @PostMapping("/addPedido")
    @ApiOperation(tags = {"Cadastro"}, value="Faça seu pedido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
    public ResponseEntity<?> create(@RequestBody PedidoDtoRequest pedidoDtoRequest, Long id){
        try {
            PedidoDtoResponse pedidoDtoResponse = offerService.save(pedidoDtoRequest);
                Object status = offerClient.getStatusOffer(id);
            if(status == "ATIVO") {
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{idOffer}")
                        .buildAndExpand(pedidoDtoResponse.getIdPedido()).toUri();

                return ResponseEntity.created(uri).body(pedidoDtoResponse);
            }

        } catch (FeignException.FeignClientException feignClientException) {
            feignClientException.printStackTrace();
        } return ResponseEntity.ok().body("O desconto associado a esse produto não existe mais");

    }

    /*public ResponseEntity<?> create(@RequestBody PedidoDtoRequest pedidoDtoRequest, Long id){
        Object object = offerClient.getStatusOffer(id);
        PedidoDtoResponse pedidoDtoResponse = offerService.save(pedidoDtoRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(pedidoDtoResponse.getIdPedido()).toUri();

        if (object != "INATIVO") {
            return ResponseEntity.created(uri).body(pedidoDtoResponse);
        } else return ResponseEntity.ok().body("O desconto associado a esse produto não existe mais");

    }*/



    @GetMapping("alloffer")
    @ApiOperation(tags = {"Lista completa"}, value="Lista de todas as ofertas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
    public List<Object> getOffer(){
        return offerClient.getOffer();
    }

    @GetMapping("allproduct")
    @ApiOperation(tags = {"Lista completa"}, value="Lista de todos produtos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
    public List<Object> getProduct(){
        return productClient.getProduct();
    }

    @GetMapping("offer/{id}")
    @ApiOperation(tags = {"Busque pelo ID"}, value="Encontre oferta por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
    public Object findOneOffer(@PathVariable Long id){
        return offerClient.getOfferById(id);
    }

    @GetMapping("product/{id}")
    @ApiOperation(tags = {"Busque pelo ID"}, value="Encontre product por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
    public Object findOneProduct(@PathVariable Long id){
        return productClient.getProductById(id);
    }



}