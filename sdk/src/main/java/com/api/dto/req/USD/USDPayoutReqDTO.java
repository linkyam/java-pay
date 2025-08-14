package com.api.dto.req.USD;

import com.api.dto.common.req.PayoutReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class USDPayoutReqDTO extends PayoutReqDTO {

    /**
     * 支付方式：CASHAPPOUT
     */
    @NotEmpty
    private String paymentType;
    /**
     * 持卡人锁在的真实IP地址：24.23.42.24
     */
    @NotEmpty
    private String ipAddress;
}
