/**
 * @Author: Edmond Ceausu <eddieceausu>
 * @Date:   2017-12-27T20:24:04-05:00
 * @Email:  eddieswim101@gmail.com
 * @Filename: prime.cpp
 * @Last modified by:   eddieceausu
 * @Last modified time: 2018-10-17T10:39:28-04:00
 * @Copyright: © Edmond Ceausu 2018
 */



#include <stdio.h>
#include <iostream>
#include <math.h>

bool prime(float number){
    if(number < 2) return false;
    if(number == 2) return true;
    if(fmod(number, 2) == 0) return false;
    for(float i=3; (i*i)<=number; i+=2){
        if(fmod(number, i) == 0.0 ) return false;
    }
    return true;
}

void sprime() {
	float num;
	std::cout << "Enter your number to test" << std::endl;
	std::cin >> num;
	if(prime(num)){
		std::cout << "Prime" << std::endl;
	} else {
		std::cout << "Not Prime" << std::endl;
	}
}

int main() {
	std::cout << "WELCOME TO A PRIME TESTER!" << std::endl;
	sprime();
  return 0;
}
