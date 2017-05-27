package com.criminalcase.service;

import com.criminalcase.domain.TradeRecordCardAmtFrq;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by apapan on 5/26/2017 AD.
 */
public class TradeRecordCardAmtFrqImpl implements TradeRecordCardAmtFrqService{
    private final TradeRecordCardAmtFrqRepository tradeRecordCardAmtFrqRepository;
    @PersistenceContext
    private EntityManager entityManager;
    public TradeRecordCardAmtFrqImpl(TradeRecordCardAmtFrqRepository tradeRecordCardAmtFrqRepository) {
        this.tradeRecordCardAmtFrqRepository = tradeRecordCardAmtFrqRepository;
    }

    @Override
    public List<TradeRecordCardAmtFrq> findByCard_numberAndFrequencyFrom(List<String> inventoryIdList, String startdate, String enddate) {
        return tradeRecordCardAmtFrqRepository.findByCard_numberAndFrequencyFrom(inventoryIdList,startdate,enddate);
    }

    @Override
    public List<TradeRecordCardAmtFrq> findByCard_numberAndFrequencyTo(List<String> inventoryIdList, String startdate, String enddate) {
        return tradeRecordCardAmtFrqRepository.findByCard_numberAndFrequencyTo(inventoryIdList,startdate,enddate);
    }

  /*  public List<TradeRecordCardAmtFrq> getFromFqyTo(List<String> inventoryIdList, String startdate, String enddate){
        String sql =
                "select count(a.money_amount) as frequency,a.money_amount,b.card_number,b.id from t_trade_record a \n" +
                 "join  t_card b\n" +
                "on  a.from_card_id = b.id\n" +
                "where b.card_number in (6228480320030751418) \n"+
                "group by b.card_number,a.money_amount,b.id ";
        Query query = entityManager.createQuery(sql,TradeRecordCardAmtFrq.class);


    }
*/
}
