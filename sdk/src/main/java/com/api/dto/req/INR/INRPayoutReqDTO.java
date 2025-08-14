package com.api.dto.req.INR;

import com.api.dto.common.req.PayoutReqDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class INRPayoutReqDTO extends PayoutReqDTO {
    /**
     * 收款人Ifsc编码，paymentType为
     * IMPS and NEFT, RTGS 必填
     */
    private String beneficiaryIfscCode;
    /**
     * 虚拟支付账号，
     * paymentType为
     * UPI 必填
     */
    private String vpa;
    /**
     * 出款方式
     * paymentType为NET_BANKING,cc_payment, VISA, MASTERCARD的必填
     */
    private String recipientCardNo;
    /**
     * 出款方式：
     * IMPS,UPI,NEFT,RTGS,MASTERCARD,VISA,CC_PAYMENT,NET_BANKING，目前仅支持NET_BANKING,IMPS和UPI
     * recipientCardNo不为空时候必填
     */
    @NotEmpty
    private String paymentType;

}
