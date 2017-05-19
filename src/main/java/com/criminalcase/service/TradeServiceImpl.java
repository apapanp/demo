package com.criminalcase.service;

import com.criminalcase.domain.TradeRecord;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by apapan on 5/19/2017 AD.
 */
@Component("TradeRecordService")
@Transactional
public class TradeServiceImpl implements TradeRecordService{

    private final TradeRecordRepository recordRepository;
    public TradeServiceImpl(TradeRecordRepository recordRepository){
        this.recordRepository=recordRepository;
    }

    @Override
    public List<TradeRecord> getAll() {
        return recordRepository.getAll();
    }

   @Override
    public List<TradeRecord> findTradeRecordByFrom_card_idIs(int from_card_id,String startdate,String enddate) {
        return recordRepository.findTradeRecordByFrom_card_idIs(from_card_id,startdate,enddate);
    }

    @Override
    public List<TradeRecord> findTradeRecordByTo_card_idIs(int to_card_id,String startdate,String enddate) {
        return recordRepository.findTradeRecordByTo_card_idIs(to_card_id,startdate,enddate);
    }

    @Override
    public List<TradeRecord> findTradeRecordByTo_card_idContains(@Param("ids") List<Integer> inventoryIdList) {
        return recordRepository.findTradeRecordByTo_card_idContains(inventoryIdList);
    }

}