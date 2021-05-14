package com.chaluutali.chirwa.auditor.dto

import lombok.Builder
import java.sql.Timestamp
import java.util.*
import javax.persistence.*

@Builder
@Entity
@Table(name = "audit", schema = "bank")
data class Audit(
    @Id
    val auditID: UUID,
    val auditorTimestamp: Timestamp,
    val auditAction: String,
    val accountNumber: String
    )
