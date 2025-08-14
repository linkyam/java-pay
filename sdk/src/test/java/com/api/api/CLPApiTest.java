package com.api.api;

import com.alibaba.fastjson.JSONObject;
import com.api.BaseTest;
import com.api.dto.common.resp.PayoutRespDTO;
import com.api.dto.req.CLP.CLPPayinReqDTO;
import com.api.dto.req.CLP.CLPPayoutReqDTO;
import com.api.dto.resp.CLP.CLPPayinRespDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 智利-文档：https://documenter.getpostman.com/view/10814992/2s93XyTNoA#ac548aad-dabb-4ad8-a0b8-20912d01fac5
 * Chile-Document: https://documenter.getpostman.com/view/10814992/2s93Y3wMc8#52f3179f-1338-4971-833d-453c2d5c7af0
 */
public class CLPApiTest extends BaseTest {

    @Autowired
    private CLPApiUtils apiUtils;

    @Test
    public void testPayinCLP_CASH() {
        CLPPayinReqDTO reqDTO = new CLPPayinReqDTO();
        reqDTO.setBeneficiaryType("RUT");
        reqDTO.setBeneficiaryId("242112412");
        reqDTO.setPaymentType("CASH");
        reqDTO.setMchOrderId("test"+String.valueOf(new Date().getTime()));
        reqDTO.setAmount("10000");
        reqDTO.setCurrency("CLP");
        reqDTO.setProductinfo("CLP info");
        reqDTO.setFirstname("Tom");
        reqDTO.setLastname("jrui");
        reqDTO.setEmail("api@gmail.com");
        reqDTO.setPhone("+551196716473");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/clp/payin");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        CLPPayinRespDTO respDTO = apiUtils.payin(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayinCLP =============:" + JSONObject.toJSONString(respDTO));
        }
    }

    @Test
    public void testPayinCLP_TCTD() {
        CLPPayinReqDTO reqDTO = new CLPPayinReqDTO();
        reqDTO.setBeneficiaryType("RUT");
        reqDTO.setBeneficiaryId("242112412");
        reqDTO.setPaymentType("TD");
        //reqDTO.setPaymentType("TC");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("100000");
        reqDTO.setCurrency("CLP");
        reqDTO.setProductinfo("CLP info");
        reqDTO.setFirstname("Tom");
        reqDTO.setLastname("jrui");
        reqDTO.setEmail("api@gmail.com");
        reqDTO.setPhone("+551196716473");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/clp/payin");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        CLPPayinRespDTO respDTO = apiUtils.payin(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayinCLP =============:" + JSONObject.toJSONString(respDTO));
        }
    }

    @Test
    public void testPayinCLP_NET_BANKING() {
        CLPPayinReqDTO reqDTO = new CLPPayinReqDTO();
        reqDTO.setBeneficiaryType("RUT");
        reqDTO.setBeneficiaryId("242112412");
        reqDTO.setPaymentType("NET_BANKING");
        //reqDTO.setPaymentType("TC");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("10000");
        reqDTO.setCurrency("CLP");
        reqDTO.setProductinfo("CLP info");
        reqDTO.setFirstname("Tom");
        reqDTO.setLastname("jrui");
        reqDTO.setEmail("api@gmail.com");
        reqDTO.setPhone("+551196716473");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/clp/payin");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        CLPPayinRespDTO respDTO = apiUtils.payin(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayinCLP =============:" + JSONObject.toJSONString(respDTO));
        }
    }

    @Test
    public void testPayoutCLP_NET_BANKING() {
        CLPPayoutReqDTO reqDTO = new CLPPayoutReqDTO();
        reqDTO.setBeneficiaryType("1");
        reqDTO.setBeneficiaryId("273447776");
        reqDTO.setBeneficiaryBankType("1");
        reqDTO.setBeneficiaryBankCode("Banco Santander");
        reqDTO.setPaymentType("NET_BANKING");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("500");
        reqDTO.setCurrency("CLP");
        reqDTO.setPurpose("shopping");
        reqDTO.setBeneficiaryName("NETMOBI CHILE SPA");
        reqDTO.setBeneficiaryEmail("api@gmail.com");
        reqDTO.setBeneficiaryMobile("9324324352");
        reqDTO.setBeneficiaryAccountNumber("000087095983");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/clp/payout");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        PayoutRespDTO respDTO = apiUtils.payout(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayoutBRL =============:" + JSONObject.toJSONString(respDTO));
        }
    }
}
