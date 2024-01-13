const fs = require('fs');

//백준
const input = fs.readFileSync('/dev/stdin').toString().split(' ');
//VSCode
//const input = fs.readFileSync('예제.txt').toString().split(' ');

const point = Math.floor(input[0] / (input[2] - input[1]));

console.log(input[2] - input[1] <= 0 ? -1 : point + 1);
