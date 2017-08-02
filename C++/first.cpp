#include <iostream>

// main() must be included in every program
int main()
{
  // cout and endl live in the iostream library
  // std::cout prints out to the console while endl ends the line in the console
	std::cout << "Hello world!" << std::endl;
  int x;

  // std::cin reads a line from the console
  std::cout << "Please enter a value: ";
  std::cin >> x;

  std::cout << "Entered Value:" << x << std::endl;
	return 0;
}
