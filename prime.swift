import Foundation
import Quartz
// Int max = 9223372036854775807
// UInt max = 18446744073709551615
func primefinder() {
// Global Variables
    let done = false
    var number: Double = 1
    var primes = [Double]()
    var j = 1_000_000.0
    var a = 100_000.0
    var ex: Int = 15015
    var file, contents: String
    var path: URL
// End Global Variabels

    while !done {
        var prime: Bool = true
        var i = 3
        number += 2
        let start = CACurrentMediaTime()
        while(Double(i * i) <= number) {
            if number.truncatingRemainder(dividingBy: Double(i)) == 0 {
                prime = false
                break
            }
            i += 2
        }

        if prime != false {
            primes.append(number)
        }

        if primes.count == Int(a) {
            print("\(a) prime numbers found")
            a += 100_000.0
        }

        if primes.count == Int(j) {
            let end = CACurrentMediaTime()
            print((end-start),"To calculate \(j) primes")
            print("\n Example of prime # \(ex): \(primes[ex])")
            j += j
                // file creation of array is too large to print
                file = "\(Int(j)) primes.txt"
                contents = String(describing: primes).replacingOccurrences(of: "]", with: "").replacingOccurrences(of: "[", with: "").replacingOccurrences(of: ".0", with: "")

                if let directory = NSSearchPathForDirectoriesInDomains(FileManager.SearchPathDirectory.documentDirectory, FileManager.SearchPathDomainMask.allDomainsMask, true).first {
                    path = URL(fileURLWithPath: directory).appendingPathComponent(file)
                    print("Due to your file being larger than \(1_000_000) items, it was placed at: \(path)")
                    //writing
                    do {
                        try contents.write(to: path, atomically: false, encoding: String.Encoding.utf8)
                    }
                    catch {print("Unable to write to: \(path)")}
                }
            }
        }
    }; primefinder()
