package com.api.dto.req.MXN;

import com.api.dto.common.req.PayoutReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MXNPayoutReqDTO extends PayoutReqDTO {
    /**
     * 收款人银行编码
     */
    private String beneficiaryBankCode;
    /**
     * 出款类型:
     * SPEI: CLABEL number（默认）
     * NET_BANKING: bank card
     */
    @NotEmpty
    private String paymentType;
}
