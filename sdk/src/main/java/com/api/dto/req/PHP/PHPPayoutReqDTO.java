package com.api.dto.req.PHP;

import com.api.dto.common.req.PayoutReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PHPPayoutReqDTO extends PayoutReqDTO {
    /**
     * 银行编码:BC90001
     */
    @NotEmpty
    private String beneficiaryBankCode;
    /**
     * 支付方式：
     * 1.WALLET_GCASH:代付；
     * 2.NET_BANKING 其他渠道代付
     */
    @NotEmpty
    private String paymentType;

    private String mockPaymentType;
}
