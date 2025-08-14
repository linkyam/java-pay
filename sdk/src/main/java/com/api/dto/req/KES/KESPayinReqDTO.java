package com.api.dto.req.KES;

import com.api.dto.common.req.PayinReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class KESPayinReqDTO extends PayinReqDTO {
    /**
     * 手机号码运营商类型；
     * MPESA:mpesa 手机运营商;
     * AIRTEL:airtel 手机运营商;
     */
    @NotEmpty
    private String docType;
    /**
     * 如果是银行卡收 款则填银行卡账 号，如果钱包收款 则填写钱包账号
     */
    @NotEmpty
    private String cardNumber;
    /**
     * 支付方式；
     * MPESA(只支持mpesa钱包-直连mpesa)
     * CELLULANT（
     * 支持mpesa钱包和arrtel钱包和银行转账-收银台模式）
     */
    private String paymentType;
    /**
     * 支付类型
     */
    private String paymentMethod;
}
