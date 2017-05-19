package com.criminalcase.service;


import com.criminalcase.domain.TradeRecord;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by apapan on 5/19/2017 AD.
 */
@Transactional
public interface TradeRecordRepository extends CrudRepository<TradeRecord,Long>{
    @Query("select t from TradeRecord t")
    List<TradeRecord> getAll();

    @Modifying
    @Query("select t from TradeRecord t " +
            "where t.from_card_id = ?1 " +
            "and STR_TO_DATE(t.date_time,'%Y%m%d%H%i%s') >= STR_TO_DATE(?2,'%Y%m%d%H%i%s') " +
            "and STR_TO_DATE(t.date_time,'%Y%m%d%H%i%s') <= STR_TO_DATE(?3,'%Y%m%d%H%i%s')")
    List<TradeRecord>  findTradeRecordByFrom_card_idIs(int from_card_id,String startdate,String enddate);
    @Modifying
    @Query("select t from TradeRecord t " +
            "where t.to_card_id  = ?1 "+
            "and STR_TO_DATE(t.date_time,'%Y%m%d%H%i%s') >= STR_TO_DATE(?2,'%Y%m%d%H%i%s') " +
            "and STR_TO_DATE(t.date_time,'%Y%m%d%H%i%s') <= STR_TO_DATE(?3,'%Y%m%d%H%i%s')")
    List<TradeRecord>  findTradeRecordByTo_card_idIs(int to_card_id,String startdate,String enddate);
    @Modifying
    @Query( "select o from TradeRecord o where o.to_card_id in :ids" )
    List<TradeRecord> findTradeRecordByTo_card_idContains(@Param("ids") List<Integer> inventoryIdList);
}
