package dev.tbvrln.ecommerce.mapper;

import dev.tbvrln.ecommerce.dto.BuyerDTO;
import dev.tbvrln.ecommerce.model.Buyer;
import org.mapstruct.Mapper;

@Mapper
public class BuyerMapper {

    public static BuyerDTO toDTO(Buyer buyer) {
        return new BuyerDTO(buyer.getId(), buyer.getName());
    }

    public static Buyer toEntity(BuyerDTO dto) {
        return new Buyer(dto.getId(), dto.getName());
    }
}
