package com.api.dto.resp.MXN;

import com.api.dto.common.resp.PayinRespDTO;
import lombok.Data;

@Data
public class MXNPayinRespDTO extends PayinRespDTO {
    /**
     * 收款人账号
     */
    private String beneficiaryAccountNumber;
    /**
     * 收款人名称
     */
    private String beneficiaryName;
    /**
     * 收款类型
     */
    private String beneficiaryAccountType;
    /**
     * 收款人银行名称
     */
    private String beneficiaryBankName;
    /**
     * 收款人银行 ID
     */
    private String beneficiaryBankBranchId;
    /**
     * 收款人银行编码
     */
    private String beneficiaryBankCode;
    /**
     * 流水号
     */
    private String refNumber;
    /**
     * 过期时间:2023-03-10 08:01:43 UTC
     */
    private String expirationTime;
    /**
     * 支付类型 不传默认线上收款
     */
    private String paymentType;
}
