package com.api.api;

import com.alibaba.fastjson.JSONObject;
import com.api.BaseTest;
import com.api.dto.common.resp.PayoutRespDTO;
import com.api.dto.req.PEN.PENPayinReqDTO;
import com.api.dto.req.PEN.PENPayoutReqDTO;
import com.api.dto.resp.PEN.PENPayinRespDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 秘鲁-文档：https://documenter.getpostman.com/view/10814992/2s93XyTNoA#5e649437-ddb5-40a5-8ec1-2df01f1bd057
 * Peru-Document: https://documenter.getpostman.com/view/10814992/2s93Y3wMc8#b7c68852-2c70-4c8e-be77-649f7d8902b3
 */
public class PENApiTest extends BaseTest {

    @Autowired
    private PENApiUtils apiUtils;

    @Test
    public void testPayinPEN() {
        PENPayinReqDTO reqDTO = new PENPayinReqDTO();
        reqDTO.setBeneficiaryType("DNI");
        reqDTO.setBeneficiaryId("88888888");
        reqDTO.setPaymentType("NET_BANKING");
        reqDTO.setPaymentMethod("");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("100");
        reqDTO.setCurrency("PEN");
        reqDTO.setProductinfo("shopping");
        reqDTO.setFirstname("tim");
        reqDTO.setLastname("james");
        reqDTO.setEmail("james@gmail.com");
        reqDTO.setPhone("+551196716473");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/pen/payin");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        PENPayinRespDTO respDTO = apiUtils.payin(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayinPEN =============:" + JSONObject.toJSONString(respDTO));
        }
    }

    @Test
    public void testPayinPEN_NET_BANKING() {
        PENPayinReqDTO reqDTO = new PENPayinReqDTO();
        reqDTO.setBeneficiaryType("DNI");
        reqDTO.setBeneficiaryId("88888888");
        reqDTO.setPaymentType("NET_BANKING");
        reqDTO.setPaymentMethod("");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("100");
        reqDTO.setCurrency("PEN");
        reqDTO.setProductinfo("shopping");
        reqDTO.setFirstname("tim");
        reqDTO.setLastname("james");
        reqDTO.setEmail("james@gmail.com");
        reqDTO.setPhone("+551196716473");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/pen/payin");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        PENPayinRespDTO respDTO = apiUtils.payin(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayinPEN =============:" + JSONObject.toJSONString(respDTO));
        }
    }

    @Test
    public void testPayinPEN_TD_TD() {
        PENPayinReqDTO reqDTO = new PENPayinReqDTO();
        reqDTO.setBeneficiaryType("DNI");
        reqDTO.setBeneficiaryId("88888888");
        reqDTO.setPaymentType("TD");
//        reqDTO.setPaymentType("TC");
        reqDTO.setPaymentMethod("");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("100");
        reqDTO.setCurrency("PEN");
        reqDTO.setProductinfo("shopping");
        reqDTO.setFirstname("tim");
        reqDTO.setLastname("james");
        reqDTO.setEmail("james@gmail.com");
        reqDTO.setPhone("+551196716473");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/pen/payin");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        PENPayinRespDTO respDTO = apiUtils.payin(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayinPEN =============:" + JSONObject.toJSONString(respDTO));
        }
    }

    @Test
    public void testPayoutPEN_NET_BANKING() {
        PENPayoutReqDTO reqDTO = new PENPayoutReqDTO();
        reqDTO.setBeneficiaryType("1");
        reqDTO.setBeneficiaryId("40405304");
        reqDTO.setBeneficiaryBankType("1");
        reqDTO.setBeneficiaryBankCode("Banco de Credito");
        reqDTO.setRecipientCardNo("00219113144900106651");
        reqDTO.setPaymentType("NET_BANKING");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("1");
        reqDTO.setCurrency("PEN");
        reqDTO.setPurpose("ONaJMGh");
        reqDTO.setBeneficiaryName("Gonzalo Sanchez");
        reqDTO.setBeneficiaryEmail("828921asd@gmail.com");
        reqDTO.setBeneficiaryMobile("9324324352");
        reqDTO.setBeneficiaryAccountNumber("19131449001066");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/pen/payout");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        PayoutRespDTO respDTO = apiUtils.payout(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayoutPEN =============:" + JSONObject.toJSONString(respDTO));
        }
    }
}
