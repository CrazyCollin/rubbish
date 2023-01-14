//
// Created by collin on 2023/1/12.
//
#include <iostream>

using namespace std;

class Base{
public:
    Base(){
        cout<<"Constructor: Base"<<endl;
    }
    virtual ~Base(){
        cout<<"Destructor: Base"<<endl;
    }
    virtual void func()=0;
};

class Derived:public Base{
public:
    Derived(){
        cout<<"Constructor: Derived"<<endl;
    }
    ~Derived(){
        cout<<"Destructor: Derived"<<endl;
    }
    void func(){
        cout<<"Derived: func"<<endl;
    }
};

int main(){
    Derived* d=new Derived();
    d->func();
    return 0;
}