<template>
  <div class="container py-5">
    <h2 class="mb-4">Formulario de Datos de Sesión</h2>
    <form @submit.prevent="guardarDatos">

      <!-- Usuario -->
      <div class="mb-3">
        <label class="form-label">Usuario</label>
        <input v-model="form.usuario" type="text" class="form-control" placeholder="Nombre de usuario" required />
      </div>

      <!-- Fecha de Inicio -->
      <div class="mb-3">
        <label class="form-label">Fecha de Inicio</label>
        <input v-model="form.fechaInicio" type="date" class="form-control" required />
      </div>

      <!-- Duración -->
      <div class="mb-3">
        <label class="form-label">Duración (ej: 1h 30m)</label>
        <input v-model="form.tiempo" type="text" class="form-control" placeholder="Duración de la sesión" />
      </div>

      <!-- Datos Descargados -->
      <div class="mb-3">
        <label class="form-label">Datos Descargados (MB)</label>
        <input v-model="form.datosDescargados" type="number" class="form-control" min="0" />
      </div>

      <!-- Datos Subidos -->
      <div class="mb-3">
        <label class="form-label">Datos Subidos (MB)</label>
        <input v-model="form.datosSubidos" type="number" class="form-control" min="0" />
      </div>

      <!-- Velocidad Actual -->
      <div class="mb-3">
        <label class="form-label">Velocidad Actual (Mbps)</label>
        <input v-model="form.velocidadActual" type="number" class="form-control" min="0" step="0.1" />
      </div>

      <!-- Estabilidad -->
      <div class="mb-3">
        <label class="form-label">Estabilidad</label>
        <input v-model="form.estabilidad" type="text" class="form-control" placeholder="Ej: Buena, Regular, Mala" />
      </div>

      <!-- País -->
      <div class="mb-3">
        <label class="form-label">País</label>
        <input v-model="form.pais" type="text" class="form-control" placeholder="País" />
      </div>

      <!-- IP Pública -->
      <div class="mb-3">
        <label class="form-label">IP Pública</label>
        <input v-model="form.ipPublica" type="text" class="form-control" placeholder="IP Pública" />
      </div>

      <!-- Estado Seguridad -->
      <div class="mb-3">
        <label class="form-label">Estado de Seguridad</label>
        <input v-model="form.estadoSeguridad" type="text" class="form-control" placeholder="Ej: Seguro, Riesgoso" />
      </div>

      <!-- HTTPS Activo -->
      <div class="mb-3">
        <label class="form-label">HTTPS Activo</label>
        <select v-model="form.httpsActivo" class="form-select">
          <option value="">Seleccione</option>
          <option value="Sí">Sí</option>
          <option value="No">No</option>
        </select>
      </div>

      <button type="submit" class="btn btn-primary">Guardar Datos</button>
    </form>
  </div>
</template>

<script setup>
import { reactive } from 'vue';

const form = reactive({
  usuario: '',
  fechaInicio: '',
  tiempo: '',
  datosDescargados: null,
  datosSubidos: null,
  velocidadActual: null,
  estabilidad: '',
  pais: '',
  ipPublica: '',
  estadoSeguridad: '',
  httpsActivo: ''
});

const guardarDatos = () => {
  localStorage.setItem('fichaUsuario', JSON.stringify(form));
  alert('Datos guardados correctamente.');
};
</script>
