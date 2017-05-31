import Foundation
import Darwin

var doors = [Int]()
func printd(_doors: [Int]) {
  print("Would you like to Print the doors?")
  var response
}
func create(_doors: [Int]) -> [Int] {
  for i in 0...100 - 1 {
    doors.append(0)
  }
  print("\(doors) count is: \(doors.count)")
  print("1 is open and 0 is closed")
  return doors
}

func initopen(_doors: [Int]) -> [Int] {
  for i in 0...doors.count-1 {
    if doors[i] == 0 {
      doors[i] = 1
    }
  }
  return doors
}

doors = create(doors)
doors = initopen(doors)
