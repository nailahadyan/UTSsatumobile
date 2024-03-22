package id.ac.pnm.ti.utsmobilesatu

fun main() {
    val liverpool = Club("Liverpool", 19, 8, 9, 6, 3)
    val manUnited = Club("Manchester United", 20, 12, 6, 3, 1)
    val chelsea = Club("Chelsea", 6, 6, 5, 2, 2)
    val manCity = Club("Manchester City", 8, 8, 8, 0, 0)
    val arsenal = Club("Arsenal", 13, 14, 2, 0, 0)

    val clubs = listOf(liverpool, manUnited, chelsea, manCity, arsenal)

    val sortedClubs = sortClubsByTotalTrophies(clubs)
    println("Klub-klub yang telah diurutkan berdasarkan jumlah total trofi:")
    sortedClubs.forEach { club ->
        println("${club.name}: ${club.totalTrophies}")
    }
    println("=".repeat(50)) // Garis pemisah

    val filteredClubs = filterClubs(clubs) { clubList ->
        clubList.filter { club ->
            club.championsLeague == 0 && club.europaLeague == 0
        }
    }

    println("\nKlub-klub yang belum pernah memenangkan trofi Liga Champions dan Liga Eropa UEFA:")
    filteredClubs.forEach { club ->
        println(club.name)
    }
    println("=".repeat(50)) // Garis pemisah

    clubs.forEach { club ->
        club.displayTrophySummary()
    }
}

fun sortClubsByTotalTrophies(clubs: List<Club>): List<Club> {
    return clubs.sortedByDescending { it.totalTrophies }
}

fun filterClubs(
    clubs: List<Club>,
    predicate: (List<Club>) -> List<Club>
): List<Club> {
    return predicate(clubs)
}

fun Club.displayTrophySummary() {
    println("$name berhasil meraih $premierLeague trofi Liga Primer Inggris, " +
            "$faCup trofi FA, " +
            "$eflCup trofi EFL, " +
            "$championsLeague trofi Liga Champions, " +
            "dan $europaLeague trofi Liga Eropa UEFA")
}