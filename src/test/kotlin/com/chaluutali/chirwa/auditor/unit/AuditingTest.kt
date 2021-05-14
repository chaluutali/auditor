package com.chaluutali.chirwa.auditor.unit

import com.chaluutali.chirwa.auditor.dto.Audit
import com.chaluutali.chirwa.auditor.repository.AuditRepository
import com.chaluutali.chirwa.auditor.service.AuditingService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.*
import java.sql.Timestamp
import java.time.Instant
import java.util.*


class AuditingTest {

    private val auditRepository: AuditRepository = mock(AuditRepository::class.java)
    private val testAudit = Audit(UUID.randomUUID(), Timestamp.from(Instant.now()), "WITHDRAW", "0987654321" )
    private val auditingService = AuditingService(auditRepository)

    @Test
    fun testRetrieveAudit() {
        `when`(auditRepository.findByAccountNumber(anyString())).thenReturn(testAudit)
        val response = auditingService.retrieveAudit("0987654321")
        Assertions.assertNotNull(response)
        assertEquals("0987654321", response?.accountNumber)
        assertEquals("WITHDRAW", response?.auditAction)
    }

    @Test
    fun testAddAudit() {
        auditingService.addAudit(testAudit)
        verify(auditRepository,times(1)).save(any());
    }

}