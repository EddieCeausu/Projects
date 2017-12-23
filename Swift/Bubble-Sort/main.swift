import Foundation

func sort(j: [Int]) -> [Int] {
  var n = j
  var done = true
  while(done) {
    done = false
    for i in 0...n.count {
      if n[i] > n[i + 1] {
        n.swapAt(i, i + 1)
        done = true
      }
    }
  }
  return n
}
func arraygen(n: Int) -> [Int] {
  var array = [Int]()
  for i in 0...n+1 {
    array.append(Int(arc4random_uniform(UInt32(n))))
  }
  return array
}
func main() {
  print("Welcome to Bubble Sort!\nEnter your UpperLimit for an Array: ")
  var uLimit = Int(readLine()!)!
  var array = arraygen(n: uLimit)
  print("\(array)\n")
  print(sort(j: array))
}
main()
