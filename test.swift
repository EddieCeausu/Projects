import Foundation
import Darwin

var random = arc4random_uniform(UInt32.max)
func asdf() {
    let done = false
    var j: Int
    j = 0
    while !done {
      j += 1
      print(j)
      if Double(j) >= pow(2, 32) {
        let f = j
        j = 0
        j = j - f
      }
      var count = 0.0
      while count <= pow(2,64) {
        j -= 1
        print(j)
        count += 1
        if j < Int(Int.max) {
          let k = Int.max
          while k > Int(count) {
          j += Int(arc4random_uniform(UInt32.max))
          print(j)
          if Double(j) > (15348863094911697.0) {
            j *= Int(arc4random_uniform(UInt32.max))
          }
        }
        }
      }
      if j < Int.max {
        return
      }
    }
}

func qwer() {
  var j = 0

}

func menu() -> Int {
  print("\nRandom number increase    1")
  print("Try 2                     2")
  let choice = Int(readLine()!)!
  return choice
}
var done: Bool = false
while !done {
  var select = menu()
  switch (select) {
  case 1:
    asdf()
    break
  case 2:
    qwer()
      break
  default: print("Pick a better choice"); break

  }
}
