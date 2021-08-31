package com.shadow.order.controller;

import com.shadow.order.client.OfferClient;
import com.shadow.order.client.ProductClient;
import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.service.OfferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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
        Object object = offerClient.getOfferStatus(id);
        return object;
    }

    @GetMapping("desconto/{id}")
    @ApiOperation(tags = {"Busque pelo ID apenas o valor do desconto"}, value="Mostre apenas o desconto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
    public Object showDesconto(@PathVariable long id){
        Object object = offerClient.getDescontoOffer(id);
        return object;
    }

    @GetMapping("fim/{id}")
    @ApiOperation(tags = {"Busque pelo ID apenas a data final do desconto"}, value="Mostre apenas a data")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
    public Object showFim(@PathVariable long id){
        Object object = offerClient.getDataFim(id);
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
    public ResponseEntity<PedidoDtoResponse> create( @RequestBody PedidoDtoRequest pedidoDtoRequest, @Valid Long id) {

        pedidoDtoRequest.setDate(pedidoDtoRequest.getDate());
        pedidoDtoRequest.setTotal(pedidoDtoRequest.getTotal());
        pedidoDtoRequest.setIdProduct(pedidoDtoRequest.getIdProduct());
        pedidoDtoRequest.setIdOffer(pedidoDtoRequest.getIdOffer());
        PedidoDtoResponse pedidoDtoResponse = offerService.save(pedidoDtoRequest);
        return ResponseEntity.ok().body(pedidoDtoResponse);
    }



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