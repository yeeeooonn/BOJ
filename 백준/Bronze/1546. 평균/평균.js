const fs = require('fs');
//백준
const input = fs.readFileSync('/dev/stdin').toString().split('\n');
//VSCode
//const input = fs.readFileSync('예제.txt').toString().split('\n');

let numbers = input[1].split(' ');
let max = -1;
let hap = 0;
for (let i = 0; i < Number(input[0]); i++) {
	if (Number(numbers[i]) > max) max = Number(numbers[i]);
	hap += Number(numbers[i]);
}

console.log(((hap / max) * 100) / Number(input[0]));
