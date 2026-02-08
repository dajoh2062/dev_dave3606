#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct Person Person;

struct Person {
    char* name; // 8 bytes 
    short age; // 2 bytes

};

Person* new_person(char* name, short age){
    Person* person = (Person*) malloc(sizeof(Person));
    if (person == NULL) {
    return NULL;
}
    person->name=name;
    person->age=age;
    return person;

}

bool is_adult(Person* p){
    if (p == NULL){
        return false;
    }
    else if ((*p).age>=18)
    {
        return true;
    }
    else{
        return false;
    }
    
}



int main(){


    
    return 0;
}