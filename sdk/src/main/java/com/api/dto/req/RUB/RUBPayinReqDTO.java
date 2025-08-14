package com.api.dto.req.RUB;

import com.api.dto.common.req.PayinReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RUBPayinReqDTO extends PayinReqDTO {
    /**
     * 支付方式；
     * NET_BANKING
     */
    @NotEmpty
    private String paymentType;
    /**
     * 支付编码：RUB0003
     */
    @NotEmpty
    private String paymentMethod;
}
