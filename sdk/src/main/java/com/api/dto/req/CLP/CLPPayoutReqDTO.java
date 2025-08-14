package com.api.dto.req.CLP;

import com.api.dto.common.req.PayoutReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CLPPayoutReqDTO extends PayoutReqDTO {
    /**
     * 收款人身份类型
     */
    @NotEmpty
    private String beneficiaryType;
    /**
     * 收款人身份类型号码
     */
    @NotEmpty
    private String beneficiaryId;
    /**
     * 收款人账号类型
     */
    @NotEmpty
    private String beneficiaryBankType;
    /**
     * 收款账号对应的银行名称或者机构名称
     */
    @NotEmpty
    private String beneficiaryBankCode;
    /**
     * 支付类型;
     * NET_BANKING：银行转账
     */
    @NotEmpty
    private String paymentType;
}
