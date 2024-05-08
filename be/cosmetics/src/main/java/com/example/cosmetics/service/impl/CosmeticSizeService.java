package com.example.cosmetics.service.impl;

import com.example.cosmetics.model.Bill;
import com.example.cosmetics.model.CosmeticsSize;
import com.example.cosmetics.model.OrderCosmetics;
import com.example.cosmetics.repository.IBillRepository;
import com.example.cosmetics.repository.ICartRepository;
import com.example.cosmetics.repository.ICosmeticSizeRepository;
import com.example.cosmetics.service.ICosmeticSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CosmeticSizeService implements ICosmeticSizeService {
    @Autowired
    private IBillRepository billRepository;
    @Autowired
    private ICosmeticSizeRepository cosmeticSizeRepository;
    @Autowired
    private ICartRepository cartRepository;
    @Override
    public Bill addNewBill(String username) {
        List<OrderCosmetics> orderCosmeticsList = this.cosmeticSizeRepository.getAllProductOrderOfUser(username);

        Bill bill = new Bill();
        bill.setOrderDay(LocalDate.now());

        bill.setStatus("Đã thanh toán");

        Long totalPrice = 0L;
        for (OrderCosmetics cosmetics : orderCosmeticsList) {
            totalPrice += cosmetics.getQuantity() * cosmetics.getCosmeticsSize().getQuantity();
        }

        bill.setTotalPay(totalPrice);

        Bill bill1 = billRepository.save(bill);

        for (OrderCosmetics cosmetics : orderCosmeticsList) {
            cosmetics.setBill(bill1);
            CosmeticsSize cosmeticsSize = cosmetics.getCosmeticsSize();
            cosmeticsSize.setQuantity(cosmeticsSize.getQuantity() - cosmetics.getQuantity());
            this.cosmeticSizeRepository.save(cosmeticsSize);
            this.cartRepository.save(cosmetics);
        }
        return null;
    }
}
