'use strict';

function carregarDadosNaPagina() {
  $.ajax({ url: 'https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50', type: 'GET' })
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
carregarDadosNaPagina();
