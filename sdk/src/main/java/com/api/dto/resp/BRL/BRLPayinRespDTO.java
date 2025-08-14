package com.api.dto.resp.BRL;

import com.api.dto.common.resp.PayinRespDTO;
import lombok.Data;

@Data
public class BRLPayinRespDTO extends PayinRespDTO {
    /**
     * 二维码地址
     */
    private String qrCodeString;
}
