package com.api.api.common;

import cn.hutool.core.util.StrUtil;
import com.api.BaseTest;
import com.api.dto.common.req.BalanceReqDTO;
import com.api.dto.common.req.VerifyStatusReqDTO;
import com.api.dto.common.resp.BalanceRespDTO;
import com.api.dto.common.resp.VerifyStatusRespDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonApiTest extends BaseTest {

    @Autowired
    private CommonApiUtils commonApiUtils;
    
    @Test
    public void testMerchantBalanceQuery() {
        BalanceReqDTO reqDTO = new BalanceReqDTO();
        reqDTO.setCurrency("BRL");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        BalanceRespDTO respDTO = commonApiUtils.balance(reqDTO);
        if (null != respDTO) {
            System.out.println("testMerchantBalanceQuery =============:" + respDTO.toString());
        }
    }

    @Test
    public void testOrderQuery() {
        VerifyStatusReqDTO reqDTO = new VerifyStatusReqDTO();
        reqDTO.setOrderId("202409131834592556130435072");
//      可以覆盖配置文件中的值
//      can override the value in the configuration file
//      reqDTO.setMchId("");
//      reqDTO.setMchKey("");
        VerifyStatusRespDTO respDTO = commonApiUtils.verifyStatus(reqDTO);
        if (null != respDTO) {
            System.out.println("testOrderQuery =============:" + respDTO.toString());
        }
    }

    @Test
    public void testValidWebhookSignature() {
        String webhookBodyStr = "";
        String headerSign = "";
        String sign = commonApiUtils.signature(webhookBodyStr);
        //String sign2 = commonApiUtils.signature(signatureStr, "Fehu231.!fdds");
        if (StrUtil.equals(sign, headerSign)) {
            System.out.println("testValidWebhookSignature =============:success");
        }
    }
}
