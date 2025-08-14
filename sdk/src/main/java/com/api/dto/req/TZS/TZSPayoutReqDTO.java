package com.api.dto.req.TZS;

import com.api.dto.common.req.PayoutReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TZSPayoutReqDTO extends PayoutReqDTO {
    /**
     * 支付类型;
     * VODACOM
     * TIGO
     * AIRTEL
     */
    @NotEmpty
    private String paymentType;
    /**
     * 收款人第一个名字
     */
    @NotEmpty
    private String firstName;
    /**
     * 收款人最后一个名字
     */
    @NotEmpty
    private String lastName;
}
