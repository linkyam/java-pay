package com.api.api;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.api.api.common.CommonApiUtils;
import com.api.dto.common.req.PayinReqDTO;
import com.api.dto.common.req.PayoutReqDTO;
import com.api.dto.req.ECS.ECSPayinReqDTO;
import com.api.dto.resp.ECS.ECSPayinRespDTO;
import com.api.strategy.Strategy;
import com.api.utils.ValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * ECS-Ecuador Interface ECSApiUtils
 */
@Slf4j
@Component
public class ECSApiUtils implements Strategy {

    @Resource
    private CommonApiUtils commonApiUtils;

    /**
     * payin
     * @param reqDTO
     * @return
     */
    public ECSPayinRespDTO payin(ECSPayinReqDTO reqDTO) {
        return (ECSPayinRespDTO) commonApiUtils.payin(reqDTO);
    }

    @Override
    public ECSPayinRespDTO convertPayinRespDTO(Map<String, Object> dataMap) {
        return BeanUtil.toBean(dataMap, ECSPayinRespDTO.class);
    }

    @Override
    public String convertPayinJsonString(PayinReqDTO reqDTO) {
        ECSPayinReqDTO payinReqDTO = (ECSPayinReqDTO) reqDTO;
        ValidatorUtils.validate(payinReqDTO);
        return JSON.toJSONString(payinReqDTO);
    }

    @Override
    public String convertPayoutJsonString(PayoutReqDTO reqDTO) {
        log.info("ECS Not supported payout");
        return "";
    }
}