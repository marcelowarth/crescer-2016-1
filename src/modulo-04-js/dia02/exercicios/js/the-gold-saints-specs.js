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
