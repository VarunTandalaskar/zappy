package com.corp.zappy.merchant.mapper;

import com.corp.zappy.merchant.dto.request.MerchantSignupRequest;
import com.corp.zappy.merchant.dto.response.MerchantResponse;
import com.corp.zappy.merchant.entity.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MerchantMapper {
    Merchant toEntityFromSignUpRequest(MerchantSignupRequest request);

    MerchantResponse toResponse(Merchant merchant);
}
