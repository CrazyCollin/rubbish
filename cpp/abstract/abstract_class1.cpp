//
// Created by collin on 2023/1/12.
//

#include <iostream>

using namespace std;

class Base{
    int x;
public:
    virtual void show()=0;
    int getX(){
        return this->x;
    }
};

class Derived:public Base{
public:
    void show(){
        cout<<"In Derived"<<endl;
    }
};

int main(){
    Base* derived=new Derived();
    derived->show();
    return 0;
}