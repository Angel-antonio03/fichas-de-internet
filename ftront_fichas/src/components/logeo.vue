<template>
  <div class="container py-5" v-if="ficha">
    <h2 class="text-center mb-4 text-primary">Resumen</h2>
    <div class="row justify-content-center g-4">

      <!-- Tarjeta 1 -->
      <div class="col-md-4">
        <div class="card shadow p-3">
          <h5 class="text-success text-center mb-3">
            <i class="bi bi-person-check-fill"></i> Bienvenido, {{ ficha.usuario }}
          </h5>
          <p><i class="bi bi-calendar2-week-fill"></i> <strong>Fecha de Inicio:</strong> {{ ficha.fechaInicio || 'N/A' }}</p>
          <p><i class="bi bi-hourglass-split"></i> <strong>Duración:</strong> {{ ficha.tiempo }}</p>
        </div>
      </div>

      <!-- Tarjeta 2 -->
      <div class="col-md-4">
        <div class="card shadow p-3">
          <h5 class="text-info text-center mb-3">
            <i class="bi bi-upload"></i> Consumo de Datos
          </h5>
          <p><i class="bi bi-cloud-download-fill"></i> <strong>Descargados:</strong> {{ ficha.datosDescargados || 'N/A' }}</p>
          <p><i class="bi bi-cloud-upload-fill"></i> <strong>Subidos:</strong> {{ ficha.datosSubidos || 'N/A' }}</p>
        </div>
      </div>

      <!-- Tarjeta 3 -->
      <div class="col-md-4">
        <div class="card shadow p-3">
          <h5 class="text-warning text-center mb-3">
            <i class="bi bi-speedometer2"></i> Velocidad de Internet
          </h5>
          <p><i class="bi bi-wifi"></i> <strong>Velocidad Actual:</strong> {{ ficha.velocidadActual || ficha.velocidadInternet }}</p>
          <p><i class="bi bi-wifi-2"></i> <strong>Estabilidad:</strong> {{ ficha.estabilidad || 'N/A' }}</p>
        </div>
      </div>

      <!-- Tarjeta 4 -->
      <div class="col-md-4">
        <div class="card shadow p-3">
          <h5 class="text-secondary text-center mb-3">
            <i class="bi bi-geo-alt-fill"></i> Ubicación
          </h5>
          <p><i class="bi bi-globe"></i> <strong>País:</strong> {{ ficha.pais || 'N/A' }}</p>
          <p><i class="bi bi-compass"></i> <strong>IP Pública:</strong> {{ ficha.ipPublica || 'N/A' }}</p>
        </div>
      </div>

      <!-- Tarjeta 5 -->
      <div class="col-md-4">
        <div class="card shadow p-3">
          <h5 class="text-danger text-center mb-3">
            <i class="bi bi-shield-lock-fill"></i> Seguridad
          </h5>
          <p><i class="bi bi-shield-check"></i> <strong>Estado:</strong> {{ ficha.estadoSeguridad || 'N/A' }}</p>
          <p><i class="bi bi-lock-fill"></i> <strong>HTTPS:</strong> {{ ficha.httpsActivo || 'N/A' }}</p>
        </div>
      </div>

    </div>
  </div>

  <div v-else class="text-center py-5">
    <h4>No hay datos para mostrar. Por favor inicia sesión.</h4>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';

const ficha = ref(null);

onMounted(() => {
  const storedFicha = localStorage.getItem("fichaUsuario");
  if (storedFicha) {
    ficha.value = JSON.parse(storedFicha);
  }
});
</script>
