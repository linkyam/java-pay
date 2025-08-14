package com.api.api;

import com.alibaba.fastjson.JSONObject;
import com.api.BaseTest;
import com.api.dto.common.resp.PayoutRespDTO;
import com.api.dto.req.BRL.BRLPayinReqDTO;
import com.api.dto.req.BRL.BRLPayoutReqDTO;
import com.api.dto.resp.BRL.BRLPayinRespDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 巴西-文档：https://documenter.getpostman.com/view/10814992/2s93XyTNoA#9000ebb0-4b80-4c6e-a126-4f0e202add63
 * Brazil-Document: https://documenter.getpostman.com/view/10814992/2s93Y3wMc8#9ec80fa2-534a-4ff0-b563-c83bde89f7a8
 */
public class BRLApiTest extends BaseTest {

    @Autowired
    private BRLApiUtils brlApiUtils;

    @Test
    public void testPayinBRLPIX() {
        BRLPayinReqDTO reqDTO = new BRLPayinReqDTO();
        reqDTO.setDocNumber("14868845801");
        reqDTO.setDocType("PIX");
        reqDTO.setMchOrderId("mch100000000000007");
        reqDTO.setAmount("10");
        reqDTO.setCurrency("BRL");
        reqDTO.setProductinfo("shopping");
        reqDTO.setFirstname("tom");
        reqDTO.setLastname("lee");
        reqDTO.setEmail("tomlee@tomlee.com");
        reqDTO.setPhone("+5511967164733");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/brl/payin");
        reqDTO.setRedirectUrl("");
//        reqDTO.setNoPayPage("true");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        BRLPayinRespDTO respDTO = brlApiUtils.payin(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayinBRL =============:" + JSONObject.toJSONString(respDTO));
        }
    }

    @Test
    public void testPayoutBRLPIX() {
        BRLPayoutReqDTO reqDTO = new BRLPayoutReqDTO();
        reqDTO.setDocType("PIX");
        reqDTO.setDocNumber("43099545880");
        reqDTO.setPixCheck("true");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("1");
        reqDTO.setCurrency("BRL");
        reqDTO.setPurpose("shopping");
        reqDTO.setBeneficiaryName("Murilo Azeredo Pereira");
        reqDTO.setBeneficiaryEmail("tomlee@tomlee.com");
        reqDTO.setBeneficiaryMobile("+5511967164793");
        reqDTO.setBeneficiaryAccountNumber("43099545880");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/brl/payin");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        PayoutRespDTO respDTO = brlApiUtils.payout(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayoutBRL =============:" + JSONObject.toJSONString(respDTO));
        }
    }

    @Test
    public void testPayoutBRLPIX_Not_check_cpf() {
        BRLPayoutReqDTO reqDTO = new BRLPayoutReqDTO();
        reqDTO.setPixCheck("false");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("1");
        reqDTO.setCurrency("BRL");
        reqDTO.setPurpose("shopping");
        reqDTO.setBeneficiaryName("Murilo Azeredo Pereira");
        reqDTO.setBeneficiaryEmail("tomlee@tomlee.com");
        reqDTO.setBeneficiaryMobile("+5511967164793");
        reqDTO.setBeneficiaryAccountNumber("43099545880");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/brl/payin");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        PayoutRespDTO respDTO = brlApiUtils.payout(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayoutBRL =============:" + JSONObject.toJSONString(respDTO));
        }
    }
}
