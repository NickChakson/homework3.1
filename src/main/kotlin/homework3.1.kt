fun main() {

    val userTimeAgo: Int
    print("Сколько минут назад Руслан Гительман был в сети?: ")
    val userTimeAgoInput: Int = readln().toInt()
    userTimeAgo = userTimeAgoInput * 60
    agoToText(userTimeAgo)
}

fun agoToText(userTimeAgo: Int) {
    return when {
        userTimeAgo in 1..60 -> print("Был(-а) на сайте только что")
        userTimeAgo in 61..3600 -> {
            val min = userTimeAgo / 60
            print("Был(-а) на сайте $min ${textMin(userTimeAgo)} назад")
        }
        userTimeAgo in 3601..86400 -> {
            val hours: Int = userTimeAgo / 60 / 60
            print("Был(-а) на сайте $hours ${textHours(userTimeAgo)} назад")
        }
        userTimeAgo in 86401..172800 -> print("Был(-а) на сайте сегодня")
        userTimeAgo in 172801..259200 -> print("Был(-а) на сайте вчера")
        userTimeAgo > 259201 -> return print("Был(-а) на сайте давно")
        else -> {
            print("Ошибка")
        }
    }
}

fun textMin(userTimeAgo: Int): String {
    val min: Int = userTimeAgo / 60
    return when {
        min % 10 == 1 && min % 100 != 11 -> "минута"
        (min % 10 == 2 || min % 100 == 22) && min % 100 != 12 -> "минуты"
        (min % 10 == 3 || min % 100 == 33) && min % 100 != 13 -> "минуты"
        (min % 10 == 4 || min % 100 == 44) && min % 100 != 14 -> "минуты"
        else -> {
            "минут"
        }
    }
}

fun textHours(userTimeAgo: Int): String {
    val hours: Int = userTimeAgo / 60 / 60
    return when {
        hours % 10 == 1 && hours % 100 != 11 -> "час"
        (hours % 10 == 2 || hours % 100 == 22) && hours % 100 != 12 -> "часа"
        (hours % 10 == 3 || hours % 100 == 33) && hours % 100 != 13 -> "часа"
        (hours % 10 == 4 || hours % 100 == 44) && hours % 100 != 14 -> "часа"
        else -> {
            "часов"
        }
    }
}