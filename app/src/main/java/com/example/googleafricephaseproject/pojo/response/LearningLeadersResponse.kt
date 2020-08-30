package com.example.googleafricephaseproject.pojo.response

class LearningLeadersResponse : ArrayList<LearningLeadersResponseItem>()

data class LearningLeadersResponseItem(
    val badgeUrl: String,
    val country: String,
    val hours: Int,
    val name: String
)