package com.api.dto.req.KES;

import com.api.dto.common.req.PayoutReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class KESPayoutReqDTO extends PayoutReqDTO {
    /**
     * 收款人银行编码, required（paymentType为NET_BANKING必填）
     */
    private String beneficiaryBankCode;
    /**
     * 手机号码运营商类型；
     * MPESA:mpesa 手机运营商;
     * AIRTEL:airtel 手机运营商;
     */
    @NotEmpty
    private String docType;
    /**
     * 支付类型;
     * MPESA:mpesa钱包
     * AIRTEL:airtel 钱包
     * NET_BANKING：银行转账
     */
    @NotEmpty
    private String paymentType;
}
