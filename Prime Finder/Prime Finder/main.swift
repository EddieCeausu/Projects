//
//  main.swift
//  Prime Finder
//
//  Created by Eddie Ceausu on 6/14/17.
//  Copyright © 2017 Edmond Ceausu. All rights reserved.
//  Int max = 9223372036854775807
//  UInt max = 18446744073709551615

// **********************************************************************
// Imports
// **********************************************************************
import Foundation
// **********************************************************************
// End Imports
// **********************************************************************

// **********************************************************************
// Global Variables
// **********************************************************************
//let done = false
var number: Double = 1
var total: Double = 0
var primes = [Double]()
var totalprimes = [Double]()
var j = 1000000.0
var a = 100_000.0
var ainit = 0
var ex: Int
// **********************************************************************
// End Global Variabels
// **********************************************************************
func gettime() -> String {
  let dateFormatter = DateFormatter()
dateFormatter.timeStyle = .medium

    return dateFormatter.string(from: Date())
}
func printfile(_ primes: [Double],_ ainit: Int) {
  var file, contents: String
  var path: URL
  file = "\(Int(primes.count)) primes.txt"
  // file creation of array is too large to print
  let intro: String = "\n \t \t \t \t List of prime numbers from \n \t \t \t \t \(ainit) to \(primes.count) \n \n " // String will print at top of each file created
  contents = intro.replacingOccurrences(of: ".0", with: "") + String(describing: primes).replacingOccurrences(of: "]", with: "").replacingOccurrences(of: "[", with: "").replacingOccurrences(of: ".0", with: "").replacingOccurrences(of: ",", with: "  ") // removes "[],.0" from the array printed in the file
  if let directory = NSSearchPathForDirectoriesInDomains(FileManager.SearchPathDirectory.documentDirectory, FileManager.SearchPathDomainMask.allDomainsMask, true).first { // searching for document directory
      path = URL(fileURLWithPath: directory).appendingPathComponent(file)
      print("File was placed at: \(path) under \(file)")
        //writing
      do {
        try contents.write(to: path, atomically: false, encoding: String.Encoding.utf8)
      }
      catch {
        print("Unable to write to: \(path)")
      }
  }
}
// **********************************************************************
// Main Function
//***********************************************************************
print("Time start is: \(gettime())")
while total < 100000000000 { // will run until 100 billion
    number += 2             //   |
    var prime: Bool = true //    |  Variables set
    var i = 3             //     |
    while(Double(i * i) <= number) { // Check to see if number is prime up to its sqrt

        if number.truncatingRemainder(dividingBy: Double(i)) == 0 {
            prime = false
            break
        }
        i += 2
    }

    if prime != false {
            primes.append(number)
            totalprimes.append(number)
            total += 1
    }


    if total == a {// display rough prime number count
        print("\(a) prime numbers found")
        a += 100_000.0
    }

    if total == j {
      print("\n \(gettime())")
      ex = Int(arc4random_uniform(UInt32(primes.count - 50)))
      print("\n Example of prime # \(Int(ex)): \(primes[ex])")
      printfile(primes, ainit)
      primes.removeAll()
      j += 49000000
      ainit = Int(a)
    }
    if total == (j - 1000000){
      print("\n \(gettime())")
      ex = Int(arc4random_uniform(UInt32(primes.count - 50)))
      print("\n Example of prime # \(Int(ex)): \(primes[ex])")
      printfile(primes, ainit)
      primes.removeAll()
      ainit = Int(a)
    }
    if total == 250000000 {
      print("\n \(gettime())")
      ex = Int(arc4random_uniform(UInt32(primes.count - 50)))
      print("\n Example of prime # \(Int(ex)): \(primes[ex])")
      printfile(primes, ainit)
      primes.removeAll()
      ainit = Int(a)
      j = total
      j += 250000000
    }
}
