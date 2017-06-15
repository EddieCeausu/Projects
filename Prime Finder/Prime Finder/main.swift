//
//  main.swift
//  Prime Finder
//
//  Created by Eddie Ceausu on 6/14/17.
//  Copyright © 2017 Edmond Ceausu. All rights reserved.
// Int max = 9223372036854775807
// UInt max = 18446744073709551615
// **********************************************************************
// Imports
// **********************************************************************
import Foundation
import Quartz
// End Imports
// **********************************************************************

// **********************************************************************
// Global Variables
// **********************************************************************
var intro: String = "\n List of prime numbers from "
let done = false
var number: Double = 1
var primes = [Double]()
var j = 1_000_000.0
var a = 100_000.0
var ex: Int = 15015
var file, contents: String
var path: URL
// **********************************************************************
// End Global Variabels
// **********************************************************************

// **********************************************************************
// Main Function
// **********************************************************************
func primecheck(_ number: Double,_ primes: [Double], prime: Bool) -> (Double, [Double]) {
    var prime: Bool = true
    var i = 3
    var primes = primes
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
    
    return (number, primes)
}

while !done {
    number += 2
    let start = CACurrentMediaTime()
    // primecheck function here
    
    if primes.count == Int(a) {
        print("\(a) prime numbers found")
        a += 100_000.0
    }
    
    if primes.count == Int(j) {
        let end = CACurrentMediaTime()
        print((end-start),"To calculate \(j) primes")
        print("\n Example of prime # \(ex): \(primes[ex])")
        j += j
        // file creation of array is too large to print (NEED TO MAKE FUNCTION FOR THIS)
        file = "\(Int(j)) primes.txt"
        contents = String(describing: primes).replacingOccurrences(of: "]", with: "").replacingOccurrences(of: "[", with: "").replacingOccurrences(of: ".0", with: "")
        
        if let directory = NSSearchPathForDirectoriesInDomains(FileManager.SearchPathDirectory.documentDirectory, FileManager.SearchPathDomainMask.allDomainsMask, true).first {
            path = URL(fileURLWithPath: directory).appendingPathComponent(file)
            print("File was placed at: \(path) under \(file)")
            //writing
            do {
                try contents.write(to: path, atomically: false, encoding: String.Encoding.utf8)
            }
            catch {print("Unable to write to: \(path)")}
        }
    }
}

