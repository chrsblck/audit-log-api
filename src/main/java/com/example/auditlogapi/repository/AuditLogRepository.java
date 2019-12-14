package com.example.auditlogapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.auditlogapi.domain.AuditLog;

@Repository
public interface AuditLogRepository extends ElasticsearchRepository<AuditLog, String> {
    Page<AuditLog> findByAction(String action, Pageable pageable);

    Page<AuditLog> findByAccountId(String accountId, Pageable pageable);

    Page<AuditLog> findByAccountIdAndAction(String accountId, String action, Pageable pageable);
}

