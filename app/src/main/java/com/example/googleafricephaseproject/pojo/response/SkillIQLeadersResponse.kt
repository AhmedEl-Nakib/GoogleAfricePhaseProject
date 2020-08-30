package com.example.googleafricephaseproject.pojo.response

class SkillIQLeadersResponse : ArrayList<SkillIQLeadersResponseItem>()

data class SkillIQLeadersResponseItem(
    val badgeUrl: String,
    val country: String,
    val name: String,
    val score: Int
)