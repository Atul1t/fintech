package com.example.fintech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AuditFields {

    @Column(name = "CSTCL_EFCTV_DT")
    private LocalDate effectiveDate;

    @Column(name = "CSTCL_CRUD_VALUE")
    private char crudValue;

    @Column(name = "CSTCL_USER_ID", length = 100)
    private String userId;

    @Column(name = "CSTCL_WS_ID", length = 100)
    private String workstationId;

    @Column(name = "CSTCL_PRGM_ID", length = 100)
    private String programId;

    @Column(name = "CSTCL_HOST_TS")
    private LocalDateTime hostTimestamp;

    @Column(name = "CSTCL_LOCAL_TS")
    private LocalDateTime localTimestamp;

    @Column(name = "CSTCL_ACPT_TS")
    private LocalDateTime acceptanceTimestamp;

    @Column(name = "CSTCL_ACPT_TS_UTC_OFST")
    private LocalDateTime acceptanceUtcOffset;

    @Column(name = "CSTCL_UUID", length = 100)
    private String uuid;

    public LocalDate getEffectiveDate() { return effectiveDate; }
    public void setEffectiveDate(LocalDate effectiveDate) { this.effectiveDate = effectiveDate; }

    public char getCrudValue() { return crudValue; }
    public void setCrudValue(char crudValue) { this.crudValue = crudValue; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getWorkstationId() { return workstationId; }
    public void setWorkstationId(String workstationId) { this.workstationId = workstationId; }

    public String getProgramId() { return programId; }
    public void setProgramId(String programId) { this.programId = programId; }

    public LocalDateTime getHostTimestamp() { return hostTimestamp; }
    public void setHostTimestamp(LocalDateTime hostTimestamp) { this.hostTimestamp = hostTimestamp; }

    public LocalDateTime getLocalTimestamp() { return localTimestamp; }
    public void setLocalTimestamp(LocalDateTime localTimestamp) { this.localTimestamp = localTimestamp; }

    public LocalDateTime getAcceptanceTimestamp() { return acceptanceTimestamp; }
    public void setAcceptanceTimestamp(LocalDateTime acceptanceTimestamp) { this.acceptanceTimestamp = acceptanceTimestamp; }

    public LocalDateTime getAcceptanceUtcOffset() { return acceptanceUtcOffset; }
    public void setAcceptanceUtcOffset(LocalDateTime acceptanceUtcOffset) { this.acceptanceUtcOffset = acceptanceUtcOffset; }

    public String getUuid() { return uuid; }
    public void setUuid(String uuid) { this.uuid = uuid; }
}