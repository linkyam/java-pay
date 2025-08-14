package com.api.api;

import com.alibaba.fastjson.JSONObject;
import com.api.BaseTest;
import com.api.dto.common.resp.PayoutRespDTO;
import com.api.dto.req.PHP.PHPPayinReqDTO;
import com.api.dto.req.PHP.PHPPayoutReqDTO;
import com.api.dto.resp.PHP.PHPPayinRespDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 菲律宾-文档：https://documenter.getpostman.com/view/10814992/2s93XyTNoA#a35ed330-4585-4a7e-beec-5eef4a79d9e6
 * Philippines-Document: https://documenter.getpostman.com/view/10814992/2s93Y3wMc8#246ec4c4-e628-432c-8bcb-86b06742a4ae
 */
public class PHPApiTest extends BaseTest {

    @Autowired
    private PHPApiUtils apiUtils;

    @Test
    public void testPayinPHP_WALLET_GCASH() {
        PHPPayinReqDTO reqDTO = new PHPPayinReqDTO();
        reqDTO.setProductTitle("shopping");
        reqDTO.setPaymentType("WALLET_GCASH");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("5000");
        reqDTO.setCurrency("PHP");
        reqDTO.setProductinfo("your pro simple desc");
        reqDTO.setFirstname("tim");
        reqDTO.setLastname("james");
        reqDTO.setEmail("james@gmail.com");
        reqDTO.setPhone("+551196716473");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/php/payin");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        PHPPayinRespDTO respDTO = apiUtils.payin(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayinPHP =============:" + JSONObject.toJSONString(respDTO));
        }
    }

    @Test
    public void testPayinPHP_QRIS() {
        PHPPayinReqDTO reqDTO = new PHPPayinReqDTO();
        reqDTO.setProductTitle("shopping");
        reqDTO.setPaymentType("QRIS");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("5000");
        reqDTO.setCurrency("PHP");
        reqDTO.setProductinfo("your pro simple desc");
        reqDTO.setFirstname("tim");
        reqDTO.setLastname("james");
        reqDTO.setEmail("james@gmail.com");
        reqDTO.setPhone("+551196716473");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/php/payin");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        PHPPayinRespDTO respDTO = apiUtils.payin(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayinPHP =============:" + JSONObject.toJSONString(respDTO));
        }
    }

    /**
     * {
     *     "amount": "100",
     *     "currency": "PHP",
     *     "callbackUrl": "http://127.0.0.1:8082/india-merchant/core/callback",
     *     "beneficiaryEmail": "muazpe@gmail.com",
     *     "beneficiaryName": "DIANE JANE BENSURTO",
     *     "beneficiaryAccountNumber": "09171446646",
     *     "beneficiaryBankCode":"BC90001",
     *     "beneficiaryMobile":"09311606128",
     *     "mchOrderId": "test3434314144",
     *     "beneficiaryIfscCode": "tests",
     *     "paymentType":"WALLET_GCASH"
     * }
     */
    @Test
    public void testPayoutPHP() {
        PHPPayoutReqDTO reqDTO = new PHPPayoutReqDTO();
        reqDTO.setBeneficiaryBankCode("BC90001");
        reqDTO.setPaymentType("WALLET_GCASH");
        reqDTO.setMchOrderId(String.valueOf(new Date().getTime()));
        reqDTO.setAmount("10");
        reqDTO.setCurrency("PHP");
        reqDTO.setPurpose("remark");
        reqDTO.setBeneficiaryName("DIANE JANE BENSURTO");
        reqDTO.setBeneficiaryEmail("muazpe@gmail.com");
        reqDTO.setBeneficiaryMobile("09311606128");
        reqDTO.setBeneficiaryAccountNumber("09171446646");
        reqDTO.setCallbackUrl("https://webhook.merchant.com/php/payout");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        PayoutRespDTO respDTO = apiUtils.payout(reqDTO);
        if (null != respDTO) {
            System.out.println("testPayoutPHP =============:" + JSONObject.toJSONString(respDTO));
        }
    }
}
