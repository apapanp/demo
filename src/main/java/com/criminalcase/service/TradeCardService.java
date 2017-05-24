package com.criminalcase.service;

import com.criminalcase.domain.TradeCard;

import java.util.List;

/**
 * Created by apapan on 5/24/2017 AD.
 */
public interface TradeCardService {
    List<TradeCard> getAll();
    List<TradeCard> findById (String id);
    List<TradeCard> findByCard_number (List<String> card_number);
}
