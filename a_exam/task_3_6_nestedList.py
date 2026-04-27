class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age


def unique_age_names(persons):
    age_count = {}

    for person in persons:
        if person.age in age_count:
            age_count[person.age] += 1
        else:
            age_count[person.age] = 1

    result = []
    for person in persons:
        if age_count[person.age] == 1:
            result.append(person.name)

    return result


def main():
    persons = [
        Person("Anna", 20),
        Person("Bob", 25),
        Person("Cara", 20),
        Person("David", 30),
        Person("Eva", 40),
        Person("Frank", 25)
    ]

    print(unique_age_names(persons))


if __name__ == "__main__":
    main()

if __name__ == "__main__":
    main()