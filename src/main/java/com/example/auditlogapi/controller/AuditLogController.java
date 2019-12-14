package com.example.auditlogapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auditlogapi.domain.AuditLog;
import com.example.auditlogapi.repository.AuditLogRepository;

@RestController
@RequestMapping("/v1/audit-log")
public class AuditLogController {
    private final AuditLogRepository auditLogRepository;

    @Autowired
    public AuditLogController(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @GetMapping("/all")
    public Page<AuditLog> findAll(Pageable pageable) {
        return auditLogRepository.findAll(pageable);
    }

    @GetMapping("/{accountId}")
    public Page<AuditLog> findByAccountId(@PathVariable String accountId, Pageable pageable) {
        return auditLogRepository.findByAccountId(accountId, pageable);
    }

    @GetMapping("/{accountId}/{action}")
    public Page<AuditLog> findByAccountIdAndAction(@PathVariable String accountId, @PathVariable String action, Pageable pageable) {
        return auditLogRepository.findByAccountIdAndAction(accountId, action, pageable);
    }

    @GetMapping("/by-action/{action}")
    public Page<AuditLog> findByAction(@PathVariable String action, Pageable pageable) {
        return auditLogRepository.findByAction(action.toUpperCase(), pageable);
    }
}
