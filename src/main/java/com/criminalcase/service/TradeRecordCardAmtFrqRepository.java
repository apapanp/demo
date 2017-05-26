package com.criminalcase.service;

import com.criminalcase.domain.TradeRecordCardAmtFrq;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by apapan on 5/26/2017 AD.
 */
public interface TradeRecordCardAmtFrqRepository extends Repository<TradeRecordCardAmtFrq,Long> {
    @Modifying
    @Query(value = "select count(1) as frequency,a.money_amount,b.card_number,b.id as card_id from t_trade_record a\n" +
            "join  t_card b\n" +
            "on  a.from_card_id = b.id\n" +
            "where b.card_number in :ids " +
            "and STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s') >= STR_TO_DATE(:startdate,'%Y%m%d%H%i%s') "+
            "and STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s') <= STR_TO_DATE(:enddate,'%Y%m%d%H%i%s') " +
            "group by b.card_number,b.id,a.money_amount "
            ,nativeQuery = true)
    List<TradeRecordCardAmtFrq> findFrqAmtByFromCard_number (@Param("ids") List<String> inventoryIdList, @Param("startdate") String startdate, @Param("enddate") String enddate);

    @Modifying
    @Query(value = "select count(1) as frequency,a.money_amount,b.card_number,b.id as card_id from t_trade_record a\n" +
            "join  t_card b\n" +
            "on  a.to_card_id = b.id\n" +
            "where b.card_number in :ids " +
            "and STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s') >= STR_TO_DATE(:startdate,'%Y%m%d%H%i%s') "+
            "and STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s') <= STR_TO_DATE(:enddate,'%Y%m%d%H%i%s') " +
            "group by b.card_number,b.id,a.money_amount "
            ,nativeQuery = true)
    List<TradeRecordCardAmtFrq> findFrqAmtByToCard_number (@Param("ids") List<String> inventoryIdList, @Param("startdate") String startdate, @Param("enddate") String enddate);

}
