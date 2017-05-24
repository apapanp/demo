package com.criminalcase.service;

import com.criminalcase.domain.TradeCard;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by apapan on 5/24/2017 AD.
 */
@Component("TradeCardService")
@Transactional
public class TradeCardServiceImpl implements TradeCardService {
    private final TradeCardRepository tradeCardRepository;

    public TradeCardServiceImpl(TradeCardRepository tradeCardRepository) {
        this.tradeCardRepository = tradeCardRepository;
    }

    @Override
    public List<TradeCard> getAll() {
        return tradeCardRepository.getAll();
    }

    @Override
    public List<TradeCard> findById(String id) {
        return tradeCardRepository.findById(id);
    }

    @Override
    public List<TradeCard> findByCard_number(List<String> card_number ) {
        return tradeCardRepository.findByCard_number(card_number);
    }
}
