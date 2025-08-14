package com.api.api;

import com.alibaba.fastjson.JSONObject;
import com.api.BaseTest;
import com.api.dto.common.resp.PayoutRespDTO;
import com.api.dto.req.COP.COPPayinReqDTO;
import com.api.dto.req.COP.COPPayoutReqDTO;
import com.api.dto.resp.COP.COPPayinRespDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 哥伦比亚-文档：https://documenter.getpostman.com/view/10814992/2s93XyTNoA#eb4d5cd1-e31a-401e-9941-cd2f1b6dbef0
 * Colombia-Document: https://documenter.getpostman.com/view/10814992/2s93Y3wMc8#22a5d7b5-8cdd-4b61-bc41-327427dc30df
 */
public class COPApiTest extends BaseTest {

    @Autowired
    private COPApiUtils apiUtils;

    @Test
    public void testPayinCOP_CASH() {
        COPPayinReqDTO reqDTO = new COPPayinReqDTO();
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setPaymentType("CASH");
        reqDTO.setAmount("10000");
        reqDTO.setCurrency("COP");
        reqDTO.setProductinfo("your pro simple desc");
        reqDTO.setFirstname("tim");
        reqDTO.setLastname("james");
        reqDTO.setEmail("james@gmail.com");
        reqDTO.setPhone("+551196716473");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/cop/payin");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        COPPayinRespDTO respDTO = apiUtils.payin(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayinCOP =============:" + JSONObject.toJSONString(respDTO));
        }
    }

    @Test
    public void testPayoutCOP_NET_BANKING() {
        // {"amount":4750000,"beneficiary":{"document":{"number":"1007507114","type":1},"email":"yolanda1007507114@gmail.com",
        // "lastName":"Yolanda palacios ventura","name":"Yolanda palacios ventura"},"country":"COL","currency":"COP",
        // "destination":{"bankAccount":{"accountNumber":"3113388611","accountType":"2","bankCode":"007"}},"orderId":"202409161835699051579957248"}
        COPPayoutReqDTO reqDTO = new COPPayoutReqDTO();
        reqDTO.setBeneficiaryBankName("BANCOLOMBIA");
        reqDTO.setFirstname("Alexandersadsa");
        reqDTO.setLastname("Bermudezwwqq");
        reqDTO.setBeneficiaryAccountType("SAVINGS");
        reqDTO.setDocNumber("1037595791");
        reqDTO.setDocType("CC");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("2500");
        reqDTO.setCurrency("COP");
        reqDTO.setPurpose("shopping");
        reqDTO.setPaymentType("NET_BANKING");
        reqDTO.setBeneficiaryName("Alexander Bermudez");
        reqDTO.setBeneficiaryEmail("testa@liquido.com");
        reqDTO.setBeneficiaryMobile("12345627776");
        reqDTO.setBeneficiaryAccountNumber("38173373195");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/cop/payout");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        PayoutRespDTO respDTO = apiUtils.payout(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayoutCOP =============:" + JSONObject.toJSONString(respDTO));
        }
    }
}
