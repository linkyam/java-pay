package com.api.dto.common.resp;

import lombok.Data;

@Data
public class PayinRespDTO {
    /**
     * 平台订单号
     */
    private String orderId;
    /**
     * 订单币种
     */
    private String currency;
    /**
     * 1:checkoutUrl 字段展示订单状态，支付链接通过手机短信发送;
     * 2:checkoutUrl 字段展示支付链接;
     */
    private String type;
    /**
     * 收银台地址
     */
    private String checkoutUrl;
}
