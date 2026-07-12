package com.corp.zappy.payment.mapper;

import com.corp.zappy.payment.dto.response.OrderResponse;
import com.corp.zappy.payment.entity.OrderRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    OrderResponse toResponse(OrderRecord orderRecord);
}
