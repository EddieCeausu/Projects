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
import Quartz
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
var j = 100000000.0
var a = 100_000.0
var file, contents: String
var path: URL
var ex: Int
// **********************************************************************
// End Global Variabels
// **********************************************************************
func gettime() {
  let dateFormatter = DateFormatter()
dateFormatter.timeStyle = .medium

    print("The time is: \(dateFormatter.string(from: Date()))")
}
// **********************************************************************
// Main Function
//*********************************************************************
while total < 1000000000 {
    number += 2
    total += 1

    var prime: Bool = true
    var i = 3
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


    if total == a {
        print("\(a) prime numbers found")
        a += 100_000.0
    }

    if primes.count == Int(j) {
        gettime()
        ex = Int(arc4random_uniform(UInt32(primes.count - 50)))
        print("\n Example of prime # \(Int(ex)): \(primes[ex])")
        file = "\(Int(j)) primes.txt"
        // file creation of array is too large to print
        var intro: String = "\n \t \t \t \t List of prime numbers from \n \t \t \t \t \(a) to \(j) \n \n " // String will print at top of each file created
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
        primes.removeAll()
        j += j
    }
}
