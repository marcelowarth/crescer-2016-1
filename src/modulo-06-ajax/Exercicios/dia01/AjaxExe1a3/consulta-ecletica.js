'use strict';

var resultadoBusca;
var resBuscaURI;
var urlBusca;

$('#btnBuscar').click(
  function() {
    resultadoBusca = $('#txtBusca').val();
    encodaURI();
    buscaArtistaId();
    carregarDadosNaPagina();
  }
);

function encodaURI() {
  resBuscaURI = encodeURI(resultadoBusca);
};

function buscaArtistaId() {
  var urlAppend = 'https://api.spotify.com/v1/artists/' + resBuscaURI +'/albums?limit=50'
  $.ajax({
    url: urlAppend, type: 'GET' })
    .done(function(res){
      urlBusca = 'https://api.spotify.com/v1/artists/' + res.artists.items[0].id + '/albums?limit=50'
    });
}

function carregarDadosNaPagina() {
  $.ajax({ url: urlBusca, type: 'GET' })
  .done(function (res) {
    console.log(res);
    res.items.forEach(function(item){
      item.images.forEach(function(img){
        var imageUrl = img.url;
        $('#divImagens').append(
          $('<img width="300" height="300">').attr('src', imageUrl)
        );
      });
    });
  });
};
