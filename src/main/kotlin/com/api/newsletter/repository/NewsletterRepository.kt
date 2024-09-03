package com.api.newsletter.repository

import com.api.newsletter.model.Newsletter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NewsletterRepository: JpaRepository<Newsletter, Long> {

}