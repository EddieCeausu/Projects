import Foundation
import Darwin

var doors = [Int]()

func printd(_ doors: [Int]) {
  print("Would you like to Print the doors?")
  let response = String(readLine()!)
  if response == "Y" {
    print(doors)
    return
  }
}
func create(_ doors: [Int]) -> [Int] {
  var doors = doors
  for _ in 0...100 - 1 {
    doors.append(0)
  }
  print("\(doors) count is: \(doors.count)")
  print("1 is open and 0 is closed")
  return doors
}

func initopen(_ doors: [Int]) -> [Int] {
  var doors = doors
  for i in 0...doors.count-1 {
    if doors[i] == 0 {
      doors[i] = 1
    }
  }
  return doors
}

func evenopen(_ doors: [Int]) -> [Int] {
  var doors = doors
  var j: Int
  for i in 2...doors.count-1 {
    j = i
    if j % 2 == 0 {

    }
  }
}
doors = create(doors)
doors = initopen(doors)
printd(doors)
