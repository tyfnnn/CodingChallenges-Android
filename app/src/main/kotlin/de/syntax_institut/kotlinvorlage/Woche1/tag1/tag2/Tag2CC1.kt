package de.syntax_institut.kotlinvorlage.Woche1.tag1.tag2

fun main() {
    println("Tag 2 - Coding Challenge 1")

    val einkaufsliste = mutableListOf<String>()

    einkaufsliste.add("Äpfel")
    einkaufsliste.add("Bananen")
    einkaufsliste.add("Milch")

    print("Ungeordnete Einkaufsliste: $einkaufsliste")

    val geordneteEinkaufsliste = einkaufsliste.sort()

    print("Geordnete Einkaufsliste: $geordneteEinkaufsliste")

    val sortiment = mapOf(
        "Äpfel" to 1.00,
        "Bananen" to 0.50,
        "Milch" to 1.20
    )

    val alleProdukteVorhanden = einkaufsliste.all { produkt ->
        sortiment.containsKey(produkt)
    }

    if (alleProdukteVorhanden) {
        println("Alle Produkte aus der Einkaufsliste sind im Sortiment vorhanden.")
    } else {
        println("Nicht alle Produkte aus der Einkaufsliste sind im Sortiment vorhanden.")
    }

    val preisFuerBananen = sortiment["Bananen"]

    if (preisFuerBananen != null) {
        println("Der Preis für Bananen beträgt: $preisFuerBananen")
    } else {
        println("Bananen sind nicht im Sortiment vorhanden.")
    }
}