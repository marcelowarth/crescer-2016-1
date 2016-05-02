'use strict';

console.log('Outro Script!!');
console.log(hello);

function somar(a,b) {return a+b;};
var sub = function somar(a, b, fn) {return fn(a-b);};

var funcoes = [somar (1,1), sub];
console.log(funcoes[1](3,2););

funcoes[1](3,2, funtion(res) {console.log('O resultado é:', res);});
