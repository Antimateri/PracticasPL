//hace falta instalar prompt-sync
//npm install prompt-sync
const { readFileSync } = require("fs");
const readline = require('readline');
const prompt = require('prompt-sync')();
const args = process.argv;

const insrc = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

entrada = [];
i = 0; 

async function readInput(n){
    var line;
//    console.log(line);
    for await (line of insrc) {
//	console.log(line);
	entrada.push(parseInt(line));
	n--;
	if (n==0) return;
    }
    insrc.close();
}

var importObjects = {
    runtime: {
        exceptionHandler : function(code) {
            let errStr;
            if (code == 1) {
                errStr= "Error 1. ";
            } else if (code == 2) {
                errStr= "Error 2. ";
	    } else if (code == 3) {
                errStr= "Not enough memory. ";
	    } else {
		errStr= "Unknown error\n";
            }
            throw new Error(errStr);
        },
	print: function(n) {
	    console.log(n);
        },
	read: function() {
	    return parseInt(prompt('>'));
        }
    }};

async function start() {
    const code = readFileSync(args[2]);
    wasmModule = await WebAssembly.compile(code);
    instance = await WebAssembly.instantiate(wasmModule, importObjects);
    process.exit(0);
}

async function run() {
    start();
}

run();

