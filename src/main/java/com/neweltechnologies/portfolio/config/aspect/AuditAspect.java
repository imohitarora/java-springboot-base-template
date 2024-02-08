package com.neweltechnologies.portfolio.config.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.neweltechnologies.portfolio.config.audit.AuditService;
import com.neweltechnologies.portfolio.config.audit.AuditTrail;

@Aspect
@Component
public class AuditAspect {

    private final AuditService auditService;

    public AuditAspect(AuditService auditService) {
        this.auditService = auditService;
    }

    @AfterReturning(value = "@annotation(audit)", returning = "result")
    public void afterReturning(JoinPoint joinPoint, AuditTrail audit, Object result) {
        String entityName = audit.entityName();
        String action = audit.action();
        String username = getUsername(); // Implement your method to get the username
        Long entityId = extractEntityId(joinPoint);
        auditService.audit(entityName, entityId, action, username);
    }

    // Method to extract entity ID from the method arguments or result
    private Long extractEntityId(JoinPoint joinPoint) {
        // Implement logic to extract entity ID if needed
        return null;
    }

    // Method to get current username
    private String getUsername() {
        // Implement logic to get current username
        return "anonymous"; // Example
    }
}
