import Foundation

func beer() {
  var beer: Int = 99
  while beer >= 1 {
    print("\(beer) bottles of beer on the wall")
    print("\(beer) bottles of beer")
    print("Take one down, pass it around")
    print("\(beer -= 1) bottles of beer on the wall")
    if beer == 1 {
      print("One bottle of beer on the wall \n One bottle of beer ")
      print("Take one down, pass it around")
      print("0 bottles of beer on the wall")
    }
  }
} beer()
