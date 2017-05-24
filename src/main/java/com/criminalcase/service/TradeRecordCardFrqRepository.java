package com.criminalcase.service;

import com.criminalcase.domain.TradeCardAccount;
import com.criminalcase.domain.TradeRecordCardFrq;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by apapan on 5/24/2017 AD.
 */
public interface TradeRecordCardFrqRepository extends Repository<TradeRecordCardFrq,Long> {

    @Modifying
    @Query(value = "select count(1) as frequency,a.bank_address,b.card_number,b.id as case_id from t_trade_record a\n" +
            "join  t_card b\n" +
            "on  a.from_card_id = b.id\n" +
            "where b.card_number in :ids " +
            "and STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s') >= STR_TO_DATE(:startdate,'%Y%m%d%H%i%s') "+
            "and STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s') <= STR_TO_DATE(:enddate,'%Y%m%d%H%i%s') " +
            "group by a.bank_address,b.card_number,b.id "
            ,nativeQuery = true)
    List<TradeRecordCardFrq> findFrqByFromCard_number (@Param("ids") List<String> inventoryIdList, @Param("startdate") String startdate, @Param("enddate") String enddate);
}
