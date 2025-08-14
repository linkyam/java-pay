package com.api.dto.req.COP;

import com.api.dto.common.req.PayinReqDTO;
import lombok.Data;

@Data
public class COPPayinReqDTO extends PayinReqDTO {
    /**
     * 支付方式
     * NET_BANKING 默认银行转账和钱包付款
     */
    private String paymentType;
}
