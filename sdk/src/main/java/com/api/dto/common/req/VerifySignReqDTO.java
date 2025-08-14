package com.api.dto.common.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @ClassName verifySignReqDTO
 * @Description verify sign
 * @Author Andy
 * @Date 2024/9/6 10:34
 */
@Data
public class VerifySignReqDTO {
    /**
     * 订单金额
     */
    @NotEmpty
    private String amount;
    /**
     * 银行订单号
     */
    private String bankId;
    /**
     * 创建时间(零时区);
     * 格式:yyyyMMddHHmmss;
     */
    @NotEmpty
    private String createTime;
    /**
     * 失败原因
     */
    private String failMessage;
    /**
     * 商户订单号
     */
    @NotEmpty
    private String mchOrderId;
    /**
     * 平台订单号
     */
    @NotEmpty
    private String orderId;
    /**
     * 订单状态;
     * 成功:SUCCESS;
     * 失败:FAILED;
     * 撤销:REVERSED;
     * 处理中:PAYING;
     * 订单关闭:CLOSED;
     */
    @NotEmpty
    private String orderStatus;
    /**
     * 订单类型;
     * PAYMENT:收款;
     * PAYOUT:出款;
     */
    @NotEmpty
    private String orderType;
    /**
     * 实际金额（元）;保留 2 位小数
     */
    private String realAmount;
    /**
     * 扩展订单号
     */
    private String transIds;
}
