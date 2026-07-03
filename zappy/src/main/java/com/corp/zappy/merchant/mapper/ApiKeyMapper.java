package com.corp.zappy.merchant.mapper;

import com.corp.zappy.merchant.dto.response.ApiKeyCreateResponse;
import com.corp.zappy.merchant.dto.response.ApiKeyResponse;
import com.corp.zappy.merchant.entity.ApiKey;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApiKeyMapper {

    ApiKeyCreateResponse toCreateResponse(ApiKey apiKey);

    List<ApiKeyResponse> toResponseList(List<ApiKey> apiKeyList);
}
