package com.polstat.ukmesport.auth


data class LoginRequest(
    var email : String,
    var password : String,
) {
}
