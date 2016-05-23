'use strict';

var _Cavaleiro = new CavaleiroIndexView;
var maiorId = 0;

function CavaleiroIndexView(options) {
    options = options || {};
    this.errorToast = options.errorToast;
    this.successToast = options.successToast;
    this.cavaleirosUi = options.cavaleirosUi;
    this.cavaleiros = new Cavaleiros({
        urlGet: options.urlCavaleiroGet,
        urlGetById: options.urlCavaleiroGetById,
        urlPost: options.urlCavaleiroPost,
        urlDelete: options.urlCavaleiroDelete,
        urlPut: options.urlCavaleiroPut
    });
};

setInterval(function () {
    $.get('/Cavaleiro/Get')
        .done(function onSuccess(res) {
            var qtdNovos = 0;
            res.data.forEach(function (cava) {
                if (cava.Id > maiorId) {
                    $('#cavaleiros').append(_Cavaleiro.criarHtmlCavaleiro(cava));
                    maiorId = cava.Id;
                    qtdNovos++;
                }
            })
            if (qtdNovos != 0) { notificarAoAtualizar(qtdNovos); }
        });
}, 5000);

function notificarAoAtualizar(qtdNovos) {
    Notification.requestPermission().then(function (result) {
        console.log(result);
        if (result === 'granted') {
            var options = {
                body: qtdNovos + ' novos cavaleiros encontrados!',
                icon: 'http://2.bp.blogspot.com/-eyZJ-9Zu0tU/TeZSaLwzd-I/AAAAAAAAAEM/NK1AS_8YCLg/s1600/1+%252850%2529.gif'
            }
            new Notification('', options);
        }
    });
};

CavaleiroIndexView.prototype.render = function () {
    var self = this;

    this.cavaleiros.todos()
        .then(
            function onSuccess(res) {
                res.data.forEach(function (cava) {
                    self.cavaleirosUi.append(
                        self.criarHtmlCavaleiro(cava)
                    )
                    if (cava.Id > maiorId) { maiorId = cava.Id; }
                });
            },
            function onError(res) {
                self.errorToast.show(res.status + ' - ' + res.statusText);
            }
        );
};

CavaleiroIndexView.prototype.criarHtmlCavaleiro = function (cava) {
    return $('<li>')
        .append(cava.Nome)
        .append($('<img>').attr('src', cava.Imagens[0].Url).attr('widht', '100px').attr('height', '100px'))
        .append(
            $('<button>')
                .on('click', { id: cava.Id, self: this }, this.editarCavaleiroNoServidor)
                .text('Editar')
        )
        .append(
            $('<button>')
                .on('click', { id: cava.Id, self: this }, this.excluirCavaleiroNoServidor)
                .text('Excluir')
        );
};


CavaleiroIndexView.prototype.excluirCavaleiroNoServidor = function (e) {
    // dispensamos o uso do atributo 'data-cavaleiro-id' utilizando event.data:
    // pirou? rtfm => http://api.jquery.com/event.data/
    var self = e.data.self;
    self.cavaleiros.excluir(e.data.id);
    $(this).parent('li').remove();
};

CavaleiroIndexView.prototype.editarCavaleiroNoServidor = function (e) {
    var cavaleiroId = e.data.id;
    var self = e.data.self;
    self.cavaleiros.buscar(cavaleiroId)
        .done(function (detalhe) {
            // TODO: Implementar atualização a partir de um formulário ou campos na tela, e não hard-coded
            cavaleiroHardCoded = detalhe.data;
            simularAtualizacaoHardCoded();
            self.cavaleiros.editar(cavaleiroHardCoded);
        });
};
