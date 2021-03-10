package ru.otus.mainpackage.welcome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.otus.mainpackage.configs.AppProps;

import javax.annotation.PostConstruct;

@Component
public class LocalHello {
    private static final Logger logger = LoggerFactory.getLogger(LocalHello.class);

    private final MessageSource messageSource;
    private final AppProps props;

    public LocalHello(MessageSource messageSource, AppProps props) {
        this.messageSource = messageSource;
        this.props = props;
    }

    //!!! Вообще, PostConstruct - это плохая практика !!!
    @PostConstruct
    public void printHello() {
        var message = messageSource.getMessage("hello.user", new String[]{"Ivan"}, props.getLocale());
        logger.info("Localization:{}", message);
    }
}
