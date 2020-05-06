#include <stdio.h>
#include <iostream>
#include <math.h>
#include "csv.h"

using namespace std;

int main() {
    io::CSVReader<3> in("machine.csv");
    std::string vendor; int size; double speed;
    while(in.read_row(vendor, size, speed)) {
        cout << vendor << endl;
    }
}
