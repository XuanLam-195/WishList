package com.example.wishlist.service;


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
        if (gift.getGiftId() == null){
            wishListRepository.addGift(gift);
        }else{
            wishListRepository.updateGift(gift);
        }

        return gift;
    }

    public List<Gift> getAllGift()  {
        return wishListRepository.findAllGift();
    }

    public List<GiftType> getAllGiftType()  {
        return wishListRepository.findAllGiftType();
    }
   public Gift findById(int id){
        return wishListRepository.getGiftById(id);
   }
   public void deleteGift(Integer id){
        wishListRepository.deleteGift(id);
   }



}
