package com.api.enums;

import com.api.exception.ErrorCode;
import com.api.exception.IError;

import java.lang.reflect.Field;

public class BusinessCodeEnums {
    public static final IError SUCCESS = new ErrorCode("000000", "success");
    public static final IError PARAMS_ILLEGAL = new ErrorCode("100000", "%s is illegal");
    public static final IError SYSTEM_ERR = new ErrorCode("999999", "System error");
    public static final IError NETWORK_ERR = new ErrorCode("999998", "Network error");
    public static final IError PARAMS_ERR = new ErrorCode("999997", "Params are wrong");
    public static final IError SIGN_ERR = new ErrorCode("999996", "Sign is invalid");
    public static final IError ONE_PARAMS_ERR = new ErrorCode("999995", "%s is wrong");
    public static final IError BUSINESS_ERR = new ErrorCode("999994", "Business error");

    /**非法请求参数*/
    public static final IError ILLEGAL_REQ = new ErrorCode("999993", "Illegal requested parameters");
    /**数字验签失败*/
    public static final IError SIGN_FAILURE = new ErrorCode("999992", "Digital signature check failure");
    /**非法的服务名称*/
    public static final IError UNAUTH_SERVICE = new ErrorCode("999991", "Unauthorized service");
    /**非法的数据类型*/
    public static final IError ILLEGAL_DATA = new ErrorCode("999990", "Illegal data types");
    /**合作伙伴信息不存在*/
    public static final IError MCH_NOT_EXIST = new ErrorCode("999989", "Mch information does not exist");
    /**非法的请求方法*/
    public static final IError ILLEGAL_METHOD = new ErrorCode("999988", "Illegal request method");
    /**编码不正确*/
    public static final IError INCORRECT_CODE = new ErrorCode("999987", "Incorrect coding");
    /**缺失签名*/
    public static final IError SIGN_MISS = new ErrorCode("999986", "Sign is missed");
    /**签名类型*/
    public static final IError SIGN_TYPE_MISS = new ErrorCode("999985", "Sign type is missed");
    /**商户编号*/
    public static final IError MCHID_MISS = new ErrorCode("999984", "MchId is missed");
    /**时间戳*/
    public static final IError TIMESTAMP_MISS = new ErrorCode("999983", "Timestamp is missed");
    /**签名类型非法*/
    public static final IError ILLEGAL_SIGN_TYPE = new ErrorCode("999982", "Sign type is illegal");
    /**AES256*/
    public static final IError AES_256_DERR = new ErrorCode("999981", "AES256 decrypt error");
    public static final IError AES_256_EERR = new ErrorCode("999980", "AES256 encrypt error");
    /**方法不存在**/
    public static final IError NO_METHOD = new ErrorCode("999979", "Method not exist");
    /**VO不存在**/
    public static final IError VO_MISS = new ErrorCode("999978", "VO is missed");
    public static final IError ILLEGAL_PRO_IP = new ErrorCode("999977", "illegal pro ip %s");
    public static final IError ILLEGAL_TEST_IP = new ErrorCode("999976", "illegal test ip");
    /**无可用商户*/
    public static final IError ENABLE_MCH_NOT_EXIST = new ErrorCode("999975", "no enable mch");
    public static final IError ENABLE_MCH_PAYIN_NOT_EXIST = new ErrorCode("889975", "no enable mch payin");
    public static final IError ENABLE_MCH_PAYOUT_NOT_EXIST = new ErrorCode("889976", "no enable mch payout");


    public static final IError ILLEGAL_MCH_IP = new ErrorCode("999974", "illegal mch ip %s");
    public static final IError GET_IS_NOT_SUPPORT = new ErrorCode("999973", "'GET' not supported");
    public static final IError ILLEGAL_MCH_CURRENCY = new ErrorCode("999972", "illegal mch currency %s");

    public static final IError HIT_IN_AMT_LIMIT = new ErrorCode("999971", "merchant payin order amount exceed the limit");
    public static final IError HIT_IN_DAY_AMT_LIMIT = new ErrorCode("999970", " the merchant's payin orders amount in a day exceed the limit ");
    public static final IError HIT_IN_DAY_CNT_LIMIT = new ErrorCode("999969", "the merchant's payin orders count in a day exceed the limit ");
    public static final IError HIT_OUT_AMT_LIMIT = new ErrorCode("999968", "merchant payout order amount exceed the limit");
    public static final IError HIT_OUT_DAY_AMT_LIMIT = new ErrorCode("999967", "the merchant's payout orders amount in a day exceed the limit ");
    public static final IError HIT_OUT_DAY_CNT_LIMIT = new ErrorCode("999966", "'the merchant's payout orders count in a day exceed the limit ");
    public static final IError HIT_BALANCE_LIMIT = new ErrorCode("999965", "'the merchant's balance has reach the balance limit, please make some payout orders. ");

