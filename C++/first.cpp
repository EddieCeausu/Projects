#include <iostream>
// removes the need for std::
using namespace std;

// main() must be included in every program
int main()
{
  // cout and endl live in the iostream library
  // std::cout prints out to the console while endl ends the line in the console
	cout << "Hello world!" << endl;
  int x;
  char N = 'N';
  // std::cin reads a line from the console
  cout << "Please enter a value: ";
  cin >> x;
  char response = '';
  cout << "Would you like to print the number entered? (Y/N)" << endl;
  cin << response;
  // throws away enter from c-in
  cin.ignore();

  if(response != 'N') {
    cout << "Entered Value: " << x << endl;
  }
	return 0;
}
