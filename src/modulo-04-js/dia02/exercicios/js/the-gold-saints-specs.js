'use stricts';

describe('Ex1. Doadores de sangue', function () {
  it('deve retornar 3 objetos', function() {
    expect(obterDoadores()).toEqual([goldSaints[4], goldSaints[8], goldSaints[11]]);
  });
});

describe('Ex2. Canivete suíço', function () {
  it('deve retornar cavaleiro Shaka', function() {
    expect(obterCavaleiroComMaisGolpes()).toEqual(goldSaints[5]);
  });
});

describe('Ex 3. Aniversários', function () {
    it("deve retornar Março, Maio e Novembro", function () {
        expect(obterMesesComMaisAniversarios()).toEqual(["Março", "Maio", "Novembro"]);
    });
});

describe('Ex4. Altura média', function () {
  it('altura media deve ser 1.85', function() {
    expect(obterAlturaMedia()).toEqual(1.85);
  });
});

describe('Ex5. Altura mediana', function () {
  it('altura mediana deve ser 1.84', function() {
    expect(obterAlturaMediana()).toEqual(1.84);
  });
});

describe('Ex6. Peso médio', function () {
  it('Peso médio A = 84.27', function() {
    expect(obterPesoMedio()).toEqual(84.27);
  });
  it('Peso médio B = 80.67', function() {
    expect(obterPesoMedioDoadores()).toEqual(80.67);
  });
});

describe('Ex7. IMC', function () {
  it('IMC de todos', function() {
    expect(obterIMC()).toEqual([ 22.64, 29.48, 24.62, 24.22, 24.84, 20.53, 24.54, 24.31, 23.99, 22.45, 21.5 ]);
  });
});

describe('Ex8. Sobrepeso', function () {
  it('deve retornar cavaleiro Aldebaran', function() {
    expect(obterSobrepeso()).toEqual([goldSaints[1]]);
  });
});
