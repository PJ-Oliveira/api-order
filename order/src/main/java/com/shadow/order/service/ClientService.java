package com.shadow.order.service;



import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;


public interface ClientService {
    
    
    public List<Object> getOffer();

    public Object getById(@PathVariable("id") Long id);





}
