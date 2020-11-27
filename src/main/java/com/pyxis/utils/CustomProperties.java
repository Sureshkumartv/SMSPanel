package com.pyxis.utils;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "uploads")
@Component
public class CustomProperties {

    private String stringProp1;
    private String stringProp2;
   
}
