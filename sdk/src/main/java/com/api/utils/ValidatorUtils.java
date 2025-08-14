package com.api.utils;

import cn.hutool.core.util.StrUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Set;

/**
 * Hibernate Validator 校验工具
 */
@Component
public class ValidatorUtils implements ApplicationContextAware {

    /**
     * 通过Spring获得校验器
     * Get the validator through Spring
     */
    private static Validator validator;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        Validator validatorBean = applicationContext.getBean(Validator.class);
        setValidator(validatorBean);
    }

    public static void setValidator(Validator validatorBean) {
        // 解包装为原生Validator，支持forExecutables
        // Unwrap to the native Validator with forExecutables support
        if (validatorBean instanceof LocalValidatorFactoryBean) {
            validator = ((LocalValidatorFactoryBean) validatorBean).getValidator();
        } else if (validatorBean instanceof SpringValidatorAdapter) {
            validator = validatorBean.unwrap(Validator.class);
        } else {
            validator = validatorBean;
        }
    }

    /**
     * 对配置了注解的对象进行校验
     * Check the objects that configure the annotation
     */
    public static <T> void validate(T object) {
        Set<ConstraintViolation<T>> violationSet = validator.validate(object);
        for (ConstraintViolation<T> violation : violationSet) {
            // 快速返回第一个校验失败的数据
            // Quickly return the first data that fails the verification
            throw new ValidationException(violation.getPropertyPath() + StrUtil.SPACE + violation.getMessage());
        }
    }

    /**
     * 对配置了注解的对象进行校验，分组校验
     * Check the objects that configure the annotation, and the group verification
     */
    public static <T> void validate(T object, Class<?>... groupClass) {
        Set<ConstraintViolation<T>> violationSet = validator.validate(object, groupClass);
        for (ConstraintViolation<T> violation : violationSet) {
            // 快速返回第一个校验失败的数据
            // Quickly return the first data that fails the verification
            throw new ValidationException(violation.getPropertyPath() + StrUtil.SPACE + violation.getMessage());
        }
    }
}