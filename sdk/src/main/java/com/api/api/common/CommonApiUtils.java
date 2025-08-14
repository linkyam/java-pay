package com.api.api.common;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.config.PayApiConfig;
import com.api.constants.CommonConstant;
import com.api.dto.common.req.BalanceReqDTO;
import com.api.dto.common.req.PayinReqDTO;
import com.api.dto.common.req.PayoutReqDTO;
import com.api.dto.common.req.VerifyStatusReqDTO;
import com.api.dto.common.resp.BalanceRespDTO;
import com.api.dto.common.resp.PayinRespDTO;
import com.api.dto.common.resp.PayoutRespDTO;
import com.api.dto.common.resp.VerifyStatusRespDTO;
import com.api.enums.BusinessCodeEnums;
import com.api.enums.PayApiMehodEnum;
import com.api.strategy.StrategyFactory;
import com.api.utils.HttpUtil;
import com.api.utils.ValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * common api utils
 */
@Slf4j
@Component
public class CommonApiUtils {

    @Autowired
    private PayApiConfig payApiConfig;

    @Autowired
    private StrategyFactory strategyFactory;

    /**
     * 代收下单
     * create payin order
     * @param reqDTO
     * @return
     */
    public PayinRespDTO payin(PayinReqDTO reqDTO) {
        try {
            log.info("merchant request payin, reqParam:{}", JSON.toJSONString(reqDTO));
            // reset merchant id and key than clear reqDTO key
            // 重置商户id和key，然后清除reqDTO key
            APIKey apiKey = resetPayinMchIdAndKey(reqDTO);

            // Convert objects to JSON strings by currency
            String json = strategyFactory.convertProcess(reqDTO, reqDTO.getCurrency());
            if (StrUtil.isEmpty(json) || !JSONUtil.isTypeJSON(json)) {
                log.error("Payin does not support this specific currency:{}", reqDTO.getCurrency());
                return null;
            }

            // Set request header
            Map<String, String> head = setHeader(CommonConstant.SERVICE_NAME, PayApiMehodEnum.pay.name(),
                    apiKey.getMchId(), apiKey.getMchKey(), json);

            // Request payin
            JSONObject rst = HttpUtil.post(payApiConfig.getApiUrl(), PayApiMehodEnum.pay, json, JSONObject.class, head);
            if (!StrUtil.equals(BusinessCodeEnums.SUCCESS.getErrorCode(), (String) rst.get("resultCode"))) {
                return null;
            }

            // Convert JSON string to object
            Map dataMap = BeanUtil.toBean(JSONArray.parseArray(rst.getString("data")).get(0), Map.class);
            if (CollectionUtil.isEmpty(dataMap)) {
                log.error("merchant request payin, response data is null");
                return null;
            }

            return strategyFactory.convertProcess(dataMap, reqDTO.getCurrency());
        } catch (ValidationException e) {
            log.error("payin param error, reqDTO:{}", reqDTO, e);
        } catch (Exception e) {
            log.error("payin error, reqDTO:{}", reqDTO, e);
        }
        return null;
    }

    /**
     * 代付下单
     * create payout order
     * @param reqDTO
     * @return
     */
    public PayoutRespDTO payout(PayoutReqDTO reqDTO) {
        try {
            log.info("merchant request payout, reqParam:{}", JSON.toJSONString(reqDTO));
            // reset merchant id and key than clear reqDTO key
            // 重置商户id和key，然后清除reqDTO key
            APIKey apiKey = resetPayoutMchIdAndKey(reqDTO);

            String json = strategyFactory.convertProcess(reqDTO, reqDTO.getCurrency());
            if (StrUtil.isEmpty(json)) {
                log.error("payout does not support this specific reqDTO:{}", reqDTO);
                return null;
            }

            // Set request header
            Map<String, String> head = setHeader(CommonConstant.SERVICE_NAME, PayApiMehodEnum.payOut.name(),
                    apiKey.getMchId(), apiKey.getMchKey(), json);

            // Request payout
            JSONObject rst = HttpUtil.post(payApiConfig.getApiUrl(), PayApiMehodEnum.payOut, json, JSONObject.class, head);
            if (null == rst || !StrUtil.equals(BusinessCodeEnums.SUCCESS.getErrorCode(), (String) rst.get("resultCode"))) {
                return null;
            }

            // Convert JSON string to object
            Map<String, Object> dataMap = BeanUtil.toBean(JSONArray.parseArray(rst.getString("data")).get(0), Map.class);
            if (CollectionUtil.isEmpty(dataMap)) {
                log.error("merchant request payout, response data is null,reqDto:{}", reqDTO);
                return null;
            }
            return BeanUtil.toBean(dataMap, PayoutRespDTO.class);

        } catch (ValidationException e) {
            log.error("payout param error, reqDTO:{}",reqDTO, e);
        } catch (Exception e) {
            log.error("payout error, reqDTO:{}",reqDTO, e);
        }
        return null;
    }

