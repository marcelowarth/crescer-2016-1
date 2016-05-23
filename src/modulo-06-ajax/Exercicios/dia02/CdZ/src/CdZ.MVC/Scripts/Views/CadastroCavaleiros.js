'use strict';

$(function () {

    $('#btnAdicionarImg').click(function () {
        $('#novasImagens').append(gerarElementoLiComInputs());
    });

    $('#btnAdicionarGolpe').click(function () {
        $('#novosGolpes').append(gerarElementoLiComInputTexto());
    });

    function gerarElementoLiComInputs() {
        var $novoTxt = $('<input>').attr('name', 'urlImagem').attr('type', 'text').attr('placeholder', 'Ex: bit.ly/shiryu.png').addClass('form-control');
        var $novoCheckbox =
          $('<label>').append(
            $('<input>')
            .attr('type', 'checkbox')
            .attr('name', 'isThumb')
            .attr('checked', 'checked')
          ).append('É thumbnail?');
        return $('<li>').append($novoTxt).append($novoCheckbox);
    };

    function gerarElementoLiComInputTexto() {
        var $novoTxt = $('<input>').attr('name', 'golpe').attr('type', 'text').attr('placeholder', 'Ex: Pó de diamante').addClass('form-control');
        return $('<li>').append($novoTxt);
    };

    // Adicionar datepicker

    $('#txtDtNascimento').datepicker({
        dateFormat: 'dd/mm/yy',
        changeYear: true,
        yearRange: "1900:2016"
    });

    // Inicio do cadastro

    function adicionarCavaleiroNoServidor(cavaleiro) {
        $.ajax({
            url: urlCavaleiroPost,
            type: 'POST',
            data: cavaleiro
        }).done(function (res) {
            $.get('/Cavaleiro/GetById', { id: res.id })
            .done(function (res) {
                cavaleiro = res.data;
            });
        });
    }

    var $frmNovoCavaleiro = $('#frmNovoCavaleiro');
    $frmNovoCavaleiro.submit(function (e) {
        var cavaleiro = converterFormParaCavaleiro($frmNovoCavaleiro);
        adicionarCavaleiroNoServidor(cavaleiro);
        $frmNovoCavaleiro[0].reset();
        return e.preventDefault();
    });

    function converterFormParaCavaleiro($form) {
        var formData = new FormData($form[0]);
        var data = $('#txtDtNascimento').datepicker('getDate');
        var localNascimento = { Texto: formData.get('localNascimento') };
        var localTreinamento = { Texto: formData.get('localTreinamento') };

        var temThumb = false;
        var novasImagens = [{ url: 'https://i.ytimg.com/vi/trKzSiBOqt4/hqdefault.jpg', isThumb: true }];
        $('#novasImagens li').each(function () {
            var imagem = {
                url: $(this).find('input[name=urlImagem]').val(),
                isThumb: $(this).find('input[name=isThumb]').is(':checked')
            };

            
            if (imagem.isThumb) {
                novasImagens.push(imagem);
                temThumb = true;
            } else {
                novasImagens.push(novasImagens);
                temThumb = true;
            }
        });

        if (novasImagens.length >= 2 && temThumb) {
            novasImagens.shift();
        };

        var novosGolpes = [{ Nome: null }];
        $('#novosGolpes li').each(function (i) {
            novosGolpes.push({ Nome: $(this).find('input[name=golpe]').val() });
        });

        if (novosGolpes.length >= 2) {
            novosGolpes.shift();
        };

        return {
            nome: formData.get('nome'),
            tipoSanguineo: formData.get('tipoSanguineo'),
            imagens: novasImagens,
            dataNascimento: (data || new Date()).toISOString(),
            alturaCm: parseFloat(formData.get('alturaMetros')) * 100,
            pesoLb: parseFloat(formData.get('pesoKg')) * 2.20462262,
            signo: formData.get('signo'),
            localNascimento: localNascimento,
            localTreinamento: localTreinamento,
            golpes: novosGolpes
        };
    };

});