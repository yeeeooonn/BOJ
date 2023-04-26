let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split(' ');
//let input require('fs').readFileSync('예제.txt').toString().split('\n');

let a = parseInt(input[0]);
let b = parseInt(input[1]);

console.log(a+b);
