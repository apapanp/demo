package com.criminalcase.service;

import com.criminalcase.domain.TradeCard;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by apapan on 5/24/2017 AD.
 */
@Transactional
public interface TradeCardRepository extends Repository<TradeCard, Long> {
    @Query("select t from TradeCard t")
    List<TradeCard> getAll();

    @Modifying
    @Query("select t from TradeCard t where t.id = ?1")
    List<TradeCard> findById (String id);

    @Modifying
    @Query("select t from TradeCard t where t.card_number in :ids")
    List<TradeCard> findByCard_number (@Param("ids") List<String> inventoryIdList);

}

