package com.api.dto.common.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class VerifyStatusReqDTO {
    /**
     * 订单号
     */
    @NotEmpty
    private String orderId;
    /**
     * 商户id
     */
    @NotEmpty
    private String mchId;
    /**
     * 商户key
     */
    private String mchKey;

}
