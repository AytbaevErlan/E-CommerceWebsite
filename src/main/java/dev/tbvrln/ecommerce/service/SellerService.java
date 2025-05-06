package dev.tbvrln.ecommerce.service;


import dev.tbvrln.ecommerce.dto.SellerDTO;

import dev.tbvrln.ecommerce.mapper.SellerMapper;
import dev.tbvrln.ecommerce.model.Seller;
import dev.tbvrln.ecommerce.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;


    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }


    public List<Seller> getSeller() {
        return sellerRepository.findAll();
    }


    public SellerDTO createSeller(SellerDTO dto) {
        Seller saved = sellerRepository.save(SellerMapper.toEntity(dto));
        return SellerMapper.toDTO(saved);
    }

    public SellerDTO updateSeller(Long id, SellerDTO dto) {
        Seller existing = sellerRepository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setName(dto.getName());
        return SellerMapper.toDTO(sellerRepository.save(existing));

    }

    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }

}
