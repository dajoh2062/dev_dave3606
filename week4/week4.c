#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

//clear;gcc week4.c;./a.exe

typedef struct Person Person;

struct Person {
    char* name;
    int salary;
    int studentDebt;
    short age;
    bool isEmployed;
    bool isStudent;
};

Person* create_person(char* name, int salary, int studentDebt, short age, bool isEmployed, bool isStudent){
    Person* person = (Person*) malloc(sizeof(Person));
    person->name=name;
    person->salary = salary;
    person->studentDebt = studentDebt;
    person->age = age;
    person->isEmployed = isEmployed;
    person->isStudent = isStudent;
    return person;
 
};

void print_person(Person* p){
    if (!p) {
        printf("Person is NULL\n");
        return;
    }

    printf("Person {\n");
    printf("  name: %s\n", p->name);
    printf("  salary: %d\n", p->salary);
    printf("  studentDebt: %d\n", p->studentDebt);
    printf("  age: %hd\n", p->age);
    printf("  isEmployed: %s\n", p->isEmployed ? "true" : "false");
    printf("  isStudent: %s\n", p->isStudent ? "true" : "false");
    printf("}\n");
}


void add(int a, int b, int* sum){
    *sum=a+b;
}

int main() {


    //4)
    int sum;
    add(3,4,&sum);
    printf("%d\n", sum);







    /*

       // Person object on the heap dynamically allocated
    Person* p1 = create_person(
        "Alice",
        500000,
        200000,
        27,
        true,
        true
    );

    
    Person** p2 = &p1;


       // local Person object
    Person p = {
    .name = "Alice",
    .salary = 500000,
    .studentDebt = 200000,
    .age = 27,
    .isEmployed = true,
    .isStudent = true
};
        // local Person object
    Person* pp = &p;     // pointer to it
    Person** ppp = &pp;



    //d)
    printf("d)");
    printf("age via object: %d\n", p.age);
    printf("age via pointer: %d\n", pp->age); //((*pp).age))
    printf("age via pointer-to-pointer: %d\n", (*ppp)->age);


    
    //e)
    printf("e)");
    printf("&p              = %p\n", (void*)&p);
    printf("&p.name         = %p\n", (void*)&p.name);
    printf("&p.salary       = %p\n", (void*)&p.salary);
    printf("&p.studentDebt  = %p\n", (void*)&p.studentDebt);
    printf("&p.age          = %p\n", (void*)&p.age);
    printf("&p.isEmployed   = %p\n", (void*)&p.isEmployed);
    printf("&p.isStudent    = %p\n", (void*)&p.isStudent);


 
    print_person(p1);

    printf("Pointer size: %zu bytes\n", sizeof(p1));
    printf("Person size:  %zu bytes\n", sizeof(*p1));
    printf("Size of Person: %zu bytes\n", sizeof(Person));
   
  
    
    printf("Address of p   : %p\n", (void*)&p);
    printf("Address of pp  : %p\n", (void*)&pp);
    printf("Address of ppp : %p\n", (void*)&ppp);
    
   printf("pp  (points to p)     = %p\n", (void*)pp);
    printf("ppp (points to pp)    = %p\n", (void*)ppp);
    printf("&ppp (address of ppp) = %p\n", (void*)&ppp);
   



    free(p1);
    */




    return 0;
}