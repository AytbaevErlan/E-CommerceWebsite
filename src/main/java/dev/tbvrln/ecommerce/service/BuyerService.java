package dev.tbvrln.ecommerce.service;

import dev.tbvrln.ecommerce.dto.BuyerDTO;
import dev.tbvrln.ecommerce.mapper.BuyerMapper;
import dev.tbvrln.ecommerce.model.Buyer;
import dev.tbvrln.ecommerce.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {

    private final BuyerRepository buyerRepository;


    @Autowired
    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }


    public List<Buyer> getBuyer() {
        return buyerRepository.findAll();
    }


    public BuyerDTO createBuyer(BuyerDTO dto) {
        Buyer saved = buyerRepository.save(BuyerMapper.toEntity(dto));
        return BuyerMapper.toDTO(saved);
    }

    public BuyerDTO updateBuyer(Long id, BuyerDTO dto) {
        Buyer existing = buyerRepository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setName(dto.getName());
        return BuyerMapper.toDTO(buyerRepository.save(existing));

    }

    public void deleteBuyer(Long id) {
        buyerRepository.deleteById(id);
    }


}
