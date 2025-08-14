package com.api.dto.req.VISA;

import com.api.dto.common.req.PayinReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class VISAPayinReqDTO extends PayinReqDTO {
    /**
     * 支付方式:CARD
     */
    @NotEmpty
    private String paymentType;
}
