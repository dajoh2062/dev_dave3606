from random import randint, choice
from sys import argv

class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def __repr__(self):
        return f"{self.name} ({self.age})"

    @staticmethod
    def write_to_csv():
        out_path = "./out.csv"

        with open(out_path, "w") as file:
            file.write("name,age\n")

            for p in persons:
                name = p.name.replace('"', '""')   # escape quotes
                file.write(f'"{name}",{p.age}\n')

        print("Data written to out.csv")

    @staticmethod
    def csv_to_string():
        people_from_csv = []
        path = "./out.csv"

        with open(path, "r") as file:
            lines = file.readlines()

        for line in lines[1:]:
            line = line.strip()
            name, age = line.split(",")
            people_from_csv.append(Person(name, age))

        for p in people_from_csv:
            print(p)

    @staticmethod
    def clear_data():
        with open("out.csv", "w"):
            pass


names = [
    "Emma", "Olivia", "Sofie", "Ella", "Maja", "Sofia", "Leah", "Selma",
    "Ellinor", "Lucas", "Noah", "Oliver", "Emil", "Jakob", "William",
    "Theodor", "Ludvig", "Liam", "Johannes",
]

persons = []

count = int(argv[1])

for _ in range(count):
    persons.append(Person(choice(names), randint(0, 100)))

Person.write_to_csv()

Person.csv_to_string()

