package com.api.strategy;

import com.api.dto.common.req.PayinReqDTO;
import com.api.dto.common.req.PayoutReqDTO;
import com.api.dto.common.resp.PayinRespDTO;

import java.util.Map;

public interface Strategy {
    PayinRespDTO convertPayinRespDTO(Map<String, Object> dataMap);

    String convertPayinJsonString(PayinReqDTO reqDTO);

    String convertPayoutJsonString(PayoutReqDTO reqDTO);
}
