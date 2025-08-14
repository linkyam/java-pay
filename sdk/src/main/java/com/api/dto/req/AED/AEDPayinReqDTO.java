package com.api.dto.req.AED;

import com.api.dto.common.req.PayinReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AEDPayinReqDTO extends PayinReqDTO {
    /**
     * 支付方式；
     * WALLET
     */
    @NotEmpty
    private String paymentType;
    /**
     * 设备：IOS/Android/Paid/PC
     */
    @NotEmpty
    private String deviceId;
}
