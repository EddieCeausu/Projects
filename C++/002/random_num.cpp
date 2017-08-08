#include <iostream>

using namespace std;
// Function will attempt to
int random_num() {
  int x, y;
  cout << "Please enter a number";
  cin >> x;
  cout << "Please enter the max random numuber: ";
  cin >> y;
  for(int i; i <= 1000; i++) {
    if(x % i == 4) {
      x *= 51
    }
  }
}
