package com.criminalcase.service;

import com.criminalcase.domain.TradeRecordCardAmtFrq;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by apapan on 5/26/2017 AD.
 */
public interface TradeRecordCardAmtFrqRepository extends JpaRepository<TradeRecordCardAmtFrq,Long> {
    @Modifying
    @Transactional
    @Query(value = "select count(1) as frequency,a.money_amount,b.card_number,(@cnt\\:=@cnt+1) as id from t_trade_record a\n" +
            "join  t_card b\n" +
            "on  a.from_card_id = b.id\n" +
            "CROSS JOIN (SELECT @cnt\\:=0) AS dummy\n"+
            "where b.card_number in :ids \n" +
            "and STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s') >= STR_TO_DATE(:startdate,'%Y%m%d%H%i%s') \n"+
            "and STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s') <= STR_TO_DATE(:enddate,'%Y%m%d%H%i%s') \n" +
            "group by b.card_number,a.money_amount "
            ,nativeQuery = true)
    List<TradeRecordCardAmtFrq> findByCard_numberAndFrequencyFrom (@Param("ids") List<String> inventoryIdList, @Param("startdate") String startdate, @Param("enddate") String enddate);

    @Modifying
    @Transactional
    @Query(value = " select count(1) as frequency,a.money_amount,b.card_number,(@cnt\\:=@cnt+1) as id  from t_trade_record a\n" +
            "join  t_card b\n" +
            "on  a.to_card_id = b.id\n" +
            "CROSS JOIN (SELECT @cnt\\:= 0) AS dummy\n"+
            "where b.card_number in :ids " +
            "and STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s') >= STR_TO_DATE(:startdate,'%Y%m%d%H%i%s') "+
            "and STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s') <= STR_TO_DATE(:enddate,'%Y%m%d%H%i%s') " +
            "group by b.card_number,a.money_amount "
            ,nativeQuery = true)
    List<TradeRecordCardAmtFrq> findByCard_numberAndFrequencyTo (@Param("ids") List<String> inventoryIdList, @Param("startdate") String startdate, @Param("enddate") String enddate);



}
