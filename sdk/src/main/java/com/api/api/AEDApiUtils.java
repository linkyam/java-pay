package com.api.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSON;
import com.api.api.common.CommonApiUtils;
import com.api.dto.common.req.PayinReqDTO;
import com.api.dto.common.req.PayoutReqDTO;
import com.api.dto.common.resp.PayoutRespDTO;
import com.api.dto.req.AED.AEDPayinReqDTO;
import com.api.dto.req.AED.AEDPayoutReqDTO;
import com.api.dto.resp.AED.AEDPayinRespDTO;
import com.api.strategy.Strategy;
import com.api.utils.ValidatorUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * AED-UAE Interface AEDApiUtils
 */
@Component
public class AEDApiUtils implements Strategy {

    @Resource
    private CommonApiUtils commonApiUtils;

    /**
     * payin
     * @param reqDTO
     * @return
     */
    public AEDPayinRespDTO payin(AEDPayinReqDTO reqDTO) {
        return (AEDPayinRespDTO) commonApiUtils.payin(reqDTO);
    }

    /**
     * piyout
     * @param reqDTO
     * @return
     */
    public PayoutRespDTO payout(AEDPayoutReqDTO reqDTO) {
        return commonApiUtils.payout(reqDTO);
    }

    @Override
    public AEDPayinRespDTO convertPayinRespDTO(Map<String, Object> dataMap) {
        return BeanUtil.toBean(dataMap, AEDPayinRespDTO.class);
    }

    @Override
    public String convertPayinJsonString(PayinReqDTO reqDTO) {
        AEDPayinReqDTO payinReqDTO = (AEDPayinReqDTO) reqDTO;
        ValidatorUtils.validate(payinReqDTO);
        return JSON.toJSONString(payinReqDTO);
    }

    @Override
    public String convertPayoutJsonString(PayoutReqDTO reqDTO) {
        AEDPayoutReqDTO payoutReqDTO = (AEDPayoutReqDTO) reqDTO;
        ValidatorUtils.validate(payoutReqDTO);
        return JSON.toJSONString(BeanUtil.beanToMap(reqDTO, MapUtil.newHashMap(), CopyOptions.create().setIgnoreNullValue(true).setIgnoreProperties("password")));
    }
}
