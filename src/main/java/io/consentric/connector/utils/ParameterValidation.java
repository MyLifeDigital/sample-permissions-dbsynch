package io.consentric.connector.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.InvalidPropertyException;

public class ParameterValidation {
    public static void verifyParamNotEmpty(String paramName, String paramValue, Class target) {
        if (StringUtils.isEmpty(paramValue)) {
            throw new InvalidPropertyException(target, paramName, "Cannot be empty");
        }
    }
}
