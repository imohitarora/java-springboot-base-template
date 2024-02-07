package com.neweltechnologies.portfolio.config.audit;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class AuditService {
    private final AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public void audit(String entityName, Long entityId, String action, String username) {
        Audit audit = new Audit();
        audit.setEntityName(entityName);
        audit.setEntityId(entityId);
        audit.setAction(action);
        audit.setTimestamp(LocalDateTime.now());
        audit.setUsername(username);
        auditRepository.save(audit);
    }
}
