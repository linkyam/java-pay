package com.api.dto.common.resp;

import lombok.Data;

@Data
public class PayoutRespDTO {
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 币种
     */
    private String currency;

}
