package com.amayadream.i18n.util;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author :  Amayadream
 * @date :  2017.11.08 21:20
 */
public class I18nHelper {

    public static String getMessage(MessageSource messageSource, String key) {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }

    public static String getMessage(MessageSource messageSource, String key, Locale locale) {
        return messageSource.getMessage(key, null, locale);
    }

    public static String getMessage(MessageSource messageSource, String key, Builder builder, Locale locale) {
        if (CollectionUtils.isEmpty(builder.params)) {
            return getMessage(messageSource, key, locale);
        }
        return messageSource.getMessage(key, builder.params.toArray(), locale);
    }

    public static String getMessage(MessageSource messageSource, String key, Builder builder) {
        return getMessage(messageSource, key, builder, LocaleContextHolder.getLocale());
    }

    public static class Builder {

        private List<Object> params = new ArrayList<>();

        public Builder append(Object param) {
            params.add(param);
            return this;
        }

    }


}
