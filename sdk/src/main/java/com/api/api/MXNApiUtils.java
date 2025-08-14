package com.api.api;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.api.api.common.CommonApiUtils;
import com.api.dto.common.req.PayinReqDTO;
import com.api.dto.common.req.PayoutReqDTO;
import com.api.dto.common.resp.PayoutRespDTO;
import com.api.dto.req.MXN.MXNPayinReqDTO;
import com.api.dto.req.MXN.MXNPayoutReqDTO;
import com.api.dto.resp.MXN.MXNPayinRespDTO;
import com.api.strategy.Strategy;
import com.api.utils.ValidatorUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * MXN-Mexico Interface MXNApiUtils
 */
@Component
public class MXNApiUtils implements Strategy {

    @Resource
    private CommonApiUtils commonApiUtils;

    /**
     * payin
     * @param reqDTO
     * @return
     */
    public MXNPayinRespDTO payin(MXNPayinReqDTO reqDTO) {
        return (MXNPayinRespDTO) commonApiUtils.payin(reqDTO);
    }

    /**
     * piyout
     * @param reqDTO
     * @return
     */
    public PayoutRespDTO payout(MXNPayoutReqDTO reqDTO) {
        return commonApiUtils.payout(reqDTO);
    }

    @Override
    public MXNPayinRespDTO convertPayinRespDTO(Map<String, Object> dataMap) {
        return BeanUtil.toBean(dataMap, MXNPayinRespDTO.class);
    }

    @Override
    public String convertPayinJsonString(PayinReqDTO reqDTO) {
        MXNPayinReqDTO payinReqDTO = (MXNPayinReqDTO) reqDTO;
        ValidatorUtils.validate(payinReqDTO);
        return JSON.toJSONString(payinReqDTO);
    }

    @Override
    public String convertPayoutJsonString(PayoutReqDTO reqDTO) {
        MXNPayoutReqDTO payoutReqDTO = (MXNPayoutReqDTO) reqDTO;
        ValidatorUtils.validate(payoutReqDTO);
        return JSON.toJSONString(payoutReqDTO);
    }

}
