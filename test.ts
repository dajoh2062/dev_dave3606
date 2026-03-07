#!/usr/bin/env node

//tsc test.ts;node test.js
//tsc test.ts;./test.js

let x: number = 9007199254740991;
console.log(x);
console.log(x+1);
console.log(x+2);
console.log(x+3);

function square2(x: number): number {
    return x * x;
}

const y: number = 5;
const z: number = 3.14;
const name1: string = "TypeScript";
let flag2: boolean = true;

if (flag2) {
    console.log(`${name1} square: ${square2(y)}`);
}

for (let i = 0; i < 3; i++) {
    console.log("i =", i);
}
