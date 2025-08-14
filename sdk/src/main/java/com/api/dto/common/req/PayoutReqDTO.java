package com.api.dto.common.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PayoutReqDTO {
    /**
     * 商户订单号
     */
    @NotEmpty
    private String mchOrderId;
    /**
     * 订单金额: 10.00
     */
    @NotEmpty
    private String amount;
    /**
     * 订单币种: BRL
     */
    @NotEmpty
    private String currency;
    /**
     * 商品说明
     */
    @NotEmpty
    private String purpose;
    /**
     * 支付方式
     */
    private String paymentType;
    /**
     * 收款人姓名
     */
    @NotEmpty
    private String beneficiaryName;
    /**
     * 收款人邮箱
     */
    @NotEmpty
    private String beneficiaryEmail;
    /**
     * 收款人手机号
     */
    @NotEmpty
    private String beneficiaryMobile;
    /**
     * 收款人账号
     */
    @NotEmpty
    private String beneficiaryAccountNumber;
    /**
     * webhook 回调地址
     */
    private String callbackUrl;
    /**
     * 商户id,后管平台配置生成
     */
    @NotEmpty
    private String mchId;
    /**
     * 商户key, 后管平台配置生成
     */
    private String mchKey;
}
