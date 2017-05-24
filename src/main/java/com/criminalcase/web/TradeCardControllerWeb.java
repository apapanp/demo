package com.criminalcase.web;

import com.criminalcase.domain.TradeCard;
import com.criminalcase.domain.TradeRecord;
import com.criminalcase.service.TradeCardRepository;
import com.criminalcase.service.TradeCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by apapan on 5/24/2017 AD.
 */
@RestController
@RequestMapping("/tradecard/")
public class TradeCardControllerWeb {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TradeCardRepository tradeCardRepository;
    @Autowired
    private TradeCardService tradeCardService;

    @RequestMapping("/")
    public String index() {
        logger.debug("This is a debug message");
        logger.info("This is a info message");
        logger.warn("This is a warn message");
        logger.error("This is a error message");
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/parameters", method = RequestMethod.GET)
    public Map<String, String> test2(@RequestParam Map<String, String> params) {
        Map<String, String> resultmap = new HashMap<>();
        resultmap = params;
        List<Integer> cardidList = Arrays.asList(resultmap.get("cardid").split(",")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        for (int i = 0; i < cardidList.size(); i++) {
            System.out.println(cardidList.get(i));
        }
        return resultmap;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseEntity<Collection<TradeCard>> findByCardID(@RequestParam Map<String, String> params, HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        Map<String, String> resultmap = new HashMap<>();
        resultmap = params;
        List<String> cardidList = Arrays.asList(resultmap.get("cardNo").split(","));
        String json = "jsonResponse";
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(tradeCardRepository.findByCard_number(cardidList),HttpStatus.OK);
    }







}
