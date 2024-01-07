const fs = require('fs');

//백준
let input = fs.readFileSync('/dev/stdin').toString();
//VSCode
//let input = fs.readFileSync('예제.txt').toString();

let counter = 0;

while (input > 0) {
	counter++;
	input = input - counter;
}

if (counter % 2 === 0) {
	console.log(`${counter + input}/${1 + -input}`);
} else {
	console.log(`${1 + -input}/${counter + input}`);
}
