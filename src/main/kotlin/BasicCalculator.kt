internal class BasicCalculator {

    fun add(a: Double, b:Double): Double {
        return a + b
    }

    fun subtract(a: Double, b: Double): Double {
        return a - b
    }

    fun multiply(a: Double, b: Double): Double {
        return a * b
    }

    fun divide(a: Double, b: Double): Double {
        return a / b
    }

    companion object {
        val operations = listOf("+", "-", "/", "*")
    }
}
