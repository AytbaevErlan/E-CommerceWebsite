package dev.tbvrln.ecommerce.controller;

import dev.tbvrln.ecommerce.dto.BuyerDTO;
import dev.tbvrln.ecommerce.model.Buyer;
import dev.tbvrln.ecommerce.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/buyer")
public class BuyerController {

    private final BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @GetMapping
    public List<Buyer> getBuyers() {
        return buyerService.getBuyer();
    }


    @PutMapping(path = "{buyerId}")
    public void updateBuyer(@PathVariable("buyerId") Long buyerId,
                               @RequestBody BuyerDTO dto) {
        buyerService.updateBuyer(buyerId, dto);
    }


    @PostMapping
    public void registerNewBuyer(@RequestBody BuyerDTO buyerDTO) {
        buyerService.createBuyer(buyerDTO);
    }

    @DeleteMapping(path = "{buyerId}")
    public void deleteBuyer(@PathVariable("buyerId") Long id) {
        buyerService.deleteBuyer((id));
    }


}