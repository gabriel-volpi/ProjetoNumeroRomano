class ConversorNumerosRomanosParaIndoArabicos {

    val mapaDeNumeros = mutableMapOf<String, Int>(
        "I" to 1,
        "V" to 5,
        "X" to 10,
        "L" to 50,
        "C" to 100,
        "D" to 500,
        "M" to 1000
    )

    fun isValidInput(entrada: String): Boolean {

        val entrada = entrada
        val pattern = "[A-Z]+".toRegex()
        return entrada is String && pattern.matches(entrada)
        //return entrada is String
    }

    fun converte(entrada: String): String {

        val isRomanAlgorithm: Boolean = isValidInput(entrada)

        if (isRomanAlgorithm) {
            return converteRomanoInteiro(entrada)
        } else {
            return ""
        }
    }

    fun converteRomanoInteiro(entrada: String): String {

        var saida = ""
        var inteiro = 0
        val tamanho = entrada.length - 1
        entrada.onEachIndexed() { index, carac ->

            inteiro += if (isNextNumberHigherThanCurrent(entrada[index], entrada[index + 1])) {
                subtractAdjacentChars(entrada[index], entrada[index + 1])
            } else {
                sumAdjacentChars(entrada[index], entrada[index + 1])
            }
/*
            var nextchar = entrada[index + 1]

            if ((index + 1) <= tamanho) {
                var nextchar = entrada[index + 1].toString() // não está atualizando o proximo caractere
            }
            var nextvalue = 0


            mapaDeNumeros.forEach { member ->
                if (member.key == carac.toString()) {
                    inteiro += member.value
                }
            }}
      */

        }
        saida = inteiro.toString()
        return saida

    }


    private fun isNextNumberHigherThanCurrent(current: Char, next: Char): Boolean {
        return mapaDeNumeros[current]!! < mapaDeNumeros[next]!!
    }

    fun converteInteiroRomano(entrada: Int): String {
        var saida = ""

        mapaDeNumeros.forEach { member ->
            if (member.value == entrada) {
                saida = saida.plus(member.key)
            }
        }
        return saida
    }

    fun sumAdjacentChars(startChar: Char, nextChar: Char): Int {
        val firstValue = mapaDeNumeros[startChar]
        val secondValue = mapaDeNumeros[nextChar]
        return firstValue!! + secondValue!!
    }

    fun subtractAdjacentChars(startChar: Char, nextChar: Char): Int {
        val firstValue = mapaDeNumeros[startChar]
        val secondValue = mapaDeNumeros[nextChar]
        return firstValue!! - secondValue!!
    }
}