/**  
 * All rights Reserved, Designed By Jonas
 * @Title:  PayuApiMehod.java   
 * @Package com.api.service.bank.form
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: Jonas     
 * @date:   2021年6月16日 下午4:43:15   
 * @version V1.0 
 * @Copyright: 2021 Jonas Inc. All rights reserved. 
 * 
 */ 
package com.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Api method enum
 * English doc: https://documenter.getpostman.com/view/10814992/2s93Y3wMc8
 * 中文文档: https://documenter.getpostman.com/view/10814992/2s93XyTNoA
 *
 */
@Getter
@AllArgsConstructor
public enum PayApiMehodEnum {

    pay("create order api/创建订单接口"),

    payOut("create payout api/创建支付接口"),

    verifyStatus("query order status api/查询订单状态接口"),

    balance("query balance api/查询余额接口"),
    ;

    private String remark;
}
