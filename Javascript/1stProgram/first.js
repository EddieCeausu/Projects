function math() {
  var x = 1
  var i = 1

  for(i = 0; i <= Number.MAX_SAFE_INTEGER; i++) {
    console.log(Math.pow(i,i))
  }
}
console.log(Number.MAX_SAFE_INTEGER)
math()
