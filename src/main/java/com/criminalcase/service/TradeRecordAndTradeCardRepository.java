package com.criminalcase.service;

import com.criminalcase.domain.TradeCard;
import com.criminalcase.domain.TradeCardAccount;
import com.criminalcase.domain.TradeRecord;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by apapan on 5/24/2017 AD.
 */
public interface TradeRecordAndTradeCardRepository extends Repository<TradeCardAccount,Long>{

    @Modifying
    @Query(value = "select a.from_card_id as card_id, a.money_amount,a.date_time,b.card_number from t_trade_record a\n" +
            "join  t_card b\n" +
            "on  a.from_card_id = b.id\n" +
            "where b.card_number in :ids " +
            "and STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s') >= STR_TO_DATE(:startdate,'%Y%m%d%H%i%s') "+
            "and STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s') <= STR_TO_DATE(:enddate,'%Y%m%d%H%i%s') " +
            "order by STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s')  "
            ,nativeQuery = true)


    List<TradeCardAccount> findByFromCard_number (@Param("ids") List<String> inventoryIdList,@Param("startdate") String startdate,@Param("enddate") String enddate);

    @Modifying
    @Query(value = "select a.from_card_id as card_id, a.money_amount,a.date_time,b.card_number from t_trade_record a\n" +
            "join  t_card b\n" +
            "on  a.to_card_id = b.id\n" +
            "where b.card_number in :ids " +
            "and STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s') >= STR_TO_DATE(:startdate,'%Y%m%d%H%i%s') "+
            "and STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s') <= STR_TO_DATE(:enddate,'%Y%m%d%H%i%s') "
            ,nativeQuery = true)


    List<TradeCardAccount> findByToCard_number (@Param("ids") List<String> inventoryIdList,@Param("startdate") String startdate,@Param("enddate") String enddate);
}
