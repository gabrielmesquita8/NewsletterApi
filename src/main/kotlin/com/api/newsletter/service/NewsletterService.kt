package com.api.newsletter.service

import com.api.newsletter.model.Newsletter
import com.api.newsletter.repository.NewsletterRepository
import com.api.newsletter.repository.SubscriberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class NewsletterService(
        private val newsletterRepository: NewsletterRepository,
        private val subscriberRepository: SubscriberRepository,
        private val emailService: EmailService
) {

    fun createNewsletter(newsletter: Newsletter): Newsletter {
        return newsletterRepository.save(newsletter)
    }

    fun getAllNewsletter(): List<Newsletter> {
        return newsletterRepository.findAll()
    }

    @Transactional
    fun sendNewsletter(id: Long) {
        val newsletter = newsletterRepository.findById(id).orElseThrow {
            throw IllegalArgumentException("Newsletter with ID $id not found")
        }

        val subscribers = subscriberRepository.findByIsActiveTrue()

        if (subscribers.isEmpty()) {
            throw IllegalStateException("No active subscribers found")
        }

        subscribers.forEach { subscriber ->
            emailService.sendEmail(subscriber.email, newsletter.title, newsletter.content)
        }
    }
}