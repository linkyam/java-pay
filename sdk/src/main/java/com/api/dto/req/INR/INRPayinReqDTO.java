package com.api.dto.req.INR;

import com.api.dto.common.req.PayinReqDTO;
import lombok.Data;

@Data
public class INRPayinReqDTO extends PayinReqDTO {
    /**
     * 虚拟账号；填写UPI_ID；dedee@gmail.com
     */
    private String vpa;
}
