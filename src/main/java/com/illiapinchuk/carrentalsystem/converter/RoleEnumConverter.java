package com.illiapinchuk.carrentalsystem.converter;

import com.illiapinchuk.carrentalsystem.model.RoleName;
import org.springframework.core.convert.converter.Converter;

public class RoleEnumConverter implements Converter<String, RoleName> {
    @Override
    public RoleName convert(String source) {
        return RoleName.valueOf(source);
    }
}
