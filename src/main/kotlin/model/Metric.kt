package com.lgw.model

import kotlinx.serialization.Serializable

@Serializable
data class Metric(
    val domain: String,
    val itemId: String,
    val userId: String,
    val timestamp: Long = System.currentTimeMillis()
)