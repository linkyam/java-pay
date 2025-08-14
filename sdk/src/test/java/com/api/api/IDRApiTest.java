package com.api.api;

import com.alibaba.fastjson.JSONObject;
import com.api.BaseTest;
import com.api.dto.common.resp.PayoutRespDTO;
import com.api.dto.req.IDR.IDRPayinReqDTO;
import com.api.dto.req.IDR.IDRPayoutReqDTO;
import com.api.dto.resp.IDR.IDRPayinRespDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 印尼-文档：https://documenter.getpostman.com/view/10814992/2s93XyTNoA#27bc02bd-6a6e-4276-b7f7-c61c4a3c5a10
 * Indonesia-Document: https://documenter.getpostman.com/view/10814992/2s93Y3wMc8#5f8c85b4-a8d8-44d2-9ff3-7ba8480460a9
 */
public class IDRApiTest extends BaseTest {

    @Autowired
    private IDRApiUtils apiUtils;

    @Test
    public void testPayin_ALL_checkout() {
        IDRPayinReqDTO reqDTO = new IDRPayinReqDTO();
        reqDTO.setProductTitle("test title");
//        reqDTO.setPaymentType("WALLET");
        reqDTO.setPaymentMethod("CHECKOUT_URL");
//        reqDTO.setPaymentChannel("OVO");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("10000");
        reqDTO.setCurrency("IDR");
        reqDTO.setProductinfo("shopping");
        reqDTO.setFirstname("tim");
        reqDTO.setLastname("james");
        reqDTO.setEmail("james@gmail.com");
        reqDTO.setPhone("+551196716473");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/idr/payin");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        IDRPayinRespDTO respDTO = apiUtils.payin(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayinIDR =============:" + JSONObject.toJSONString(respDTO));
        }
    }

    @Test
    public void testPayinIDR_WALLET_OVO() {
        IDRPayinReqDTO reqDTO = new IDRPayinReqDTO();
        reqDTO.setProductTitle("test title");
        reqDTO.setPaymentType("WALLET");
        reqDTO.setPaymentMethod("CHECKOUT_URL");
        reqDTO.setPaymentChannel("OVO");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("20000");
        reqDTO.setCurrency("IDR");
        reqDTO.setProductinfo("shopping");
        reqDTO.setFirstname("tim");
        reqDTO.setLastname("james");
        reqDTO.setEmail("james@gmail.com");
        reqDTO.setPhone("+551196716473");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/idr/payin");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        IDRPayinRespDTO respDTO = apiUtils.payin(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayinIDR =============:" + JSONObject.toJSONString(respDTO));
        }
    }

    @Test
    public void testPayoutIDR() {
        IDRPayoutReqDTO reqDTO = new IDRPayoutReqDTO();
        reqDTO.setBeneficiaryBankCode("014");
        reqDTO.setPaymentType("DISBURSEMENTS");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("5000");
        reqDTO.setCurrency("IDR");
        reqDTO.setPurpose("ONaJMGh");
        reqDTO.setBeneficiaryName("Yonatan");
        reqDTO.setBeneficiaryEmail("james@gmail.com");
        reqDTO.setBeneficiaryMobile("+551196716473");
        reqDTO.setBeneficiaryAccountNumber("001101190100051890");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/idr/payout");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        PayoutRespDTO respDTO = apiUtils.payout(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayoutIDR =============:" + JSONObject.toJSONString(respDTO));
        }
    }
}
