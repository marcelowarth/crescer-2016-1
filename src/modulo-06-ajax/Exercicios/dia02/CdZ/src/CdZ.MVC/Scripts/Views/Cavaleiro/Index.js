﻿'use strict';

var jaMostrados;

function carregarDadosNaPagina() {
    $.ajax({ url: urlCavaleiroGet, type: 'GET'/*, timeout: 2000 */})
    .then(
        function onSuccess(res) {
            console.log(res.data);
            var $cavaleiros = $('#cavaleiros');
            res.data.forEach(function (cava) {
                jaMostrados = cava.Id;
                $cavaleiros.append(
                    $('<li>').append(cava.Nome)
                );
            });
        },
        function onError(res) {
            console.error(':(');
            console.error(res);

            var criarSpanComErro = function (msg) {
                return $('<span>').text(msg).addClass('erro');
            };

            $('#feedback')
            .append(criarSpanComErro(res.status))
            .append($('<br>'))
            .append(criarSpanComErro(res.statusText));
        }
    )
    .always(function (res) {
        console.log('acabouuuuuuuu');
    });
};
carregarDadosNaPagina();

function registrarEventoDoBotao() {
    $('#btnCriar').click(function () {

        $.ajax({
            url: urlCavaleiroPost,
            type: 'POST',
            data: {
                Nome: 'Xiru ' + new Date().getTime(),
                AlturaCm: 187,
                Signo: 7,
                TipoSanguineo: 1,
                DataNascimento: new Date(),
                Golpes: ['Cólera do Dragão', 'Cólera dos 100 dragões'],
                LocalNascimento: {
                    Texto: 'Beijing'
                },
                LocalTreinamento: {
                    Texto: '5 picos de rosan'
                },
                Imagens: [{
                    Url: 'http://images.uncyc.org/pt/3/37/Shiryumestrepokemon.jpg',
                    IsThumb: true
                }, {
                    Url: 'http://images.uncyc.org/pt/thumb/5/52/Shyryugyarados.jpg/160px-Shyryugyarados.jpg',
                    IsThumb: false
                }]
            }
        });

    });
};
registrarEventoDoBotao();

$(function(){
    setInterval(function verificaNovosRegistros() {
        var d = new Date();
        var cavaNovos;
        $.ajax({
            url: '/Cavaleiro/Get',
            type: 'GET'
        }).done(function (res) {
            cavaNovos = res.data.filter(function (e) {
                e.Id > jaMostrados;
            })
            //TODO: foreach nao funciona
            cavaNovos.forEach(function (cava) {
                console.log('Entrou2');
                jaMostrados = cava.Id;
                $('#cavaleiros').append(
                    $('<li>').append(cava.Nome)
                );
            })
        });
    }, 1000);
})


/*.done(function (res) {
    console.log(res.data);
        var $cavaleiros = $('#cavaleiros');
        res.data.forEach(function (cava) {
            $cavaleiros.append(
                $('<li>').append(cava.Nome)
            );
        });
})
.fail(function (res) {
    console.error(':(');
    console.error(res);

    var criarSpanComErro = function (msg) {
        return $('<span>').text(msg).addClass('erro');
    };

    $('#feedback')
    .append(criarSpanComErro(res.status))
    .append($('<br>'))
    .append(criarSpanComErro(res.statusText));
});*/