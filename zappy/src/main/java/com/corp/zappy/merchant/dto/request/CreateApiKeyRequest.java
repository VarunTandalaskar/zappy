package com.corp.zappy.merchant.dto.request;

import com.corp.zappy.common.enums.Environment;

public record CreateApiKeyRequest(
        Environment environment
) {
}
