package com.neweltechnologies.portfolio.config.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PFMSLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger(PFMSLogger.class);

    public static void logInfo(String message) {
        String callerClassName = getCallerClassName();
        LOGGER.info("[" + callerClassName + "] " + message);
    }

    public static void logError(String message, Throwable throwable) {
        String callerClassName = getCallerClassName();
        LOGGER.error("[" + callerClassName + "] " + message, throwable);
    }

    private static String getCallerClassName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 1; i < stackTrace.length; i++) {
            StackTraceElement element = stackTrace[i];
            if (!element.getClassName().equals(PFMSLogger.class.getName())) {
                return element.getClassName();
            }
        }
        return "Unknown";
    }
}
