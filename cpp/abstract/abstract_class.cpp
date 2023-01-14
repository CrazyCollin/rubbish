//
// Created by collin on 2023/1/12.
//

#include <iostream>

using namespace std;

class A{
public:
    virtual void f()=0;
    void g(){
        this->f();
    }
};

class B:public A{
    void f(){
        cout<<"B:f()"<<endl;
    }
};

int main(){
    B b;
    b.g();
}