package com.api.api;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.api.api.common.CommonApiUtils;
import com.api.dto.common.req.PayinReqDTO;
import com.api.dto.common.req.PayoutReqDTO;
import com.api.dto.req.VISA.VISAPayinReqDTO;
import com.api.dto.resp.VISA.VISAPayinRespDTO;
import com.api.strategy.Strategy;
import com.api.utils.ValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * VISA-MASTERCARD Interface VISAApiUtils
 */
@Slf4j
@Component
public class VISAApiUtils implements Strategy {

    @Resource
    private CommonApiUtils commonApiUtils;

    /**
     * payin
     * @param reqDTO
     * @return
     */
    public VISAPayinRespDTO payin(VISAPayinReqDTO reqDTO) {
        return (VISAPayinRespDTO) commonApiUtils.payin(reqDTO);
    }

    @Override
    public VISAPayinRespDTO convertPayinRespDTO(Map<String, Object> dataMap) {
        return BeanUtil.toBean(dataMap, VISAPayinRespDTO.class);
    }

    @Override
    public String convertPayinJsonString(PayinReqDTO reqDTO) {
        VISAPayinReqDTO payinReqDTO = (VISAPayinReqDTO) reqDTO;
        ValidatorUtils.validate(payinReqDTO);
        return JSON.toJSONString(payinReqDTO);
    }

    @Override
    public String convertPayoutJsonString(PayoutReqDTO reqDTO) {
        log.info("VISA Not supported payout");
        return "";
    }
}
