#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

typedef struct node node;
typedef struct DLL DLL;

struct node {
    int value;
    node* prev;
    node* next;
};

struct DLL {
    node* head;
    node* tail;
    int size;
};

/* ---------- construction ---------- */

DLL* dll_create(void) {
    DLL* list = malloc(sizeof(DLL));
    if (!list) return NULL;
    list->head = NULL;
    list->tail = NULL;
    list->size = 0;
    return list;
}

static node* node_create(int value) {
    node* n = malloc(sizeof(node));
    if (!n) return NULL;
    n->value = value;
    n->prev = NULL;
    n->next = NULL;
    return n;
}

/* ---------- insertion ---------- */

bool dll_push_front(DLL* list, int value) {
    node* n = node_create(value);
    if (!n) return false;

    if (list->head == NULL) {
        /* empty list: n is both head and tail */
        list->head = n;
        list->tail = n;
    } else {
        n->next = list->head;
        list->head->prev = n;
        list->head = n;
    }
    list->size++;
    return true;
}

bool dll_push_back(DLL* list, int value) {
    node* n = node_create(value);
    if (!n) return false;

    if (list->tail == NULL) {
        list->head = n;
        list->tail = n;
    } else {
        n->prev = list->tail;
        list->tail->next = n;
        list->tail = n;
    }
    list->size++;
    return true;
}

/* ---------- removal ---------- */
/* pop_* returns false if the list is empty; otherwise writes the
   removed value to *out (if out is non-NULL) and returns true. */

bool dll_pop_front(DLL* list, int* out) {
    if (list->head == NULL) return false;

    node* n = list->head;
    if (out) *out = n->value;

    list->head = n->next;
    if (list->head) {
        list->head->prev = NULL;
    } else {
        /* we just removed the only node */
        list->tail = NULL;
    }
    free(n);
    list->size--;
    return true;
}

bool dll_pop_back(DLL* list, int* out) {
    if (list->tail == NULL) return false;

    node* n = list->tail;
    if (out) *out = n->value;

    list->tail = n->prev;
    if (list->tail) {
        list->tail->next = NULL;
    } else {
        list->head = NULL;
    }
    free(n);
    list->size--;
    return true;
}

/* ---------- utilities ---------- */

void dll_print(const DLL* list) {
    printf("[");
    for (node* cur = list->head; cur != NULL; cur = cur->next) {
        printf("%d", cur->value);
        if (cur->next) printf(", ");
    }
    printf("]  (size=%d)\n", list->size);
}

void dll_free(DLL* list) {
    if (!list) return;
    node* cur = list->head;
    while (cur) {
        node* next = cur->next;
        free(cur);
        cur = next;
    }
    free(list);
}

/* ---------- demo ---------- */

int main(void) {
    DLL* list = dll_create();

    dll_push_back(list, 1);
    dll_push_back(list, 2);
    dll_push_back(list, 3);
    dll_push_front(list, 0);
    dll_print(list);                 /* [0, 1, 2, 3]  (size=4) */

    int v;
    dll_pop_front(list, &v);
    printf("popped front: %d\n", v); /* 0 */
    dll_pop_back(list, &v);
    printf("popped back:  %d\n", v); /* 3 */
    dll_print(list);                 /* [1, 2]  (size=2) */

    dll_free(list);
    return 0;
}