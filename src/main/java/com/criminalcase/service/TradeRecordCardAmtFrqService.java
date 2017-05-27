package com.criminalcase.service;

import com.criminalcase.domain.TradeRecordCardAmtFrq;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by apapan on 5/26/2017 AD.
 */
public interface TradeRecordCardAmtFrqService {

    List<TradeRecordCardAmtFrq> findByCard_numberAndFrequencyFrom (@Param("ids") List<String> inventoryIdList, @Param("startdate") String startdate, @Param("enddate") String enddate);
    List<TradeRecordCardAmtFrq> findByCard_numberAndFrequencyTo (@Param("ids") List<String> inventoryIdList, @Param("startdate") String startdate, @Param("enddate") String enddate);
}
