package com.example.cosmetics.service.impl;

import com.example.cosmetics.dto.BillDto;
import com.example.cosmetics.model.Account;
import com.example.cosmetics.model.Bill;
import com.example.cosmetics.model.CosmeticsSize;
import com.example.cosmetics.model.OrderCosmetics;
import com.example.cosmetics.repository.IAccountRepository;
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
    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public Bill addNewBill(BillDto billDto,String username) {
        List<OrderCosmetics> orderCosmeticsList = this.cosmeticSizeRepository.getAllProductOrderOfUser(username);
        Account account = accountRepository.findAccountByUsername(username);
        Bill bill = new Bill();
        bill.setOrderDay(LocalDate.now());
        bill.setAddress(account.getAddress());
        bill.setFullname(account.getFullname());
        bill.setPhoneNumber(account.getPhoneNumber());
        bill.setEmail(account.getEmail());
        bill.setNote(billDto.getNote());


        bill.setStatus("Đã thanh toán");

        Long totalPrice = 0L;
        for (OrderCosmetics cosmetics : orderCosmeticsList) {
            totalPrice += cosmetics.getCosmeticsSize().getPrice() * cosmetics.getQuantity();
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

    @Override
    public List<OrderCosmetics> detailBill(Integer idAccount, Integer idBill) {
       return cosmeticSizeRepository.detailBill(idAccount,idBill);

    }

    @Override
    public CosmeticsSize findById(int idCosmeticsSize) {
        return cosmeticSizeRepository.findById(idCosmeticsSize).orElse(null);
    }

    @Override
    public void saveQuantity(CosmeticsSize cosmeticsSize) {
        cosmeticSizeRepository.saveQuantity(cosmeticsSize);
    }
}
