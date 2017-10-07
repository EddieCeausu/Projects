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
    return array.sorted()
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
  else if response == "array" || response == "random array" {
      var intlist = arraygen()
        if intlist.count >= 5000 {
            file = "random_array-\(intlist.count)"
            contents = String(describing: intlist).replacingOccurrences(of: "]", with: "").replacingOccurrences(of: "[", with: "").replacingOccurrences(of: ",", with: " ")
            
            if let directory = NSSearchPathForDirectoriesInDomains(FileManager.SearchPathDirectory.documentDirectory, FileManager.SearchPathDomainMask.allDomainsMask, true).first {
                path = URL(fileURLWithPath: directory).appendingPathComponent(file)
                print("File was placed at: \(path) under \(file)")
                //writing
                do {
                    try contents.write(to: path, atomically: false, encoding: String.Encoding.utf8)
                }
                catch {print("Unable to write to: \(path)")}
            }
        } else {
            print(intlist)
    }
    }
  else if((response != "number" || response != "random number") && (response != "array" || response != "random array")) {
    print("Try again")
  }
}
