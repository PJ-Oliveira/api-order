package com.shadow.order.controller;

import com.shadow.order.service.ClientServiceProxy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/order")
@Api(tags = {"Order"}, value = "Order Controller")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private final ClientServiceProxy clientServiceProxy;

    @GetMapping
    @ApiOperation(httpMethod = "GET", notes = "Liste todas as ofertas disponíveis aqui no seu Order",tags = {"Lista completa"}, value="Lista de todas as ofertas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
    public List<Object> getOffer(){
        return clientServiceProxy.getOffer();
    }

    @GetMapping("/{id}")
    @ApiOperation(tags = {"Busque pelo ID"}, value="Encontre oferta por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
    public Object findOneOrder(@PathVariable Long id){
        return clientServiceProxy.getById(id);
    }

}
