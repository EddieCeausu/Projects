//
//  main.swift
//  Selection Sort
//
//  Created by Eddie Ceausu on 11/30/16.
//  Copyright © 2016 Eddie Ceausu. All rights reserved.
//
import Foundation
import Quartz

// *******************************************************************
// Function strinput returns a String which it reads from the Console
//
// *********************************************************************
func strinput() -> String {
    return String(readLine()!)
} // end of function strinput
// *********************************************************************
//
// Function doubleinput returns an integer which it reads from the Console
//
// *********************************************************************
func doubleinput() -> Double {
    return Double(readLine()!)!
} // end of function doubleinput
// *********************************************************************
//
// Function intinput returns an integer which it reads from the Console
//
// *********************************************************************
func intinput() -> Int {
    return Int(readLine()!)!
} // end of function intinput
// *********************************************************************
// *********************************************************************

func Uintinput() -> UInt32 {
  return UInt32(readLine()!)!
} // end of function intinput
// *********************************************************************
var sel: Int
var arraysize: Int
var upperlimit: UInt32
var max: Int
var intlist = [Int] ()
var done: Bool = false
var select: Int

func menu() ->Int {
        print("Selection Sort Program")
        print("Sorting Program")
        print("Load                   1")
        print("Sort array             2")
        print("Insertion sort         3")
        print("Print array            4")
        print("Binary search          5")
        print("Find Number            6")
        print("Quit                   0")
        print("Enter option: ", terminator: "")
        return intinput()
    }

func create()-> [Int] {
    var arraysize: Int
    var upperlimit: UInt32
    //  Loading and Sorting array
    print("Enter array size: ");

    // Enter a line of code which reads a response from the console, and assigns it to
    // variable arraysize.  See worksheet question3.h.
    arraysize = intinput()
    print("Enter Upper Limit: ")
    upperlimit = Uintinput()
    let starttime = CACurrentMediaTime()
    print("Loading array with random numbers...");
    for i in 0...arraysize {
        intlist.append(Int(arc4random_uniform(upperlimit)))
    }
    let endtime = CACurrentMediaTime()
    print("Sort Execution time is ", endtime-starttime, " sec")
    print(intlist)
    return intlist
}

func sort(intlist: [Int]) -> [Int] {
  print("\n Sorting Array...")
  print("")
  print(intlist)
  var intlist2 = intlist
  for i in 0...intlist2.count-1 {

    for j in 0...intlist2.count-1 {

        if (intlist2[j] < intlist2[i]) {
           swap(&intlist2[i],&intlist2[j])
         }
     } // end of for j
  } // end of for i
  print("")
  print("Sorted Array:")
  return intlist2
}

func insert(intlist: [Int]) -> [Int] {
  var insert: Int
  var respone: String
  var intlist = intlist
  print("What Integer would you like to add to the Array?")
  insert = intinput()
  intlist.append(insert)
  print("Would you like to resort the array? Y/N")
  respone = strinput()
  if (respone == "Y")
  {
    sort(intlist: intlist)
  }
  return intlist
}
// ********************************************************************************
while !done {
  var select = menu()
    switch(select) {
    case 1:
        var intlist = create()
    case 2:
      var mum = sort(intlist)
      var intlist = mum.0
         break
    case 3:
      var mum2 = insert(intlist: intlist)
      var intlist = mum2.0
        break
    case 4:
        print(intlist)
        break
    case 5:
        intlist.removeAll()
        break
    default: print("Please choose a better option")


    }
}
// end of while
//***************************************************************************************************
