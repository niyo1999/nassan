fun main() {
    print("Write a number: ")
    val number = readLine()?.toIntOrNull()

    if (number != null) {
        val words = convertNumberToWords(number)
        println("In words: $words")
    } else {
        println("Invalid Number.")
    }
}

fun convertNumberToWords(number: Int): String {
    val units = arrayOf("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine")
    val teens = arrayOf("", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
    val tens = arrayOf("", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")

    return when {
        number == 0 -> "Zero"
        number < 0 -> "Minus " + convertNumberToWords(-number)
        number < 10 -> units[number]
        number in 11..19 -> teens[number - 10]
        number < 100 -> tens[number / 10] + if (number % 10 != 0) " " + units[number % 10] else ""
        number < 1000 -> units[number / 100] + " Hundred" + if (number % 100 != 0) " and " + convertNumberToWords(number % 100) else ""
        number < 1000000 -> convertNumberToWords(number / 1000) + " Thousand" + if (number % 1000 != 0) " " + convertNumberToWords(number % 1000) else ""
        else -> "Number out of The range (1-to-999999)"
    }
}