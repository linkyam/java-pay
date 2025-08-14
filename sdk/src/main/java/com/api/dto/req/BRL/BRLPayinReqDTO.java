package com.api.dto.req.BRL;

import com.api.dto.common.req.PayinReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BRLPayinReqDTO extends PayinReqDTO {
    /**
     * 动态码标志,默认静态码,动态码传:1,可能产生附加费
     * Dynamic code flag, default static code, dynamic code transmission: 1, may incur surcharges
     */
    private String dynamic;
    /**
     * 税号:PIX对应CPF号，PIXN对应CNPJ号
     * Tax ID: PIX corresponds to CPF number, PIXN corresponds to CNPJ number
     */
    @NotEmpty
    private String docNumber;
    /**
     * 扩展类型;暂只支持PIX; PIX:银行转账; PIXN:银行转账;
     * type of extension; For the time being, only PIX is supported; PIX: Bank Transfer; PIXN: Bank Transfer;
     */
    @NotEmpty
    private String docType;
}
