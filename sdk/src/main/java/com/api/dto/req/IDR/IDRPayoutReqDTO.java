package com.api.dto.req.IDR;

import com.api.dto.common.req.PayoutReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class IDRPayoutReqDTO extends PayoutReqDTO {
    /**
     * 收款人银行编码
     */
    @NotEmpty
    private String beneficiaryBankCode;
    /**
     * 出款方式：
     * DISBURSEMENTS
     */
    @NotEmpty
    private String paymentType;

}
