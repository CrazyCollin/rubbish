//
// Created by collin on 2023/1/12.
//

#include <iostream>

using namespace std;

class A{
private:
    int a;
public:
    virtual void show()=0;
};

int main(){
    // 抽象类不能创建对象
    // A a;
    A *a1;
    // A *a2=new A();
}