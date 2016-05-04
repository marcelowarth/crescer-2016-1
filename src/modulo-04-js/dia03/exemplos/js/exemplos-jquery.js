$.fn.jquery
$('h1')
$('h1').text('Tchau')
$('h1').text()
$('h1').show()
$('h1').hide()
$('h1').toggle()
$('h1:eq(0)')
$('h1:eq(0)').text('oi')
$('h1').eq(0)
$('#headers').remove() // #headers = # + id declarado no html
$('#headers').html('oi')
$('#headers').append($('<h1>').text('novo')) // cria elemento no html
$('#headers').css({})
for (var i = 0; i<5; i++ ) {$('#headers').append($('<h1>').text(i))}
for (var i = 0; i<5; i++ ) {$('#headers').append($('<h1>').text(i).addClass('azul'))}
$('h1').css({'backgorund-color: black;'})
$('<img>').attr('src', url).attr('alt', 'muuuu')
