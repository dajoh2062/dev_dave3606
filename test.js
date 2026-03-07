#!/usr/bin/env node
//tsc test.ts;node test.js
//tsc test.ts;./test.js
var a = 9007199254740991;
console.log(a);
console.log(a + 1);
console.log(a + 2);

function square(x) {
    return x * x;
}

const x1 = 5;
const x2 = 3.14;
const name2 = "JavaScript";
let flag = true;

if (flag) {
    console.log(`${name2} square: ${square(x1)}`);
}

for (let i = 0; i < 3; i++) {
    console.log("i =", i);
}
