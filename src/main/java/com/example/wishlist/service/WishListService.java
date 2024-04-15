package com.example.wishlist.service;


import com.example.wishlist.model.Account;
import com.example.wishlist.model.Gift;
import com.example.wishlist.model.GiftType;
import com.example.wishlist.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class WishListService {

    @Autowired
    WishListRepository wishListRepository;

    public Gift addGift(Gift gift) {
        wishListRepository.addGift(gift);
        return gift;
    }

    public List<Gift> getAllGift()  {
        return wishListRepository.findAllGift();
    }

    public List<GiftType> getAllGiftType()  {
        return wishListRepository.findAllGiftType();
    }

   public List<Account> getAllAccount(){
        return wishListRepository.findAllAccount();
    }


}
