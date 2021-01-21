# TCPServerCalc

This is a very simple console application written in Kotlin implementing a raw TCP socket. 
Over the socket, we just perform basic arithmetic calculations. There is no built client for 
this so just use Telnet to play.

I am currently learning Kotlin as my first typed language from a Python and JavaScript background
so types and null safety checks still throw me up a little. (I am just saying this is not the most
beautiful code you're going to read. lol.)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
- Just clone this repository by typing: `git clone https://github.com/Lemmah/TCPServerCalc.git`
- Open project with IntelliJ IDEA. But wait, you have to have some stuff before you get to this point. So these are:

### Prerequisites

- JDK 11 and/or above
- IntelliJ IDEA
- Telnet
  
In your terminal, just type:
```
java -version
```
If you get a version that is a jdk, you know what you're doing.

## Running the tests

Just compile and run the application then use Telnet to interact with it.

Example Telnet console will look like: (this is me over my local network, you can use localhost)
```
Trying 192.168.100.14...
Connected to 192.168.100.14.
Escape character is '^]'.

Welcome to the Lemmah Telnet Calculator.
Basic stuff only: add, subtract, multiply, divide.
Separate elements and operand with a space.
Example:> 3 + 3
23 + 23
23 + 23 = 46.0
100 - 1
100 - 1 = 99.0
24 / 2
24 / 2 = 12.0
3 * 3
3 * 3 = 9.0
lemmah
Invalid expression: cannot calculate
exit
Invalid expression: cannot calculate
Connection closed by foreign host.
```
For the above, the app logs:
```
Handling connection, #1 from /192.168.100.14:65197
Server received 23 + 23
Server received 100 - 1
Server received 24 / 2
Server received 3 * 3
Server received lemmah
Server received exit
Closing connection, #1 from /192.168.100.14:65197
```

## Built With

* [Kotlin](https://www.kotlinlang.org) - The programming language
* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - The IDE, by the creators of Kotlin

## Contributing

This is not part of a course, or a project that needs to be developed any further.
Feel free to fork and use for whatever keeps your boat afloat.

## Authors

* **James Lemayian** - *The learner* - [@Lemmah](https://github.com/lemmah)


## License

This project is currently under the [Creative Commons](https://creativecommons.org/) attribution.

## Acknowledgments

* Hassan Nasser - [TCP vs UDP Crash Course](https://www.youtube.com/watch?v=qqRYkcta6IE)
* Rosetta Code - [Echo Server Implementation](https://rosettacode.org/wiki/Echo_server)
* Troy Miles - [Kotlin Essential Training on LinkedIn Learning](https://www.linkedin.com/learning/kotlin-essential-training)