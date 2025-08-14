package com.api.dto.req.PHP;

import com.api.dto.common.req.PayinReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PHPPayinReqDTO extends PayinReqDTO {
    /**
     * 订单标题:shopping
     */
    @NotEmpty
    private String productTitle;
    /**
     * 支付方式：
     * 1.WALLET_GCASH:gcash钱包直连
     * 2.QRIS: gcash扫码
     */
    @NotEmpty
    private String paymentType;
    /**
     * 支付机构；
     */
    private String paymentChannel;
}
