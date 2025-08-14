package com.api.dto.common.resp;

import lombok.Data;

@Data
public class BalanceRespDTO {
    /**
     * 币种
     */
    private String currency;

    /**
     * 余额
     */
    private Double balance;

    /**
     * 未结算余额
     */
    private Double unsettleBalance;

}
