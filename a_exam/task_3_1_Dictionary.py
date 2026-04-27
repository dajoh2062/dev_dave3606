import sys



word = sys.argv[1] 
characters = {}
charArray = list(word)

for c in charArray:
    if c.lower() in characters:
        characters[c]+=1
    else:
        characters[c]=1

print(characters)

