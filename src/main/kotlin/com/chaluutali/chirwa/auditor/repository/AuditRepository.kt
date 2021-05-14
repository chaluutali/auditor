package com.chaluutali.chirwa.auditor.repository

import com.chaluutali.chirwa.auditor.dto.Audit
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AuditRepository: CrudRepository<Audit,UUID> {
    fun findByAccountNumber(accountNumber: String): Audit
}