    public static final IError ORDER_TIMEOUT = new ErrorCode("999964", "order is timeout or not exist, please post request after create order successfully in five minutes.");
    public static final IError DATA_IS_NULL = new ErrorCode("999963", "request data is null.");
    public static final IError DATA_IS_NOT_JSON = new ErrorCode("999962", "request data is not a json.");

    public static final IError QUERY_LIMIT_ERR = new ErrorCode("999961", "%s Query exceed limit, %s times in one second.");
    public static final IError ADD_ORDER_QUERY_ERR = new ErrorCode("999960", "%s add query order or accounting error.");
    public static final IError USER_IS_BLACKLIST = new ErrorCode("999959", "%s is in blacklist.");
    public static final IError BANK_SSL_ERROR = new ErrorCode("999958", "bank request ssl error.");
    public static final IError REQUEST_MERCHANT_TIME_OUT = new ErrorCode("999957", "request merchant time out.");


    /**
     * ======================================= 渠道参数异常 ============= 业务异常 =======================================
     */
    public static final IError MCH_REFUND_OVER_TIMES = new ErrorCode("400001", "refund times over limit, please contact the customer service.");

    public static final IError ORDER_TYPE_IS_ERROR = new ErrorCode("400002", "order type is not correct.");
    public static final IError ORDER_SUBMIT_FAST = new ErrorCode("400003", "order submit fast.");
    public static final IError MERCHANT_NOT_ENOUGH_BALANCE = new ErrorCode("400004", "merchant account not enough balance.");


    public static final IError REFUND_ERROR = new ErrorCode("400005", "refund error, please contact the customer service.");


    /**
     * ======================================= 渠道参数异常 ============= 系统参数异常 =======================================
     */
    public static final IError DB_UPDATE_ERROR = new ErrorCode("500001", "db update error! 【%s】");
    public static final IError BANK_BALANCE_QUERY_FAILED = new ErrorCode("500002", "bank balance query failed!");


    /**
     * ======================================= 渠道参数异常 ============= 渠道参数异常 =======================================
     */
    public static final IError BRL_PAYOUT_PIX_ERROR = new ErrorCode("800001", "%s pix is error,please checked.");

    public static final IError BRL_PAYOUT_PIX_BLOCK = new ErrorCode("800002", "%s pix is blocked,please checked.");

    public static final IError CALLBACK_SIGN_FAILURE = new ErrorCode("999959", "%s callback signature check failure.");

    public static final IError PAYMENT_CHECKOUT_RETRY_ERROR = new ErrorCode("999958", "Please try again later.");

    public static final IError PAYMENT_CHECKOUT_ERROR = new ErrorCode("999957", "create order error,please contact the customer service.");

    public static final IError PAYMENT_REQUEST_ERROR = new ErrorCode("999956", "payment request error.");

    public static final IError ORDER_IS_NO_EXISTS_ERROR = new ErrorCode("999955", "order is not exists.");

    public static final IError ORDER_EXPIRED_ERROR = new ErrorCode("999954", "order is expired.");
    public static final IError SESSION_EXPIRED_ERROR = new ErrorCode("999953", "session is expired.");

    public static final IError SYS_FORBBIDEN_PAYIN_ERROR = new ErrorCode("999952", "merchant payin is forbidden.");
    public static final IError SYS_FORBBIDEN_PAYOUT_ERROR = new ErrorCode("999951", "merchant payout is forbidden.");
    public static final IError METHOD_NOT_SUPPORT = new ErrorCode("999950", "domain not support methodType.");
    public static final IError INSUFFICIENT_BALANCE = new ErrorCode("999951", "Insufficient balance");

    public IError toBusinessError(String code) {
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for(Field f : fields) {
                ErrorCode ec = (ErrorCode)f.get(new ErrorCode());
                if(ec.getErrorCode().equals(code)) {
                    return ec;
                }
            }
            return new ErrorCode(BusinessCodeEnums.SYSTEM_ERR.getErrorCode(), code);
        } catch (Exception e) {
            return new ErrorCode(BusinessCodeEnums.SYSTEM_ERR.getErrorCode(), code);
        }
    }
}
