package com.api.dto.req.THB;

import com.api.dto.common.req.PayoutReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class THBPayoutReqDTO extends PayoutReqDTO {
    /**
     * 银行编码：输入下面银行列表的银行编号
     */
    @NotEmpty
    private String beneficiaryBankCode;
    /**
     * 支付方式 ：NET_BANKING
     */
    @NotEmpty
    private String paymentType;
}
