/* Daisy Game!

Faça uma função chamada daisyGame que receba por argumento o número de pétalas da margarida e retorne 'Love me' ou 'Love me not' (Lembre do jogo "Bem me quer, mal me quer"). Exemplo:

daisyGame(4); // retorna 'Love me not' */
function daisyGame(number) {
  if (number%2 === 0) {
    console.log('Love me not');
  } else {
    console.log('Love me');
  }
}

/* Exercício 2

Maior texto

Faça uma função chamada maiorTexto que receba um array de strings e retorne o texto com maior número de caracteres. */

function maiorTexto(array) {
  var maior = undefined;
  for (var i = 0; i < array.length; i++) {
    if(typeof maior === 'undefined') {
      maior = array[i];
    } else {
      if(maior.length < array[i].length) {
        maior = array[i];
      }
    }
  }
  console.log(maior);
}

/*
Instrutor querido

Faça uma função chamada imprime que receba dois parâmetros:

Um array de strings; e
Uma função.
Dentro da função imprime chame a função do segundo parâmetro para cada elemento do array. Exemplo:

  imprime(
    // primeiro parâmetro: array
    [ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ],
    // segundo parâmetro: função
    function(instrutor) {
     console.log('olá querido instrutor:', instrutor)
    }
  );
Deve resultar em:

"olá querido instrutor: bernardo"
"olá querido instrutor: nunes"
"olá querido instrutor: fabrício"
"olá querido instrutor: ben-hur"
"olá querido instrutor: carlos"

Atenção! Faça um tratamento para evitar que a função imprime seja chamada com um segundo parâmetro que não seja uma função, por exemplo:

imprime([ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ], 3.14);
// Jabulani:
// 'TypeError: number is not a function'
*/
function instrutor(value) {
   console.log('olá querido instrutor:', value);
}

function imprime(array, instrutor) {
  if(typeof instrutor === 'funtion') {
    for (var i = 0; i < array.length; i++) {
      instrutor(array[i]);
    }
  } else {
    throw new TypeError('second parameter is not a valid function, should be "instrutor"');
  }
}
/*
Soma diferentona

Escreva uma função somar que permite somar dois números através de duas chamadas diferentes (não necessariamente pra mesma função). Pirou? Ex:

adicionar(3)(4); // 7
adicionar(5642)(8749); // 14391
*/

function adicionar(x){
  return function(y){
    console.log(x + y);
  };
};

/*
Fibona

Faça uma função fiboSum que calcule a soma da sequência de Fibonacci para n números informados. Exemplo de chamada:

fiboSum(7);
// 33 (soma dos 7 primeiros números da sequência: 1+1+2+3+5+8+13)
Dica: aproveite toda "beleza" dos algoritmos recursivos! #sqn
*/
function fiboSum(indice) {
  var i;
  var fib = [];

  fib[0] = 0;
  fib[1] = 1;
  soma = 1;
  for(i=2; i<=indice; i++)
  {
      fib[i] = fib[i-2] + fib[i-1];
      soma = soma + fib[i];
  }
  console.log(soma);
}
/*
Quero café

Escreva uma função queroCafe que recebe dois parâmetros:

mascada: Valor numérico
precos: Lista de preços de café
A sua implementação deve retornar uma string com todos os preços que estão abaixo ou igual ao valor mascada ordenados de forma ascendente e separados por ,. Ex:

queroCafe(3.14, [ 5.16, 2.12, 1.15, 3.11, 17.5 ]);
// '1.15,2.12,3.11'
*/

function queroCafe(mascada, array) {
  var ordena = array.sort(function(a, b){return a-b});
  for (var i = 0; i < ordena.length; i++) {
    if (ordena[i] > mascada) {
      ordena.splice(i,1);
      i--;
    }
  }
  console.log(ordena);
}
/*
Vários tipos

Implemente uma função contarPorTipo que recebe dois argumentos:

Objeto que pode ter várias propriedades, de vários tipos diferentes
Uma string com os seguintes possíveis valores:
'string'
'number'
'boolean'
'object'
'undefined'
'null'
'function'
'array'
A função deve contar quantas propriedades dentro do objeto informado no primeiro parâmetro são do tipo do segundo parâmetro.
*/

function contarPorTipo (obj, tipo) {
  var soma = 0;
  for(var i in obj) {
    if(Array.isArray(obj[i]) && tipo === 'array') {
      soma++;
    } else if(obj[i] === null && tipo === 'null') {
      soma++;
    } else if(typeof obj[i] === tipo) {
      soma++;
    }
  }
  console.log(soma);
}

/*
Reflexões

Analise o código abaixo e coloque um comentário no seu arquivo JS explicando o resultado.
*/
var gohan = 'gohan', goku = 'Goku';
function revelarSaiyaman() {
  console.log(gohan);
  goku = 'Son Goku';
  var gohan = 'Son ' + gohan;
  return gohan;
}
console.log(revelarSaiyaman());
console.log(goku);

// O espaco de memoria da variavel e setado anteriormente aos valores da mesma, os valores so são setados quando a execucao chega na linha de atribuicao, quando a function e chamada, a variavel é redeclarada antes mesmo de receber um valor;
