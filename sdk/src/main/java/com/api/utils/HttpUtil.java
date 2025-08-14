/**  
 * All rights Reserved, Designed By Jonas
 * @Title:  HttpUtils.java   
 * @Package com.api.utils
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: Jonas     
 * @date:   2021年6月22日 上午10:05:02   
 * @version V1.0 
 * @Copyright: 2021 Jonas Inc. All rights reserved. 
 * 
 */ 
package com.api.utils;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.Method;
import cn.hutool.json.JSONUtil;
import com.api.enums.BusinessCodeEnums;
import com.api.enums.PayApiMehodEnum;
import com.api.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class HttpUtil {

    /**
     * 不含有headers和method
     * @param url
     * @param method
     * @param params
     * @param result
     * @return
     * @param <R>
     */
    public static <R> R post(String url, PayApiMehodEnum method, String params, Class<R> result) {
        return post(url, method, params, result, null, null);
    }

    /**
     * 不含method请求
     * @param url
     * @param method
     * @param params
     * @param result
     * @param headers
     * @return
     * @param <R>
     */
    public static <R> R post(String url, PayApiMehodEnum method, String params, Class<R> result, Map<String, String> headers) {
        return post(url, method, params, result, headers, null);
    }

    /**
     * 网关请求
     * Gateway request
     * @param url
     * @param method
     * @param params
     * @param result
     * @param headers
     * @param m
     * @return
     * @param <R>
     */
    public static <R> R post(String url, PayApiMehodEnum method, String params, Class<R> result, Map<String, String> headers, Method m) {
        try {
            log.info("=====> send req to pay call method:{} ,url:{}, params :{}", method, url, params);
            HttpRequest req = new HttpRequest(url);
            req.method(Method.POST);
            if(null != m) {
                req.method(m);
            }
            if(null != headers) {
                req.addHeaders(headers);
            }
            req.body(params);
            HttpResponse response = req.execute();
            String resultString = response.body();

            log.info("<===== get resp from pay call method:{}, url:{}, result:{} {} {}", method, url, resultString, response.getStatus(), response.header("requestId"));
            if(StrUtil.isEmpty(resultString) || null == result) {
                return null;
            }

            return JSONUtil.toBean(resultString, result);
        } catch (IORuntimeException ce) {
            log.error("<===== get resp from pay call method:{}, url:{}, connect exception:{}", url, ce);
            throw new BusinessException(BusinessCodeEnums.NETWORK_ERR);
        } catch (Exception e) {
            log.error("<===== get resp from pay call method:{}, url:{}, exception:{}", method, url, e);
            throw new BusinessException(BusinessCodeEnums.SYSTEM_ERR);
        }
    }

}
