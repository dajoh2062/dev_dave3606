#!/usr/bin/env python3

#python3 test.py
#./test.py

def square(x: int) -> int:
    return x * x

def main():
    a = 5
    b = 3.14
    name = "Python"
    flag = True

    if flag:
        print(f"{name} square: {square(a)}")

    for i in range(3):
        print("i =", i)

if __name__ == "__main__":
    main()
