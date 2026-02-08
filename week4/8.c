#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct Person Person;

struct Person {
    char* name;
    int age;
    Person* previous;
    Person* next;
};

Person* create_person(char* name, int age) {
    Person* person = (Person*) malloc(sizeof(Person));
    if (person == NULL) {
        return NULL;
    }
    person->name = name;
    person->age = age;
    person->previous = NULL;
    person->next = NULL;
    return person;
}

char* names[] = {"Sean", "Jordan", "Francisco", "Megan", "Yael"};

int main() {
    Person* first_person = NULL;
    Person* last_person = NULL;

    /* Build the doubly linked list */
    for (int i = 0; i < 5; i++) {
        Person* new_person = create_person(names[i], i * 8);

        if (first_person == NULL) {
            first_person = new_person;
            last_person = new_person;
        } else {
            last_person->next = new_person;
            new_person->previous = last_person;
            last_person = new_person;
        }
    }

    /* Iterate forwards through the list */
    Person* current = first_person;
    while (current != NULL) {
        printf("%s (%d)\n", current->name, current->age);
        current = current->next;
    }

    /* Free the list */
    current = first_person;
    while (current != NULL) {
        Person* next = current->next;
        free(current);
        current = next;
    }

    first_person = NULL;
    last_person = NULL;

    return 0;
}
