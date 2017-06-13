import Foundation
import Quartz
// Int max = 9223372036854775807
// UInt max = 18446744073709551615
func primefinder() {
    let done = false
    var number: Double = 11
    var primes = [Double]()
    var j = 1_000_000.0
    var a = 10000.0
    while !done {
        var prime: Bool = true
        var i = 3
        number += 2
        let start = CACurrentMediaTime()
        while(Double(i * i) <= number){
            if number.truncatingRemainder(dividingBy: Double(i)) == 0 {
                prime = false
                break
            }
            i += 2
        }

        if prime != false {
            primes.append(number)
            if primes.count == Int(a) {
                print("\(a) prime numbers found")
                a += 10000
            }

            if primes.count == Int(j) {
                let end = CACurrentMediaTime()
                print((end-start),"To calculate \(j) primes")
                print("\n \(primes)")
                j += 1_000_000
            }
        }
    }
}; primefinder()

func prime() {
    print("Enter Number to check Prime")
    let number = Double(readLine()!)!
    print("Crunching math...")
        for i in 2...UInt(number) + 1{
            print(i)

            if i == UInt(number) {
              print("....")
                sleep(1)
                print((number),"is prime")
                break
            }

            if UInt(number) % i == 0 {
              print("...")
                print((number),"is not prime")
                break
            }
        }

    }; prime()
