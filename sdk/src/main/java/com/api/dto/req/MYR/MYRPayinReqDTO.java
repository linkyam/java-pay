package com.api.dto.req.MYR;

import com.api.dto.common.req.PayinReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MYRPayinReqDTO extends PayinReqDTO {
    /**
     * 支付方式:
     * NET_BANKING(银行转账)
     * QRIS（扫码支付）
     */
    @NotEmpty
    private String paymentType;
}
