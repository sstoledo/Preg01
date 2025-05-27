$(document).ready(function () {

});

// funcion para obtener los valores de usuario y contraseña
function login(params) {
    $("#exampleInputEmail").val(params.email);
    $("#exampleInputPassword").val(params.password);
    $(".user").submit();
}