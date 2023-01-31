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

    val question1 = Question<String>(
        question = "Quoth the raven ___",
        answer = "nevermore",
        difficulty = Difficulties.MEDIUM
    )

    val question2 = Question<Boolean>(
        question = "The sky is green. True or false",
        answer = true,
        difficulty = Difficulties.EASY
    )

    val question3 = Question<Int>(
        question = "How many days are there between full moons?",
        answer = 28,
        difficulty = Difficulties.HARD
    )

    companion object StudentProgress {
        const val total = 10
        const val answered = 3
    }

    fun printQuiz() {
        // scope functions
        question1.let {
            println(it.question)
            println(it.answer)
            println(it.difficulty)
        }

        println()

        question2.let {
            println(it.question)
            println(it.answer)
            println(it.difficulty)
        }

        println()

        question3.let {
            println(it.question)
            println(it.answer)
            println(it.difficulty)
        }

        println()
    }

}


fun main() {
    // scope function 'apply'
    Quiz().apply {
        printQuiz()
        printProgressBar()
    }
}