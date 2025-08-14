package com.api.dto.req.MXN;

import com.api.dto.common.req.PayinReqDTO;
import lombok.Data;

@Data
public class MXNPayinReqDTO extends PayinReqDTO {
    /**
     * 动态码标志,默认静态码,动态码传:1,可能产生附加费
     * Dynamic code flag, default static code, dynamic code transmission: 1, may incur surcharges
     */
    private String dynamic;
    /**
     * 支付方式 SPEI
     */
    private String paymentType;
}
