package com.api.dto.req.ZAR;

import com.api.dto.common.req.PayoutReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ZARPayoutReqDTO extends PayoutReqDTO {
    /**
     * 收款人银行编码
     */
    @NotEmpty
    private String beneficiaryBankCode;
    /**
     * 支付类型;
     * NET_BANKING：银行转账
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
