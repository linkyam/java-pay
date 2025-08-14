package com.api.strategy;

import com.api.api.*;
import com.api.dto.common.req.PayinReqDTO;
import com.api.dto.common.req.PayoutReqDTO;
import com.api.dto.common.resp.PayinRespDTO;
import com.api.enums.CurrencyEnum;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PayinStrategy
 * @Description 策略类
 * @Author Andy
 * @Date 2024/9/2 11:43
 */
@Component
public class StrategyFactory {

    // 策略映射
    // Strategy mapping
    private static final Map<String, Strategy> strategies = new HashMap<>();

    // 通过策略映射，可以根据不同的货币类型，选择不同的策略
    // Through strategic mapping, you can follow different currency types, select different strategies
    static {
        strategies.put(CurrencyEnum.BRL.name(), new BRLApiUtils());
        strategies.put(CurrencyEnum.MXN.name(), new MXNApiUtils());
        strategies.put(CurrencyEnum.AED.name(), new AEDApiUtils());
        strategies.put(CurrencyEnum.CLP.name(), new CLPApiUtils());
        strategies.put(CurrencyEnum.COP.name(), new COPApiUtils());
        strategies.put(CurrencyEnum.ECS.name(), new ECSApiUtils());
        strategies.put(CurrencyEnum.IDR.name(), new IDRApiUtils());
        strategies.put(CurrencyEnum.INR.name(), new INRApiUtils());
        strategies.put(CurrencyEnum.KES.name(), new KESApiUtils());
        strategies.put(CurrencyEnum.MYR.name(), new MYRApiUtils());
        strategies.put(CurrencyEnum.NGN.name(), new NGNApiUtils());
        strategies.put(CurrencyEnum.PEN.name(), new PENApiUtils());
        strategies.put(CurrencyEnum.PHP.name(), new PHPApiUtils());
        strategies.put(CurrencyEnum.THB.name(), new THBApiUtils());
        strategies.put(CurrencyEnum.TZS.name(), new TZSApiUtils());
        strategies.put(CurrencyEnum.USD.name(), new USDApiUtils());
        strategies.put(CurrencyEnum.ZAR.name(), new ZARApiUtils());
        strategies.put(CurrencyEnum.VISA.name(), new VISAApiUtils());
    }
    // 构造函数是私有的，防止外部直接实例化
    private StrategyFactory() {
    }

    public static PayinRespDTO convertProcess(Map<String, Object> dataMap, String currency) {
        Strategy service = strategies.get(currency);
        if (service != null) {
            return service.convertPayinRespDTO(dataMap);
        }
        throw new IllegalArgumentException("Unsupported currency: " + currency);
    }

    public static String convertProcess(PayinReqDTO reqDTO, String currency) {
        Strategy service = strategies.get(currency);
        if (service != null) {
            return service.convertPayinJsonString(reqDTO);
        }
        throw new IllegalArgumentException("Unsupported currency: " + currency);
    }

    public static String convertProcess(PayoutReqDTO reqDTO, String currency) {
        Strategy service = strategies.get(currency);
        if (service != null) {
            return service.convertPayoutJsonString(reqDTO);
        }
        throw new IllegalArgumentException("Unsupported currency: " + currency);
    }
}
