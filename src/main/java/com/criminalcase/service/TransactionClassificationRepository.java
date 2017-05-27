package com.criminalcase.service;

import com.criminalcase.domain.TradeCardAccount;
import com.criminalcase.domain.TransactionClassification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Created by apapan on 5/27/2017 AD.
 */
public interface TransactionClassificationRepository  extends Repository<TransactionClassification,Long> {

    @Modifying
    @Query(value = "select c.card_number,a.money_amount,b.role_id, \n"+
            "case when b.role_id  is not null then '1' else '0' end as classification,a.date_time,(@cnt\\:=@cnt+1) as id  from t_trade_record a \n"+
            "left join t_role_of_card_in_graph b \n"+
            "on (a.from_card_id=b.card_id) \n"+
            "inner join t_card c \n"+
            "on a.from_card_id = c.id \n"+
            "CROSS JOIN (SELECT @cnt\\:=0) AS dummy \n"+
            "where c.card_number in :ids " +
            "and STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s') >= STR_TO_DATE(:startdate,'%Y%m%d%H%i%s') "+
            "and STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s') <= STR_TO_DATE(:enddate,'%Y%m%d%H%i%s') "
            , nativeQuery = true)
    List<TransactionClassification> findByClassificationFromCard_number (@Param("ids") List<String> inventoryIdList, @Param("startdate") String startdate, @Param("enddate") String enddate);


    @Modifying
    @Query(value = "select c.card_number,a.money_amount,b.role_id, \n"+
            "case when b.role_id  is not null then '1' else '0' end as classification,a.date_time,(@cnt\\:=@cnt+1) as id  from t_trade_record a \n"+
            "left join t_role_of_card_in_graph b \n"+
            "on (a.to_card_id=b.card_id) \n"+
            "inner join t_card c \n"+
            "on a.to_card_id = c.id \n"+
            "CROSS JOIN (SELECT @cnt\\:=0) AS dummy \n"+
            "where c.card_number in :ids " +
            "and STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s') >= STR_TO_DATE(:startdate,'%Y%m%d%H%i%s') "+
            "and STR_TO_DATE(a.date_time,'%Y%m%d%H%i%s') <= STR_TO_DATE(:enddate,'%Y%m%d%H%i%s') "
            , nativeQuery = true)
    List<TransactionClassification> findByClassificationToCard_number (@Param("ids") List<String> inventoryIdList, @Param("startdate") String startdate, @Param("enddate") String enddate);
}
