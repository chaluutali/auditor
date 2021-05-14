package com.chaluutali.chirwa.auditor.service

import com.chaluutali.chirwa.auditor.dto.Audit
import com.chaluutali.chirwa.auditor.repository.AuditRepository
import io.leangen.graphql.annotations.GraphQLArgument
import io.leangen.graphql.annotations.GraphQLMutation
import io.leangen.graphql.annotations.GraphQLQuery
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@GraphQLApi
@Service
class AuditingService(@Autowired private val auditRepository: AuditRepository) {

    @GraphQLMutation(name = "addAudit")
    fun addAudit(@GraphQLArgument(name = "audit") audit: Audit) {
        auditRepository.save(audit)
    }

    @GraphQLQuery(name = "retrieveAudit")
    fun retrieveAudit(@GraphQLArgument(name = "accountNumber") accountNumber: String): Audit? {
        return auditRepository.findByAccountNumber(accountNumber)
    }
}