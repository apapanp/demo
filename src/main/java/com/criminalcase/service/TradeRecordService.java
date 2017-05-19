package com.criminalcase.service;

import com.criminalcase.domain.TradeRecord;
import org.springframework.data.repository.query.Param;


import java.util.List;

/**
 * Created by apapan on 5/19/2017 AD.
 */
public interface TradeRecordService {
    List<TradeRecord> getAll();
    List<TradeRecord>  findTradeRecordByFrom_card_idIs(int from_card_id,String startdate,String enddate);
    List<TradeRecord>  findTradeRecordByTo_card_idIs(int to_card_id,String startdate,String enddate);
    List<TradeRecord> findTradeRecordByTo_card_idContains(@Param("ids") List<Integer> inventoryIdList);
}
