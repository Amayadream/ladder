package com.amayadream.i18n.controller;

import com.amayadream.i18n.util.I18nHelper;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * @author :  Amayadream
 * @date :  2017.11.08 20:58
 */
@RestController
@RequestMapping(value = "/sample")
public class SampleController {

    @Resource
    private MessageSource messageSource;

    @RequestMapping(value = "")
    public String hello(@RequestParam(defaultValue = "Amayadream") String name) {
        I18nHelper.Builder builder = new I18nHelper.Builder()
                .append(name);

        System.out.println(I18nHelper.getMessage(messageSource, "welcome.message", builder, Locale.US));

        return I18nHelper.getMessage(messageSource, "welcome.message", builder);
    }

}
