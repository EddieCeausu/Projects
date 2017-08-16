import Darwin

func arraygen() -> [Int] {
    print("How large is your array?")
    let arraysize = Int(readLine()!)!
    var array = [Int]()
    print("What is your upperlimit?")
    let upperlimit = UInt32(readLine()!)!
    for _ in 0...arraysize {
      array.append(Int(arc4random_uniform(upperlimit)))
    }
    return array
}
func randomnum() -> Int {
  print("What is the upperlimit of the number?")
  let upperlimit = UInt32(readLine()!)!
  var array = [Int]()
  for _ in 0...50 {
    array.append(Int(arc4random_uniform(upperlimit)))
  }
  return array[Int(arc4random_uniform(upperlimit)/upperlimit)]
}

var done: Bool = false
while !done {
  print("Random Number or Array?")
  var response = String(readLine()!).lowercased()
  if (response == "number" || response == "random number") {
    var rdmnum = randomnum()
    print(rdmnum)
  }
  if response == "array" || response == "random array" {
      var intlist = arraygen()
      print(intlist)
    }
  if((response != "number" || response != "random number") && (response != "array" || response != "random array")) {
    print("Try again")
  }
}
