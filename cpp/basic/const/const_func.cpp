//
// Created by collin on 2022/12/22.
//

#include <iostream>

using namespace std;

void f(const int i){
    // i = 10; // error
    cout << i << endl;
}

int main(){
    f(1);
    return 0;
}