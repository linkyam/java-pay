package com.api.dto.common.req;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class BalanceReqDTO {

    /**
     * 订单号
     */
    @NotEmpty
    private String currency;

    /**
     * 商户id
     */
    @NotEmpty
    private String mchId;

    /**
     * 商户key
     */
    private String mchKey;

}
