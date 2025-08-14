package com.api.dto.req.COP;

import com.api.dto.common.req.PayoutReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class COPPayoutReqDTO extends PayoutReqDTO {
    /**
     * 收款人银行名称
     */
    @NotEmpty
    private String beneficiaryBankName;
    /**
     * 用户姓（不用真实）
     */
    @NotEmpty
    private String firstname;
    /**
     * 用户名（不用真实）
     */
    @NotEmpty
    private String lastname;
    /**
     * 收款人账号类型;
     * CHECKING;
     * SAVINGS;
     */
    @NotEmpty
    private String beneficiaryAccountType;
    /**
     * 扩展编码;身份 ID
     */
    @NotEmpty
    private String docNumber;
    /**
     * 扩展类型;
     * CC:Adult Colombia Citizen ID;
     * CE:Colombia Foreigner ID;
     * TI:Child Colombia Citizen ID;
     * COLOMBIA_PASSPORT_ID:Passport;
     * NIT
     */
    @NotEmpty
    private String docType;
}
