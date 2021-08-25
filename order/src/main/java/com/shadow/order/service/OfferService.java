package com.shadow.order.service;


import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface OfferService {

    public List<Object> getOffer();

    public List<Object> getOfferById(Long id);

}
