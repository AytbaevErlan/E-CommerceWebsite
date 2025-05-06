package dev.tbvrln.ecommerce.mapper;

import dev.tbvrln.ecommerce.dto.SellerDTO;
import dev.tbvrln.ecommerce.model.Seller;
import org.mapstruct.Mapper;
@Mapper
public class SellerMapper {
    public static SellerDTO toDTO(Seller seller) {
        return new SellerDTO(seller.getId(), seller.getName());
    }

    public static Seller toEntity(SellerDTO dto) {
        return new Seller(dto.getId(), dto.getName());
    }

}
