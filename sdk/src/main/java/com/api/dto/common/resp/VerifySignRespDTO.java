package com.api.dto.common.resp;

import lombok.Data;

/**
 * @ClassName verifySignReqDTO
 * @Description verify sign
 * @Author Andy
 * @Date 2024/9/6 10:34
 */
@Data
public class VerifySignRespDTO {
    /**
     * 验签响应
     */
    private String code;
    /**
     * 验证结果
     */
    private String data;
    /**
     * 花费时间
     */
    private String costTime;
}
