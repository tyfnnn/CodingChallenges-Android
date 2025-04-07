package de.syntax_institut.kotlinvorlage.Woche1.tag1.tag3

fun main() {
    println("Tag 3 - Coding Challenge 2")

    fun aktiviereGeraet(geraeteName: String, aktion: () -> Unit) {
        println("$geraeteName wird aktiviert:")
        aktion()
    }

    aktiviereGeraet("Licht") { println("Licht wird aktiviert") }

    aktiviereGeraet("Fernseher") { println("Fernseher wird aktiviert") }

    aktiviereGeraet("Bewässerungsanlage") { println("Bewässerungsanlage wird aktiviert") }
}