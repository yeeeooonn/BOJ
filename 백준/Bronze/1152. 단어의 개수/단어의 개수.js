const fs = require('fs');

//백준
const input = fs.readFileSync('/dev/stdin').toString().trim().split(' ');
//VSCode
//const input = fs.readFileSync('예제.txt').toString().trim().split(' ');

console.log(input[0] === '' ? 0 : input.length);
