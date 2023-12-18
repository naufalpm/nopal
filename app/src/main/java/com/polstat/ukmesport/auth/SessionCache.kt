package com.polstat.ukmesport.auth

interface SessionCache {

    fun saveSession(session: Session)

    fun getActiveSession(): Session?

    fun clearSession()
}
