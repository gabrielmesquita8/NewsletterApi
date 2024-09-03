package com.api.newsletter.controller

import com.api.newsletter.model.Newsletter
import com.api.newsletter.service.NewsletterService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/newsletter")
class NewsletterController(private val newsletterService: NewsletterService) {

    @PostMapping
    fun createNewsletter(@RequestBody newsletter: Newsletter): ResponseEntity<Newsletter> {
        val savedNewsletter = newsletterService.createNewsletter(newsletter)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNewsletter)
    }

    @GetMapping
    fun getAllNewsletter(): ResponseEntity<List<Newsletter>> {
        val newsletter = newsletterService.getAllNewsletter()
        return ResponseEntity.ok(newsletter)
    }

    @PostMapping("/send/{id}")
    fun sendNewsletter(@PathVariable id: Long): ResponseEntity<String> {
        newsletterService.sendNewsletter(id)
        return ResponseEntity.ok("Newsletter sent successfully")
    }
}