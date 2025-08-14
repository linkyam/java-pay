package com.api.dto.req.IDR;

import com.api.dto.common.req.PayinReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class IDRPayinReqDTO extends PayinReqDTO {
    /**
     * 订单标题
     */
    @NotEmpty
    private String productTitle;
    /**
     * 支付方式：
     * VIRTUAL_ACCOUNT:银行支付;
     * WALLET:钱包;
     * QRIS:QRIS 二维码;
     * 如果填值,paymentChannel也必填;
     */
    private String paymentType;
    /**
     * 支付类型 （默认收银台）;
     * CHECKOUT_URL:收银台下单;
     * API:接口下单;
     */
    @NotEmpty
    private String paymentMethod;
    /**
     * 支付机构
     */
    private String paymentChannel;
}
