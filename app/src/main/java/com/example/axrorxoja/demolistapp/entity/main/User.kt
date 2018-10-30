package com.example.axrorxoja.demolistapp.entity.main

import com.squareup.moshi.Json

/*
* Created by axrorxoja on 10/30/18
*/
/*
* {
login: "",
name: "Aleksandr800",
nick: "Aleksandr800",
iurl: "http://dating.mts.by//dating-images-by/web/images/f4/4f/68/92/00/92/55/7a/f44f68920092557a51611ff6f753e67d_100_100_new_square.jpg",
online: false,
age: "29 лет",
city: "г. Гродно",
aim: "Цель знакомства: Любовь, Страсть, Брак",
moderator: false,
lastVisit: "23.08.2018",
sex: 1
}*/

class User(
    val login: String = "",
    val name: String = "",
    val nick: String = "",
    val iurl: String = "",
    val iurl_600: String = "",
    val iurl_200: String = "",
    val online: Boolean = false,
    val pcnt: Int = 0,
    val age: String = "",
    val city: String = "",
    val aim: String = "",
    @field:Json(name = "photo_id") val photoId: Int = 0,
    val moderator: Boolean = false,
    val lastVisit: String = "",
    val sex: Int = 0
)