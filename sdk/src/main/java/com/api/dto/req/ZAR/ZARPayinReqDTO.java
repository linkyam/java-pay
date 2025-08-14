package com.api.dto.req.ZAR;

import com.api.dto.common.req.PayinReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ZARPayinReqDTO extends PayinReqDTO {
    /**
     * 如果是银行卡收 款则填银行卡账 号，如果钱包收款 则填写钱包账号
     */
    @NotEmpty
    private String cardNumber;
    /**
     * 支付方式；
     * TCTD
     * NET_BANKING
     */
    @NotEmpty
    private String paymentType;
    /**
     * 支付类型
     */
    private String paymentMethod;
}
