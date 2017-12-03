#include<stdio.h>
#include<iostream>
bool prime(int x) {
	for(int i = 1; i <= x; i += 2) {
		if(i % x == 0) {
			return false;
		}
	}
	return true;
}

int main() {
	int ulimit;
	std::cout << "Enter the UpperLimit" << std::endl;
	std::cin >> ulimit;
	for(int j = 1; j <= ulimit; j++) {
		if(prime(j)) {
			std::cout << j << std::endl;
		}
	}
return 0;
}