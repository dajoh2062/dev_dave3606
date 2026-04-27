#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// gcc -Wall -Wextra task_4_3_person.c;./a.out

typedef struct Person Person;

struct Person {
    char* name;
    int salary;
    int studentDebt;
    short age;
    bool isEmployed;
    bool isStudent;
};

Person* create_person(
    char* name,
    int salary,
    int studentDebt,
    short age,
    bool isEmployed,
    bool isStudent)
{
    Person* person = (Person*) malloc(sizeof(Person));
    if (!person) {
        return NULL;
    }
    person->name = name;
    person->salary = salary;
    person->studentDebt = studentDebt;
    person->age = age;
    person->isEmployed = isEmployed;
    person->isStudent = isStudent;
    return person;
}

void print_person(Person* p) {
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

int main(void) {

    // pointers are stored on stack
    // structs themselves are on heap
    Person* p1 = create_person("Tony", 340000, 0, 45, false, false);
    Person* p2 = create_person("Chris", 200000, 25000, 27, false, false);


    print_person(p1);
    print_person(p2);

    //Task a
    printf("sizeof(p1): %zu\n", sizeof(p1));         // pointer size
    printf("sizeof(*p1): %zu\n", sizeof(*p1));       // struct size
    printf("sizeof(Person): %zu\n", sizeof(Person)); // struct size

    //Task b
    // local struct on stack
    Person p3 = {.name="paulie", .salary=200000, .studentDebt=15000, .age=55, .isEmployed=false, .isStudent=false};
    
    // Stack
    Person* ptr = &p3;

    // Task c

    // Stack
    Person** ptr_to_ptr = &ptr; 

    // Stack
    Person p3_copy = **ptr_to_ptr;


    printf("ptr         = %p\n", (void*)ptr);         // value of ptr = address of p3
    printf("ptr_to_ptr  = %p\n", (void*)ptr_to_ptr);  // value of ptr_to_ptr = address of ptr
    printf("&ptr_to_ptr = %p\n", (void*)&ptr_to_ptr); // address of ptr_to_ptr itself



    // Task d

    printf("salary from varaible itself            = %d\n", p3.salary);
    printf("salary from pointer ptr                = %d\n", (*ptr).salary); //or ptr->salary
    printf("salary from pointer to pointer ptr_ptr = %d\n", (**ptr_to_ptr).salary); //or (*ptr_to_ptr)->age) 
    free(p1);
    free(p2);


    // Task e

    printf("\n&p3              = %p\n", (void*)&p3);
    printf("&p3.name         = %p\n", (void*)&p3.name);
    printf("&p3.salary       = %p\n", (void*)&p3.salary);
    printf("&p3.studentDebt  = %p\n", (void*)&p3.studentDebt);
    printf("&p3.age          = %p\n", (void*)&p3.age);
    printf("&p3.isEmployed   = %p\n", (void*)&p3.isEmployed);
    printf("&p3.isStudent    = %p\n", (void*)&p3.isStudent);


    return 0;
}