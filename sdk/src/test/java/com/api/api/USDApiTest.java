package com.api.api;

import com.alibaba.fastjson.JSONObject;
import com.api.BaseTest;
import com.api.dto.common.resp.PayoutRespDTO;
import com.api.dto.req.USD.USDPayinReqDTO;
import com.api.dto.req.USD.USDPayoutReqDTO;
import com.api.dto.resp.USD.USDPayinRespDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 美国-文档：https://documenter.getpostman.com/view/10814992/2s93XyTNoA#d25d93df-189c-4e38-9114-63ce8fbd9518
 * USA-Document: https://documenter.getpostman.com/view/10814992/2s93Y3wMc8#6ca6365b-c1dd-4d98-bc26-7da3ab733e03
 */
public class USDApiTest extends BaseTest {

    @Autowired
    private USDApiUtils apiUtils;

    @Test
    public void testPayinUSD_CASHAPP() {
        USDPayinReqDTO reqDTO = new USDPayinReqDTO();
        reqDTO.setPaymentType("CASHAPP");
        reqDTO.setIpAddress("67.220.91.30");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("10");
        reqDTO.setCurrency("USD");
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
        USDPayinRespDTO respDTO = apiUtils.payin(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayinUSD =============:" + JSONObject.toJSONString(respDTO));
        }
    }

    @Test
    public void testPayoutUSD() {
        USDPayoutReqDTO reqDTO = new USDPayoutReqDTO();
        reqDTO.setPaymentType("CASHAPPOUT");
        reqDTO.setIpAddress("45.79.211.4");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("1");
        reqDTO.setCurrency("USD");
        reqDTO.setPurpose("remark");
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
            System.out.println("testPayoutUSD =============:" + JSONObject.toJSONString(respDTO));
        }
    }
}
