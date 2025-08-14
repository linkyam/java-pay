package com.api.api;

import com.alibaba.fastjson.JSONObject;
import com.api.BaseTest;
import com.api.dto.common.resp.PayoutRespDTO;
import com.api.dto.req.MXN.MXNPayinReqDTO;
import com.api.dto.req.MXN.MXNPayoutReqDTO;
import com.api.dto.resp.MXN.MXNPayinRespDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 墨西哥-文档：https://documenter.getpostman.com/view/10814992/2s93XyTNoA#5c2f17f7-b93a-41dd-9eee-fbb8a4bbaf87
 * Mexico-Document: https://documenter.getpostman.com/view/10814992/2s93Y3wMc8#3e6d8de1-3652-470f-bd79-bd669f37eb29
 */
public class MXNApiTest extends BaseTest {

    @Autowired
    private MXNApiUtils apiUtils;

    @Test
    public void testPayinMXN_SEPI() {
        MXNPayinReqDTO reqDTO = new MXNPayinReqDTO();
        reqDTO.setDynamic("4");
        reqDTO.setPaymentType("SPEI");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("10");
        reqDTO.setCurrency("MXN");
        reqDTO.setProductinfo("your pro simple desc");
        reqDTO.setFirstname("tim");
        reqDTO.setLastname("james");
        reqDTO.setEmail("james@gmail.com");
        reqDTO.setPhone("+551196716473");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/mxn/payin");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        MXNPayinRespDTO respDTO = apiUtils.payin(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayinMXN =============:" + JSONObject.toJSONString(respDTO));
        }
    }

    @Test
    public void testPayoutMXN_NET_BANKING() {
        MXNPayoutReqDTO reqDTO = new MXNPayoutReqDTO();
        reqDTO.setBeneficiaryBankCode("37006");
        reqDTO.setPaymentType("NET_BANKING");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("1");
        reqDTO.setCurrency("MXN");
        reqDTO.setPurpose("ONaJMGh");
        reqDTO.setBeneficiaryName("Yonatan");
        reqDTO.setBeneficiaryEmail("james@gmail.com");
        reqDTO.setBeneficiaryMobile("+551196716473");
        reqDTO.setBeneficiaryAccountNumber("001101190100051890");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/mxn/payout");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        PayoutRespDTO respDTO = apiUtils.payout(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayoutMXN =============:" + JSONObject.toJSONString(respDTO));
        }
    }

    @Test
    public void testPayoutMXN_SPEI() {
        MXNPayoutReqDTO reqDTO = new MXNPayoutReqDTO();
        reqDTO.setPaymentType("SPEI");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("1");
        reqDTO.setCurrency("MXN");
        reqDTO.setPurpose("ONaJMGh");
        reqDTO.setBeneficiaryName("Yonatan");
        reqDTO.setBeneficiaryEmail("james@gmail.com");
        reqDTO.setBeneficiaryMobile("+551196716473");
        reqDTO.setBeneficiaryAccountNumber("012180015679304263");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/mxn/payout");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        PayoutRespDTO respDTO = apiUtils.payout(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayoutMXN =============:" + JSONObject.toJSONString(respDTO));
        }
    }
}
