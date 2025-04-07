package de.syntax_institut.kotlinvorlage.Woche1.tag1.tag3

fun main() {
    println("Tag 3 - Coding Challenge 1")

    fun isIdealHumidity(humidity: Int): Boolean {
        return humidity in 40..60
    }

    print(isIdealHumidity(50))

    fun isIdealTemperature(temperature: Int): Boolean {
        return temperature in 20..25
    }

    print(isIdealTemperature(22))
}


