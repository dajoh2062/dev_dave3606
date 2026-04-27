#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>



typedef struct Person Person;

struct Person{
    char* name;
    int age;
};

Person* new_person(char* name, int age){
    Person* p = (Person*) malloc(sizeof(Person));
    p->name=name;
    (*p).age=age;
    return p;
}

bool is_of_age(Person* p){
    int age = (*p).age;

    if(age>=18)return true;

    return false;
}
    


int main (){

    return 0;
}