    /**
     * Order status query
     * @param reqDTO
     * @return
     */
    public VerifyStatusRespDTO verifyStatus(VerifyStatusReqDTO reqDTO){

        try {
            log.info("merchant request verifyStatus, reqParam:{}", JSON.toJSONString(reqDTO));
            // reset merchant id and key than clear reqDTO key
            // 重置商户id和key，然后清除reqDTO key
            APIKey apiKey = resetOrderQueryMchIdAndKey(reqDTO);

            ValidatorUtils.validate(reqDTO);
            ValidatorUtils.validate(apiKey);

            // Set request header
            Map<String, String> head = setHeader(CommonConstant.SERVICE_NAME, PayApiMehodEnum.verifyStatus.name(),
                    apiKey.getMchId(), apiKey.getMchKey(), JSON.toJSONString(reqDTO));

            // Request verifyStatus
            JSONObject rst = HttpUtil.post(payApiConfig.getApiUrl(), PayApiMehodEnum.verifyStatus, JSON.toJSONString(reqDTO), JSONObject.class, head);
            if (null == rst || !StrUtil.equals(BusinessCodeEnums.SUCCESS.getErrorCode(), (String) rst.get("resultCode"))) {
                log.error("merchant request verifyStatus, response data is null");
                return null;
            }
            Map dataMap = BeanUtil.toBean(JSONArray.parseArray(rst.getString("data")).get(0), Map.class);
            if (CollectionUtil.isEmpty(dataMap)) {
                log.error("merchant request verifyStatus, response data is null");
                return null;
            }
            return BeanUtil.toBean(dataMap, VerifyStatusRespDTO.class);

        } catch (ValidationException e) {
            log.error("verify status param error, reqDTO:{}",reqDTO, e);
        } catch (Exception e) {
            log.error("verify status error, reqDTO:{}",reqDTO, e);
        }
        return null;
    }

    /**
     * balance query
     * @param reqDTO
     * @return
     */
    public BalanceRespDTO balance(BalanceReqDTO reqDTO){

        try {
            log.info("merchant request balanceQuery, reqParam:{}", JSON.toJSONString(reqDTO));
            // reset merchant id and key than clear reqDTO key
            // 重置商户id和key，然后清除reqDTO key
            APIKey apiKey = resetBalanceMchIdAndKey(reqDTO);

            ValidatorUtils.validate(reqDTO);
            ValidatorUtils.validate(apiKey);

            Map<String, String> head = setHeader(CommonConstant.SERVICE_NAME, PayApiMehodEnum.balance.name(),
                    apiKey.getMchId(), apiKey.getMchKey(), JSON.toJSONString(reqDTO));

            JSONObject rst = HttpUtil.post(payApiConfig.getApiUrl(), PayApiMehodEnum.balance, JSON.toJSONString(reqDTO), JSONObject.class, head);
            if (null == rst || !StrUtil.equals(BusinessCodeEnums.SUCCESS.getErrorCode(), (String) rst.get("resultCode"))) {
                log.error("merchant request balance, response data is null");
                return null;
            }
            Map dataMap = BeanUtil.toBean(JSONArray.parseArray(rst.getString("data")).get(0), Map.class);
            if (CollectionUtil.isEmpty(dataMap)) {
                log.error("merchant request balance, response data is null");
                return null;
            }
            return BeanUtil.toBean(dataMap, BalanceRespDTO.class);

        } catch (ValidationException e) {
            log.error("balance query param error, reqDTO:{}",reqDTO, e);
        } catch (Exception e) {
            log.error("balance query error, reqDTO:{}",reqDTO, e);
        }
        return null;
    }

