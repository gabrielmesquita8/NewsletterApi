package com.api.newsletter.controller

import com.api.newsletter.model.Subscriber
import com.api.newsletter.service.SubscriberService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/subscriber")
class SubscriberController(private val subscriberService: SubscriberService) {

    @PostMapping
    fun addSubscriber(@RequestBody subscriber: Subscriber): ResponseEntity<Subscriber> {
        val savedSubscriber = subscriberService.addSubscriber(subscriber)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSubscriber)
    }

    @GetMapping
    fun getAllSubscribers(): ResponseEntity<List<Subscriber>> {
        val subscribers = subscriberService.getAllSubscribers()
        return ResponseEntity.ok(subscribers)
    }

    @GetMapping("/findByEmail/{email}")
    fun getSubscriberByEmail(@PathVariable email: String): ResponseEntity<Subscriber> {
        val subscriber = subscriberService.findSubscriberByEmail(email)
        return if (subscriber != null) {
            ResponseEntity.ok(subscriber)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @DeleteMapping("/deleteSubscriber/{email}")
    fun deleteSubscriber(@RequestParam email: String): ResponseEntity<Void> {
        return if (subscriberService.deleteSubscriberByEmail(email)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}