$(document).ready(function () {
  $("#btnLogin").click(function (e) {
    e.preventDefault();
    const login = $("#exampleInputEmail").val().trim();
    const password = $("#exampleInputPassword").val().trim();

    // Basic client-side validation
    if (!login || !password) {
      alert("Por favor, complete ambos campos");
      return;
    }

    const parametros = {
      login: login,
      password: password,
    };

    login(parametros);
  });
});

function login(params) {
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
        // Login successful - redirect
        window.location.href = "principal.html";
      } else if (data.error) {
        // Show error message from server
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
