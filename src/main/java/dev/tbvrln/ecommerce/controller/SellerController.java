package dev.tbvrln.ecommerce.controller;

import dev.tbvrln.ecommerce.dto.SellerDTO;
import dev.tbvrln.ecommerce.model.Seller;
import dev.tbvrln.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/seller")
public class SellerController {

    private final SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping
    public List<Seller> getSellers() {
        return sellerService.getSeller();
    }


    @PutMapping(path = "{sellerId}")
    public void updateSeller(@PathVariable("sellerId") Long sellerId,
                            @RequestBody SellerDTO dto) {
        sellerService.updateSeller(sellerId, dto);
    }


    @PostMapping
    public void registerNewSeller(@RequestBody SellerDTO sellerDTO) {
        sellerService.createSeller(sellerDTO);
    }

    @DeleteMapping(path = "{sellerId}")
    public void deleteSeller(@PathVariable("sellerId") Long id) {
        sellerService.deleteSeller((id));
    }


}
