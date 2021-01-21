import java.net.ServerSocket

fun main() {
    val serverSocket = ServerSocket(9999)
    try {
        while (true) {
            val clientSocket = serverSocket.accept()
            Thread(TCPServerCalc(clientSocket)).start()
        }
    } finally {
        serverSocket.close()
        println("Closing server socket")
    }
}
