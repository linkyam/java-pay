package com.api.dto.req.BRL;

import com.api.dto.common.req.PayoutReqDTO;
import lombok.Data;

@Data
public class BRLPayoutReqDTO extends PayoutReqDTO {
    /**
     * 收款人银行类型
     * CHECKING:支票账户
     * SAVING:储蓄账户
     * docType 为 BRBAN时候必填
     */
    private String beneficiaryBankType;
    /**
     * 收款人银行编码
     * docType 为 BRBANK 时候必填
     */
    private String beneficiaryBankCode;
    /**
     * 收款人银行分行编码
     * docType 为 BRBANK 时候必填
     */
    private String beneficiaryBankBranch;
    /**
     * 扩展支付类型：
     * PIX 或 BRBANK
     */
    private String docType;
    /**
     * 扩展支付类型编号：
     * 税号:PIX 对应 CPF 、CNPJ
     */
    private String docNumber;
    /**
     * 校验 CPF（docNumber 参数）和 PIX（beneficiaryAccountNumber 参数）账户绑定的cpf 完全一致才允许出款(不传默认不验证)
     */
    private String pixCheck;
}
