package com.example.auditlogapi.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(indexName = "audit_log-*", type = "audit_log", createIndex = false)
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class AuditLog {

    @Id
    private String id;

    @Field(name = "account_id")
    @JsonProperty("account_id")
    private String accountId;

    private String action;

    @Field(name = "action_type")
    @JsonProperty("action_type")
    private String actionType;

    private String actor;

    @Field(name = "actor_type")
    @JsonProperty("actor_type")
    private String actorType;

    @Field(name = "admin_id")
    @JsonProperty("admin_id")
    private String adminId;

    private String affected;

    private String domain;

    private String scope;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActorType() {
        return actorType;
    }

    public void setActorType(String actorType) {
        this.actorType = actorType;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAffected() {
        return affected;
    }

    public void setAffected(String affected) {
        this.affected = affected;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "AuditLog{" + "id='" + id + '\'' + ", accountId='" + accountId + '\'' + ", action='" + action + '\''
                        + ", actionType='" + actionType + '\'' + ", actor='" + actor + '\'' + ", actorType='" + actorType + '\''
                        + ", adminId='" + adminId + '\'' + ", affected='" + affected + '\'' + ", domain='" + domain + '\''
                        + ", scope='" + scope + '\'' + '}';
    }
}
