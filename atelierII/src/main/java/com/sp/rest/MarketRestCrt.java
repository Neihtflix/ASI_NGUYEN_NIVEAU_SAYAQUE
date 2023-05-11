  package com.sp.rest;

  import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  import org.springframework.web.bind.annotation.RestController;

import com.sp.model.User;
import com.sp.service.MarketService;
import com.sp.model.Card;


  @RestController
  public class MarketRestCrt {
      @Autowired
      MarketService mService;
      
      @RequestMapping(method=RequestMethod.POST,value="/store/sell")
      public void sellCard(@RequestBody int card_id, int user_id) {
          mService.sellCard(card_id,user_id);
      }
      
      @RequestMapping(method=RequestMethod.POST,value="/store/buy")
      public void buyCard(@RequestBody int card_id, int user_id) {
          mService.buyCard(card_id,user_id);
      }
      
      @RequestMapping(method=RequestMethod.GET,value="/cards")
      public List<Card> getCards() {
          return mService.getCards();
      }
      
      @RequestMapping(method=RequestMethod.GET,value="/cards_to_sell")
      public List<Card> getCardsToSell() {
          return mService.getCardsToSell();
      }
      
      /*@RequestMapping(method=RequestMethod.POST,value="/store/transaction")
      public transaction(@RequestBody int card_id, int user_id) {
          transaction t = mService.transaction()
          return t
      }*/

  }