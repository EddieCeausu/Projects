func prime() {
    print("Enter Number to check Prime")
    let number = Double(readLine()!)!

    if number.truncatingRemainder(dividingBy: 2) == 0 {
      skip = true
    }

    for i in 2...UInt(number) + 1{
        print(i)
        if skip == true {
          i += 1
        }
        if i == UInt(number) {
            print((number),"is prime")
            break
        }

        if UInt(number) % i == 0 {
            print((number),"is not prime")
            break
        }

    }
}; prime()