    /**
     * set request header
     * @param serviceName: 服务名称
     * @param method: 方法名称
     * @param mchId: 商户编号; 平台分配
     * @param mchKey: 商户key; 平台分配
     * @param body: 请求body
     * @return
     */
    private Map<String, String> setHeader(String serviceName, String method, String mchId, String mchKey, String body){
        Map<String, String> head = new HashMap<String, String>();
        String timestamp = String.valueOf(new Date().getTime());
        String signType = CommonConstant.SIGN_TYPE;
        head.put("mchId", mchId);
        head.put("serviceName", serviceName);
        head.put("method", method);
        head.put("signType", signType);
        head.put("timestamp", timestamp);
        head.put("sign", signature(mchId + serviceName + method + timestamp + signType + body, mchKey));
        return head;
    }

    /**
     * signature
     * @param signValue
     * @param mchKey
     * @return
     */
    public String signature(String signValue, String mchKey) {
        Digester d = DigestUtil.digester(DigestAlgorithm.SHA512);
        String sha512Hex = d.digestHex(signValue + mchKey);
        log.info("merchant request signature,old sgin:{},new sign:{}", signValue, sha512Hex);
        return sha512Hex;
    }

    /**
     * signature
     * @param signValue
     * @return
     */
    public String signature(String signValue) {
        Digester d = DigestUtil.digester(DigestAlgorithm.SHA512);
        String sha512Hex = d.digestHex(signValue + payApiConfig.getApikey());
        log.info("merchant request signature,old sgin:{},new sign:{}", signValue, sha512Hex);
        return sha512Hex;
    }

    public APIKey resetPayinMchIdAndKey(PayinReqDTO reqDTO) {
        APIKey apiKey = new APIKey();
        apiKey.setMchKey(payApiConfig.getApikey());
        if(StrUtil.isNotEmpty(reqDTO.getMchKey())){
            apiKey.setMchKey(reqDTO.getMchKey());
        }
        if(StrUtil.isNotEmpty(reqDTO.getMchId())){
            apiKey.setMchKey(reqDTO.getMchId());
        } else {
            apiKey.setMchId(payApiConfig.getMchId());
            reqDTO.setMchId(payApiConfig.getMchId());
        }
        reqDTO.setMchKey(null);
        return apiKey;
    }

    public APIKey resetPayoutMchIdAndKey(PayoutReqDTO reqDTO) {
        APIKey apiKey = new APIKey();
        apiKey.setMchKey(payApiConfig.getApikey());
        if(StrUtil.isNotEmpty(reqDTO.getMchKey())){
            apiKey.setMchKey(reqDTO.getMchKey());
        }
        if(StrUtil.isNotEmpty(reqDTO.getMchId())){
            apiKey.setMchKey(reqDTO.getMchId());
        } else {
            apiKey.setMchId(payApiConfig.getMchId());
            reqDTO.setMchId(payApiConfig.getMchId());
        }
        reqDTO.setMchKey(null);
        return apiKey;
    }

    public APIKey resetBalanceMchIdAndKey(BalanceReqDTO reqDTO) {
        APIKey apiKey = new APIKey();
        apiKey.setMchKey(payApiConfig.getApikey());
        if(StrUtil.isNotEmpty(reqDTO.getMchKey())){
            apiKey.setMchKey(reqDTO.getMchKey());
        }
        if(StrUtil.isNotEmpty(reqDTO.getMchId())){
            apiKey.setMchKey(reqDTO.getMchId());
        } else {
            apiKey.setMchId(payApiConfig.getMchId());
            reqDTO.setMchId(payApiConfig.getMchId());
        }
        reqDTO.setMchKey(null);
        return apiKey;
    }


    public APIKey resetOrderQueryMchIdAndKey(VerifyStatusReqDTO reqDTO) {
        APIKey apiKey = new APIKey();
        apiKey.setMchKey(payApiConfig.getApikey());
        if(StrUtil.isNotEmpty(reqDTO.getMchKey())){
            apiKey.setMchKey(reqDTO.getMchKey());
        }
        if(StrUtil.isNotEmpty(reqDTO.getMchId())){
            apiKey.setMchKey(reqDTO.getMchId());
        } else {
            apiKey.setMchId(payApiConfig.getMchId());
            reqDTO.setMchId(payApiConfig.getMchId());
        }
        reqDTO.setMchKey(null);
        return apiKey;
    }

}
