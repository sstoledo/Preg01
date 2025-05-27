$(document).ready(function () {
  $("#btnLogin").click(function (e) {
    e.preventDefault();
    const loginValue = $("#exampleInputEmail").val().trim();
    const password = $("#exampleInputPassword").val().trim();

    if (!loginValue || !password) {
      alert("Por favor, complete ambos campos");
      return;
    }

    const parametros = {
      login: loginValue,
      password: password,
    };

    loginRequest(parametros);
  });
});

function loginRequest(params) {
  fetch("login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(params),
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Error en la red");
      }
      return response.json();
    })
    .then((data) => {
      if (data.success) {
        window.location.href = "principal.html";
      } else if (data.error) {
        alert(data.error);
      } else {
        throw new Error("Respuesta inesperada del servidor");
      }
    })
    .catch((error) => {
      console.error("Error:", error);
      alert(error.message || "Ocurrió un error durante el login");
    });
}
