from random import randint, choice
from sys import argv


class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def __repr__(self):
        return f"{self.name} ({self.age})"
    
    @staticmethod
    def write_to_JSON():
        path = "./out.json"

        with open(path, "w") as file:
            file.write("[\n")

            for person in persons:
                file.write(
                    "    {\n"
                    f'        "name": "{person.name}",\n'
                    f'        "age": {person.age}\n'
                    "    }"
                )

                if person != persons[-1]:
                    file.write(",")

                file.write("\n")

            file.write("]")

        print("Wrote to out.json")
            



names = [
    "Emma", "Olivia", "Sofie", "Ella", "Maja", "Sofia", "Leah", "Selma",
    "Ellinor", "Lucas", "Noah", "Oliver", "Emil", "Jakob", "William",
    "Theodor", "Ludvig", "Liam", "Johannes",
]

persons = []

count = int(argv[1])

for _ in range(count):
    persons.append(Person(choice(names), randint(0, 100)))


Person.write_to_JSON()