#!/bin/bash

square() {
    echo $(($1 * $1))
}

a=5
name="Bash"
flag=true

if [ "$flag" = true ]; then
    echo "$name square: $(square $a)"
fi

for i in {0..2}
do
    echo "i = $i"
done
