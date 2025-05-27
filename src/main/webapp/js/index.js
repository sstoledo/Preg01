$(document).ready(function () {
    $("#btnLogin").click(function (e) {
        e.preventDefault();
        const email = $("#exampleInputEmail").val();
        const password = $("#exampleInputPassword").val();
        login({ email, password });
    });
});

// función para obtener los valores de usuario y contraseña y enviarlos al servlet 'login' por POST usando fetch
function login(params) {
    fetch('login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: `email=${encodeURIComponent(params.email)}&password=${encodeURIComponent(params.password)}`
    })
        .then(response => {
            if (response.redirected) {
                window.location.href = response.url;
            } else if (response.ok) {
                return response.text();
            } else {
                throw new Error('Login failed');
            }
        })
        .then(data => {
            // Puedes manejar la respuesta aquí si no hay redirección
            // Por ejemplo, mostrar un mensaje de error
            if (data) {
                alert(data);
            }
        })
        .catch(error => {
            alert('Error: ' + error.message);
        });
}