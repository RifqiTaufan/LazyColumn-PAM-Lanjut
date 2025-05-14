package com.example.lazycolumn_pam_lanjut.model

sealed class Navigation(val route: String) {
    object UserList : Navigation("user_list")
    object UserDetail : Navigation("user_detail/{userId}") {
        fun createRoute(userId: Int) = "user_detail/$userId"
    }
}