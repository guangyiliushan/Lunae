package pers.guang.lunae

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform