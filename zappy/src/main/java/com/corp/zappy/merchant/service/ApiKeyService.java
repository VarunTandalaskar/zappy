package com.corp.zappy.merchant.service;

import com.corp.zappy.merchant.dto.request.CreateApiKeyRequest;
import com.corp.zappy.merchant.dto.response.ApiKeyCreateResponse;
import com.corp.zappy.merchant.dto.response.ApiKeyResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public interface ApiKeyService {

    ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request);

    List<ApiKeyResponse> listByMerchant(UUID merchantId);

    void revoke(UUID merchantId, UUID keyId);

    @Nullable ApiKeyCreateResponse rotate(UUID merchantId, UUID keyId);
}
