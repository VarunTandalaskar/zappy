package com.corp.zappy.merchant.service;

import com.corp.zappy.merchant.dto.request.MerchantSignupRequest;
import com.corp.zappy.merchant.dto.response.MerchantResponse;

public interface AuthService {

    MerchantResponse signup(MerchantSignupRequest request);
}
