package com.api.dto.resp.INR;

import com.api.dto.common.resp.PayinRespDTO;
import lombok.Data;

@Data
public class INRPayinRespDTO extends PayinRespDTO {
    /**
     * deeplink链接;
     * paymentMethod=API;paymentType=WALLET 返回;OVO 订单不存在，OVO是手机推送支付订单
     */
    private String links;
}
