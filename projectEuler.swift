import Darwin
import Foundation

print("This is Project Euler problems")
func mult3and5() {
  print("Problem 1 Multiples of 3 and 5")
  var multi = [Int]()
  for i in 0...1000 {
    if i % 3 == 0 {
      multi.append(i)
    }
    else if i % 5 == 0 {
      multi.append(i)
    }
  }
  let x = multi.reduce(0, +)
  print("Sum of multiples of 3 and 5 between 0 and 1000: \(x)")
}; mult3and5()
// *************************************************************************** //
sleep(2)
// *************************************************************************** //
var done = false
while !done {
    func fib(_ n:Int) -> Int {
        if n <= 1 {
            return n
        }
        else {
            return(fib(n-1) + fib(n-2))
        }
    }

    print("Fibonacci sequence of values under 4,000,000")
    var i = 0
    var fibo = [Int]()

    while fib(i) < 4_000_000 {
        if fib(i) % 2 == 0 {
            fibo.append(fib(i))
            print(fib(i))
        }
        i += 1
    }
    i = fibo.reduce(0, +)
    print("The sum of the Even numbers of the fibonacci sequence values under 4,000,000: \(i)")
    done = true
}
// *************************************************************************** //
sleep(2)
// *************************************************************************** //
