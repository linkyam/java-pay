package com.api.dto.resp.IDR;

import com.api.dto.common.resp.PayinRespDTO;
import lombok.Data;

@Data
public class IDRPayinRespDTO extends PayinRespDTO {
    /**
     * QRIS 二维码;
     * paymentMethod=API;paymentType=QRIS 返回;
     */
    private String qrCodeString;
    /**
     * deeplink链接;
     * paymentMethod=API;paymentType=WALLET 返回;OVO 订单不存在，OVO是手机推送支付订单
     */
    private String links;
    /**
     * 账号:
     * paymentMethod=API;paymentType=VIRTUAL_ACCOUNT 返回;
     */
    private String accountNumber;
    /**
     * 账号类型；
     * paymentMethod=API;paymentType=VIRTUAL_ACCOUNT 返回;
     */
    private String accountType;
}
