package com.api.api;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.api.api.common.CommonApiUtils;
import com.api.dto.common.req.PayinReqDTO;
import com.api.dto.common.req.PayoutReqDTO;
import com.api.dto.common.resp.PayoutRespDTO;
import com.api.dto.req.ZAR.ZARPayinReqDTO;
import com.api.dto.req.ZAR.ZARPayoutReqDTO;
import com.api.dto.resp.ZAR.ZARPayinRespDTO;
import com.api.strategy.Strategy;
import com.api.utils.ValidatorUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * ZAR-southAfrica Interface ZARApiUtils
 */
@Component
public class ZARApiUtils implements Strategy {

    @Resource
    private CommonApiUtils commonApiUtils;

    /**
     * payin
     * @param reqDTO
     * @return
     */
    public ZARPayinRespDTO payin(ZARPayinReqDTO reqDTO) {
        return (ZARPayinRespDTO) commonApiUtils.payin(reqDTO);
    }

    /**
     * piyout
     * @param reqDTO
     * @return
     */
    public PayoutRespDTO payout(ZARPayoutReqDTO reqDTO) {
        return commonApiUtils.payout(reqDTO);
    }

    @Override
    public ZARPayinRespDTO convertPayinRespDTO(Map<String, Object> dataMap) {
        return BeanUtil.toBean(dataMap, ZARPayinRespDTO.class);
    }

    @Override
    public String convertPayinJsonString(PayinReqDTO reqDTO) {
        ZARPayinReqDTO payinReqDTO = (ZARPayinReqDTO) reqDTO;
        ValidatorUtils.validate(payinReqDTO);
        return JSON.toJSONString(payinReqDTO);
    }

    @Override
    public String convertPayoutJsonString(PayoutReqDTO reqDTO) {
        ZARPayoutReqDTO payoutReqDTO = (ZARPayoutReqDTO) reqDTO;
        ValidatorUtils.validate(payoutReqDTO);
        return JSON.toJSONString(payoutReqDTO);
    }
}
