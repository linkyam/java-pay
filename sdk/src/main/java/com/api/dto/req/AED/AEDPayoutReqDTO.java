package com.api.dto.req.AED;

import com.api.dto.common.req.PayoutReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AEDPayoutReqDTO extends PayoutReqDTO {
    /**
     * 支付类型; 主要WALLET/NET_BANKING
     */
    @NotEmpty
    private String paymentType;
    /**
     * 收款人账户类型：PHONE/MEMBER
     */
    @NotEmpty
    private String beneficiaryType;
}
