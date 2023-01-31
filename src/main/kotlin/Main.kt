enum class Difficulties {
    EASY,
    MEDIUM,
    HARD
}

data class Question<T> (
    val question: String,
    val answer: T,
    val difficulty: Difficulties
)

interface ProgressPrintable {
    val progressText: String

    fun printProgressBar()
}

class Quiz: ProgressPrintable {
    override val progressText: String
        get() = "$answered of $total answered"

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(total - answered) { print("▒") }
        println()
        println(progressText)
    }

    val q1 = Question<String>(
        question = "Quoth the raven ___",
        answer = "nevermore",
        difficulty = Difficulties.MEDIUM
    )

    val q2 = Question<Boolean>(
        question = "",
        answer = true,
        difficulty = Difficulties.EASY
    )

    val q3 = Question<Int>(
        question = "How many days are there between full moons?",
        answer = 28,
        difficulty = Difficulties.HARD
    )

    companion object StudentProgress {
        const val total = 10
        const val answered = 3
    }

}


fun main() {
    Quiz().printProgressBar()
}