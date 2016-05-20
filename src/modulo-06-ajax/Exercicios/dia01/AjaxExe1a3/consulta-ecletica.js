'use strict';

$(function() {
  $('#formBusca').submit(function(e) {
    var resultadoBusca = ($('#txtBusca').val());
    var artistaDados = buscaArtistaDados(resultadoBusca).done(
      function(res) {
          var pesquisa = (resultadoBusca === 'justin bieber' && Math.random() < 0.8) ? 'douchebag' : res.artists.items[0].id;
          var artistaCompleto = buscaArtistaCompleto(pesquisa)
            .then(
              function(data) {
                var capa = data.items;
                mostraCapa(capa);
              }, function (data) {
                alert('Caro usuário, devido a um erro '+ data.status +', não foi possível pesquisar por ' + pesquisa);
              });
        });
    return e.preventDefault();
  });
});

function buscaArtistaDados(resultadoBusca) {
  return $.get('https://api.spotify.com/v1/search?q=' + encodeURI(resultadoBusca) + '&type=artist')
};

function buscaArtistaCompleto(id) {
  return $.get('https://api.spotify.com/v1/artists/' + id + '/albums?limit=50');
};

function mostraCapa (capa) {
  capa.forEach(function(e) {
    $('#divImagens').append(
      $('<img>').attr('src', e.images[1].url))
  });
}
