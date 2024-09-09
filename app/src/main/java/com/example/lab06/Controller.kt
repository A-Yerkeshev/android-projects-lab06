package com.example.lab06

import Classworks.cw06_09.ParliamentMember

object Controller {
    fun getParliamentMember(hetekaId: Int? = null): ParliamentMember? {
        return if (hetekaId != null) {
            ParliamentMembersData.members.find { it.hetekaId == hetekaId }
        } else {
            ParliamentMembersData.members.random()
        }
    }
}