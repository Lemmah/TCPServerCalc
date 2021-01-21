import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

internal class TCPServerCalc(private val clientSocket: Socket): Runnable {
    private val connectionId: Int = ++connectionsCount

    init {
        println("Handling connection, #$connectionId from ${clientSocket.remoteSocketAddress}")
    }

    override fun run() {
        val output = PrintWriter(clientSocket.getOutputStream(), true)
        val input = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
        output.write("""
            
            Welcome to the Lemmah Telnet Calculator.
            Basic stuff only: add, subtract, multiply, divide.
            Separate elements and operand with a space.
            Example:> 3 + 3
            
        """.trimIndent())
        output.flush()
        while (true) {
            val line = input.readLine() ?: break
            println("Server received $line")
            val elements = this.parse(line)
            val expressionIsValid = this.validate(elements)
            if (expressionIsValid) {
                output.write("$line = ${this.compute(elements)}\n")
            } else {
                output.write("Invalid expression: cannot calculate\n")
            }
            output.flush()
            if (line == "exit") break
        }
        input.close()
        output.close()
        clientSocket.close()
        println("Closing connection, #$connectionId from ${clientSocket.remoteSocketAddress}")
    }

    private fun parse(inputVal: String): List<Any?> {
        val elements: List<String> = inputVal.split(" ")
        val firstNum = elements.getOrNull(0)?.toDoubleOrNull()
        val secondNum = elements.getOrNull(2)?.toDoubleOrNull()
        val operand = elements.getOrNull(1)
        return listOf(firstNum, operand, secondNum)
    }

    private fun validate(elements: List<Any?>): Boolean {
        val validElementsNum = elements.count() == 3
        val validOperand = elements[1] in BasicCalculator.operations
        val validElements = (elements[0] != null && elements[2] != null)
        return validOperand && validElements && validElementsNum
    }

    private fun compute(elements: List<Any?>): Double {
        val calculator = BasicCalculator()
        val firstNum = elements[0] as Double
        val secondNum = elements[2] as Double
        return when (elements[1]) {
            "+" -> calculator.add(firstNum, secondNum)
            "-" -> calculator.subtract(firstNum, secondNum)
            "*" -> calculator.multiply(firstNum, secondNum)
            else -> calculator.divide(firstNum, secondNum)
        }
    }

    private companion object {
        var connectionsCount = 0
    }
}
