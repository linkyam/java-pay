
package com.api.dto.common.resp;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VerifyStatusRespDTO {
    /**
     * 平台订单号
     */
    private String orderId;
    /**
     * 商户订单号
     */
    private String mchOrderId;
    /**
     * 订单状态: SUCCESS; FAILED; REVERSED; PAYING
     */
    private String orderStatus;
    /**
     * 订单类型: PAYMENT; PAYOUT;
     */
    private String orderType;
    /**
     * 创建时间（零时区）;格式:yyyyMMddHHmmss;
     */
    private String createTime;
    /**
     * 通知时间（零时区）;格式:yyyyMMddHHmmss;
     */
    private String notifyTime;
    /**
     * 失败原因
     */
    private String failMessage;
    /**
     * 银行编码: 银行返回支付id，如果订单成功必然返回，如果订单支持重复支付或多次支付，同一个单被支付多次时候，每次支付回调商户的值不一样
     */
    private String bankId;
    /**
     * 订单金额
     */
    private String amount;
    /**
     * 实际金额
     */
    private String realAmount;
    /**
     * 商户出款手续费率
     */
    private String payeeFee;
    /**
     * 商户收款手续费率
     */
    private String payerFee;
    /**
     * 支付方式
     */
    private String payMethod;
}