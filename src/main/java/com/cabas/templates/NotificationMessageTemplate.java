package com.cabas.templates;

import com.cabas.controller.dto.Severity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class NotificationMessageTemplate {

    // {{fullName}} replacement should be made in notification service to save HTTP traffic on the same data
    // Notifying areas may involve millions of 90%+ similar messages

    private static final Map<Severity, String> messages = new HashMap<>() {{
        put(Severity.GREEN, "Dear, {{fullName}}! City COVID status is green");
        put(Severity.YELLOW, "Dear, {{fullName}}! City COVID status is yellow");
        put(Severity.ORANGE, "Dear, {{fullName}}! City COVID status is orange");
        put(Severity.RED, "Dear, {{fullName}}! City COVID status is red");
    }};

    public String getMessageTemplate(Severity severity) {
        return messages.get(severity);
    }
}
