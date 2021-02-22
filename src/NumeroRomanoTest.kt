import org.junit.Assert.*
import org.junit.Test


class NumeroRomanoTest{

    private val objetoDeTeste = ConversorNumerosRomanosParaIndoArabicos()

    @Test
    fun LerImput_apenasLetrasMaiusculas_true(){

        val valorRecebido = objetoDeTeste.isValidInput("Y")
        assertEquals(true, valorRecebido)
    }

    @Test
    fun leImput_InputNumerico_false(){

        val valorRecebido = objetoDeTeste.isValidInput("3")
        assertEquals(false, valorRecebido)
    }

    @Test
    fun lerImput_stringminuscula_false(){
        val valorRecebido = objetoDeTeste.isValidInput("v")
        assertEquals(false, valorRecebido)
    }

    @Test
    fun converte_LetraRomana_StringCorreta(){
        val valorRecebido = objetoDeTeste.converte("IV")
        assertEquals("4", valorRecebido)
    }

    @Test
    fun converte_numeroInteiro_StringCorreta(){
        val valorRecebido = objetoDeTeste.converte("5")
        assertEquals("V", valorRecebido)
    }
}