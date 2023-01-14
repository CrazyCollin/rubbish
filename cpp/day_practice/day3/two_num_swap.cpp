//
// Created by collin on 2023/1/14.
//

#include <iostream>

using namespace std;

void swap(int &a,int &b);

int main(){
    int a(5);
    int b(7);
    swap(a,b);
    cout<<a<<"-"<<b<<endl;
    return 0;
}

void swap(int &a,int &b){
    int temp;
    temp=a;
    a=b;
    b=temp;
}