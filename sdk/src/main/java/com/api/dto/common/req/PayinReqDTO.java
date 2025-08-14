package com.api.dto.common.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PayinReqDTO {
    /**
     * 商户订单号
     */
    @NotEmpty
    private String mchOrderId;
    /**
     * 订单金额
     */
    @NotEmpty
    private String amount;
    /**
     * 订单币种
     */
    @NotEmpty
    private String currency;
    /**
     * 商品说明(长度最小1位最大100位)
     */
    private String productinfo;
    /**
     * 客户姓氏
     */
    private String firstname;
    /**
     * 客户名称
     */
    private String lastname;
    /**
     * 客户邮箱
     */
    private String email;
    /**
     * 客户手机号(最小6位最大20位) ：+525535571415
     */
    private String phone;
    /**
     * webhook 回调地址
     */
    private String callbackUrl;
    /**
     * 成功或失败后重定向地址
     */
    private String redirectUrl;
    /**
     * 如果不需要我们收银台页面，请填true会减少api请求耗时，然后响应的 checkoutUrl 参数会变成空
     */
    private String noPayPage;
    /**
     * 商户id,后管平台配置生成
     */
    @NotEmpty
    private String mchId;
    /**
     * 商户key, 后管平台配置生成
     */
    private String mchKey;
}
