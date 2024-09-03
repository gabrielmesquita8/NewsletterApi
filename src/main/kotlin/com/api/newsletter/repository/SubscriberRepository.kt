package com.api.newsletter.repository

import com.api.newsletter.model.Subscriber
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SubscriberRepository: JpaRepository<Subscriber, Long> {
    fun findByEmail(email: String): Subscriber?
    fun deleteByEmail(email: String): Int
    fun findByIsActiveTrue(): List<Subscriber>
}