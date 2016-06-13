<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java Aula 5</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">
            <h1>Java Aula 5</h1>

            <form action="pessoa" method="POST">
                <div class="form-group">
                    <label>Nome</label>
                    <input class="form-control" id="txtNome" name="nome" type="text">
                </div>
                <div class="form-group">
                    <label>Idade</label>
                    <input class="form-control" name="idade" type="number">
                </div>
                <div class="form-group">
                    <label>Sexo</label>
                    <label class="radio-inline">
                        <input type="radio" name="optradio">Masculino
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="optradio">Feminino
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="optradio">Outros
                    </label>
                </div>
                <button class="btn">Enviar</button>
            </form>
        </div>
    </body>
</html>
