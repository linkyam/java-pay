package com.api.dto.req.CLP;

import com.api.dto.common.req.PayinReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CLPPayinReqDTO extends PayinReqDTO {
    /**
     * 用户身份类型
     */
    @NotEmpty
    private String beneficiaryType;
    /**
     * 对应身份类型号码
     * （可以不用真实按规则传随机数）
     */
    @NotEmpty
    private String beneficiaryId;
    /**
     * 支付方式；
     * CASH(现金)
     * TC(卡支付)
     * NET_BANKING（银行转账）
     */
    @NotEmpty
    private String paymentType;
    /**
     * 支付类型
     */
    private String paymentMethod;
}
