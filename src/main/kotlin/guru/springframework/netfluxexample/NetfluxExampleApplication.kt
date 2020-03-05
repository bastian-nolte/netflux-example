package guru.springframework.netfluxexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NetfluxExampleApplication

fun main(args: Array<String>) {
    runApplication<NetfluxExampleApplication>(*args)
}
