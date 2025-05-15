<template>
  <div class="d-flex justify-content-center align-items-center vh-100 bg-light">
    <div class="card p-4 shadow" style="width: 400px; background-color: #1e4b89; border-radius: 12px;">
      <h3 class="text-center text-white mb-4">Iniciar Sesión</h3>

      <!-- Formulario de login -->
      <div class="mb-3 text-white">
        <label for="inputID" class="form-label">
          <i class="bi bi-person-fill"></i> ID:
        </label>
        <input v-model="usuario.id" type="text" class="form-control" id="inputID" placeholder="Ingresa tu ID">
      </div>

      <div class="mb-4 text-white">
        <label for="inputPassword" class="form-label">
          <i class="bi bi-key-fill"></i> Contraseña:
        </label>
        <input v-model="usuario.contraseña" type="password" class="form-control" id="inputPassword" placeholder="Ingresa tu contraseña">
      </div>

      <div class="text-danger mb-2" v-if="mensaje">{{ mensaje }}</div>

      <button class="btn btn-primary w-100" @click="login">
        <i class="bi bi-box-arrow-in-right"></i> Ingresar
      </button>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const usuario = ref({ id: "", contraseña: "" });
const mensaje = ref("");

const login = () => {
  if (usuario.value.id && usuario.value.contraseña) {
    // Puedes guardar al usuario si lo deseas
    localStorage.setItem("usuario", JSON.stringify(usuario.value));
    // Redireccionar a la ruta /logeo
    router.push('/logeo');
  } else {
    mensaje.value = "Por favor, ingrese su ID y contraseña.";
  }
};
</script>
