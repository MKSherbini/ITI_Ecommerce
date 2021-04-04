package utilities.adapters;

import models.dtos.CartDto;
import models.dtos.CartItemDto;
import models.dtos.CreditCardDto;
import models.orm.CartItem;
import models.orm.CreditCard;
import models.orm.ShoppingCart;

import java.util.LinkedList;
import java.util.List;

public class CreditCardAdapter {
    public static CreditCardDto copyOrmToDto(CreditCard orm) {
        var dto = new CreditCardDto();
        dto.setId(orm.getCardId());
        dto.setBalance(orm.getFakeCreditCard().getBalance());
        dto.setCardNumberEnds(orm.getFakeCreditCard().getCardNumber().substring(orm.getFakeCreditCard().getCardNumber().length() - 4));
        dto.setDefaultCard(orm.isDefault());
        dto.setExpireDate(orm.getFakeCreditCard().getExpireDate());
        return dto;
    }

    public static List<CreditCardDto> copyOrmToDto(List<CreditCard> orms) {
        var dtos = new LinkedList<CreditCardDto>();
        if (orms != null)
            orms.forEach(orm -> dtos.add(copyOrmToDto(orm)));
        return dtos;
    }
}
