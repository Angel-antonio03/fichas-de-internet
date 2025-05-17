<template>
  <div class="d-flex justify-content-center align-items-center vh-100 bg-light">
    <div class="card p-4 shadow" style="width: 400px; background-color: #1e4b89; border-radius: 12px;">
      <h3 class="text-center text-white mb-4">Iniciar Sesión</h3>

      <div class="mb-3 text-white">
        <label for="inputUsuario" class="form-label">
          <i class="bi bi-person-fill"></i> Usuario:
        </label>
        <input v-model="usuario.usuario" type="text" class="form-control" id="inputUsuario" placeholder="Ingresa tu usuario" />
      </div>

      <div class="mb-4 text-white">
        <label for="inputPassword" class="form-label">
          <i class="bi bi-key-fill"></i> Contraseña:
        </label>
        <input v-model="usuario.contraseña" type="password" class="form-control" id="inputPassword" placeholder="Ingresa tu contraseña" />
      </div>

      <div class="text-danger mb-2" v-if="mensaje">{{ mensaje }}</div>

      <button class="btn btn-primary w-100 mb-3" @click="loginUsuario">
        <i class="bi bi-box-arrow-in-right"></i> Ingreso Usuario
      </button>

      <button class="btn btn-secondary w-100" @click="loginAdmin">
        <i class="bi bi-lock-fill"></i> Ingreso Administrador
      </button>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import axios from 'axios';

const router = useRouter();
const usuario = ref({ usuario: "", contraseña: "" });
const mensaje = ref("");

// Login para usuario (POST a /fichas/login)
const loginUsuario = async () => {
  if (usuario.value.usuario && usuario.value.contraseña) {
    try {
      const response = await axios.post('http://localhost:8080/fichas/login', {
        usuario: usuario.value.usuario,
        contraseña: usuario.value.contraseña
      });
      const ficha = response.data;

      // Guardar datos en localStorage y redirigir
      localStorage.setItem("fichaUsuario", JSON.stringify(ficha));
      router.push('/logeo');
    } catch (error) {
      if (error.response) {
        mensaje.value = error.response.data;
      } else {
        mensaje.value = "Error al conectar con el servidor";
      }
    }
  } else {
    mensaje.value = "Por favor, ingrese usuario y contraseña.";
  }
};

// Login para administrador (validación local)
const loginAdmin = () => {
  const adminUsuario = 'admin';
  const adminPassword = '1234';

  if (usuario.value.usuario === adminUsuario && usuario.value.contraseña === adminPassword) {
    localStorage.setItem('adminAutenticado', 'true');
    router.push('/formulario');
  } else {
    mensaje.value = 'Credenciales de administrador inválidas.';
  }
};
</script>



  