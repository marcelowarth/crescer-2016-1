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
  for (var i in array) {
    if(typeof maior === 'undefined') {
      maior = i;
    } else {
      if(maior.lenght < i.lenght) {
        maior = i;
      }
    }
  }
  console.log(maior);
}
