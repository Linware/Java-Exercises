<%-- 
    Document   : index
    Created on : 13-may-2018, 11:41:50
    Author     : Jonan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body class="container">
        <h1>Bienvenida a "BancoServlet".Por favor,seleccione la acción que quiere realizar</h1>
        <h2>--------------------------------------------------------------------</h2>
        <form action="insertarCuenta.html" method="POST">Presiona el botón para insertar una nueva cuenta
            <input type="submit" name="insertCuenta" value="Enviar"></form>
        <form action="validarPropietario.html" method="POST">Presiona el botón para validar un propietario
            <input type="submit" name="validarPropietario" value="Enviar"></form>
        <form action="ServletModificarDatos" method="POST">Presiona el botón para modificar los datos de un propietario
            <input type="submit" name="enviar" value="Enviar"></form>
        <form action="ServletCambiarNumeroSecreto" method="POST">Presiona el botón para cambiar el número secreto
            <input type="submit" name="enviar" value="Enviar"></form>
        <form action="ServletEliminarCuenta" method="POST">Presiona el botón para eliminar una cuenta
            <input type="submit" name="enviar" value="Enviar"></form>
        <h2>--------------------------------------------------------------------</h2>
        <form action="obtenerOperacionesPorID.html" method="POST">Presiona el botón para ver la operacion bancaria a partir de su ID
            <input type="submit" name="obtenerOperacionesPorID" value="Enviar"></form>
        <form action="ServletObtenerListaOperacionesBancarias" method="POST">Presiona el botón para ver todas las operaciones bancarias
            <input type="submit" name="enviar" value="Enviar"></form>
                <form action="ServletInsertarOperacionBancaria" method="POST">Presiona el botón para insertar una operacion bancaria
            <input type="submit" name="ServletInsertarOperacionBancaria" value="Enviar"></form>
        <form action="ServletObtenerNumerosrojos" method="POST">Presiona el botón para ver operaciones con numeros rojos
            <input type="submit" name="ServletObtenerNumerosrojos" value="Enviar"></form>
        <form action="ServletObtenerOperacionesPorCuenta" method="POST">Presiona el botón para ver todas las operaciones por cuenta
            <input type="submit" name="enviar" value="Enviar"></form>
        <h2>--------------------------------------------------------------------</h2>
        <form action="ServletObtenerRankingNumerosRojos" method="POST">Presiona el botón para ver el ranking de números rojos
            <input type="submit" name="enviar" value="Enviar"></form>
        <form action="ServletObtenerPosicionNumerosRojos" method="POST">Presiona el botón para ver la posición de una cuenta en el ranking de números rojos
            <input type="submit" name="enviar" value="Enviar"></form>
        
    </body>
</html>

