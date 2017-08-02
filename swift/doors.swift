import Foundation
import Darwin
/*
enum DoorState:String {
    case Opened = "1"
    case Closed = "0"
}
/* declare list of doors state and initialize them */
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

After doing math and figuring out that the doors that would be open are the ones that are prefect squares. The following function was created in result to that.
*/
func open2() {
    var state: String
    for i in 1...100 {
        if pow(Double(i), 0.5).truncatingRemainder(dividingBy: 1) == 0 {
            state = "open"
        }
        else {
            state = "close"
        }
        print("Door \(i):\(state)")
    }
}; open2()
