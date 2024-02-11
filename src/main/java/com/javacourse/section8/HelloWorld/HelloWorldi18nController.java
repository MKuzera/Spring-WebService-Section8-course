package com.javacourse.section8.HelloWorld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldi18nController {
    private MessageSource messageSource;
    public HelloWorldi18nController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @GetMapping(value = "/hello-world-i18n")
    public String getI18Npage(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("hello.world.message",null,"Default",locale);
    }
}
