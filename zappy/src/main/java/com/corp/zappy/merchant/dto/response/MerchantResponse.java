package com.corp.zappy.merchant.dto.response;

import com.corp.zappy.common.enums.BusinessType;
import com.corp.zappy.common.enums.MerchantStatus;

import java.util.UUID;

public record MerchantResponse(
        UUID id,
        String name,
        String email,
        String businessName,
        BusinessType businessType,
        MerchantStatus merchantStatus
) {
}
