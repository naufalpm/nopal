package com.polstat.ukmesport.auth

data class RegisterRequest(
    var name : String,
    var email : String,
    var password : String,
) {
}
