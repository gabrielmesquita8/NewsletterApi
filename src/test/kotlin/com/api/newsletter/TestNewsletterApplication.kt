package com.api.newsletter

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<NewsletterApplication>().with(TestcontainersConfiguration::class).run(*args)
}
