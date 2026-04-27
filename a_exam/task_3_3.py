
values = [1,2,3,4,5,6,7,8,9]

result = [x*x for x in values if x%2==0]
print(result)

#a

resultA=[]
for x in values:
    if x%2==0:
        resultA.append(x*x)
print(resultA)
    
#b

resultB = (x*x for x in values if x%2==0)

print(list(resultB))

#c

