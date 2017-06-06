import Foundation

enum DoorState:String {
    case Opened = "1"
    case Closed = "0"
}
/* declare list of doors state and initialize them */
var doorsStateList = [DoorState](repeating: DoorState.Closed, count: 100)

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

func open(_ doors: [Int]) -> [Int] {
    var doors = doors
    var max = 0
    let i = 2
    let x = 0
    var doorsopen = [Int]()
    while i <= doors.count {
        max = 100 / i
        
    }
}


doors = create(doors)
doors = initopen(doors)
printd(doors)
open(doors)
