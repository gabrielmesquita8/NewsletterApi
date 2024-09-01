package com.api.newsletter.service

import com.api.newsletter.model.Subscriber
import com.api.newsletter.repository.SubscriberRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class SubscriberService(private val subscriberRepository: SubscriberRepository) {
    fun addSubscriber(subscriber: Subscriber): Subscriber {
        return subscriberRepository.save(subscriber)
    }

    fun findSubscriberByEmail(email: String): Subscriber? {
        return subscriberRepository.findByEmail(email)
    }

    fun getAllSubscribers(): List<Subscriber> {
        return subscriberRepository.findAll()
    }

    @Transactional
    fun deleteSubscriberByEmail(email: String): Boolean {
        val deletedCount = subscriberRepository.deleteByEmail(email)
        return deletedCount > 0
    }
}