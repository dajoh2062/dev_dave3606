import sys

#3.1a)



def characters(string):
    dict = {}
    for ch in string:
        ch=ch.lower()
        if ch in dict and "a" <= ch <= "z":
            dict[ch] +=1
        elif "a" <= ch <= "z":
            dict[ch] = 1

    print(dict)
    return dict

# 3.3a)

values = [1,2,3,4,5,6,7,8,9]

def list_even(values):
    result_list = []
    for x in values:
        if x % 2==0:
            result_list.append(x*x)
    print(result_list)
    return result_list

# 3.3b)

def gen_even():
    limit = 10
    gen_even = (x*x for x in range (limit) if x%2==0)
    for i in gen_even:
        print(i)
    return gen_even
        


if __name__ == "__main__":

    list_even(values)
    gen_even()

    