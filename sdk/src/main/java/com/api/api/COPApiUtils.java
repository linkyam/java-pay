package com.api.api;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.api.api.common.CommonApiUtils;
import com.api.dto.common.req.PayinReqDTO;
import com.api.dto.common.req.PayoutReqDTO;
import com.api.dto.common.resp.PayoutRespDTO;
import com.api.dto.req.COP.COPPayinReqDTO;
import com.api.dto.req.COP.COPPayoutReqDTO;
import com.api.dto.resp.COP.COPPayinRespDTO;
import com.api.strategy.Strategy;
import com.api.utils.ValidatorUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * COP-Colombia Interface COPApiUtils
 */
@Component
public class COPApiUtils implements Strategy {

    @Resource
    private CommonApiUtils commonApiUtils;

    /**
     * payin
     * @param reqDTO
     * @return
     */
    public COPPayinRespDTO payin(COPPayinReqDTO reqDTO) {
        return (COPPayinRespDTO) commonApiUtils.payin(reqDTO);
    }

    /**
     * piyout
     * @param reqDTO
     * @return
     */
    public PayoutRespDTO payout(COPPayoutReqDTO reqDTO) {
        return commonApiUtils.payout(reqDTO);
    }

    @Override
    public COPPayinRespDTO convertPayinRespDTO(Map<String, Object> dataMap) {
        return BeanUtil.toBean(dataMap, COPPayinRespDTO.class);
    }

    @Override
    public String convertPayinJsonString(PayinReqDTO reqDTO) {
        COPPayinReqDTO payinReqDTO = (COPPayinReqDTO) reqDTO;
        ValidatorUtils.validate(payinReqDTO);
        return JSON.toJSONString(payinReqDTO);
    }

    @Override
    public String convertPayoutJsonString(PayoutReqDTO reqDTO) {
        COPPayoutReqDTO payoutReqDTO = (COPPayoutReqDTO) reqDTO;
        ValidatorUtils.validate(payoutReqDTO);
        return JSON.toJSONString(payoutReqDTO);
    }
}
