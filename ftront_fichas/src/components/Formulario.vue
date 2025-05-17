<template>
  <div class="container py-5">
    <div class="card shadow p-4">
      <h2 class="mb-4 text-center">Formulario de Fichas</h2>
      <form @submit.prevent="guardarFicha" class="row g-3">

        <div class="col-md-6">
          <label class="form-label">Usuario</label>
          <input v-model="ficha.usuario" type="text" class="form-control" required />
        </div>

        <div class="col-md-6">
          <label class="form-label">Contraseña</label>
          <input v-model="ficha.contraseña" type="password" class="form-control" required />
        </div>

        <div class="col-md-6">
          <label class="form-label">Tiempo</label>
          <input v-model="ficha.tiempo" type="text" class="form-control" />
        </div>

        <div class="col-md-6">
          <label class="form-label">Velocidad Internet</label>
          <input v-model="ficha.velocidadInternet" type="text" class="form-control" />
        </div>

        <div class="col-md-6">
          <label class="form-label">Fecha Inicio</label>
          <input v-model="ficha.fechaInicio" type="date" class="form-control" />
        </div>

        <div class="col-md-6">
          <label class="form-label">Datos Descargados</label>
          <input v-model="ficha.datosDescargados" type="text" class="form-control" />
        </div>

        <div class="col-md-6">
          <label class="form-label">Datos Subidos</label>
          <input v-model="ficha.datosSubidos" type="text" class="form-control" />
        </div>

        <div class="col-md-6">
          <label class="form-label">Velocidad Actual</label>
          <input v-model="ficha.velocidadActual" type="text" class="form-control" />
        </div>

        <div class="col-md-6">
          <label class="form-label">Estabilidad</label>
          <input v-model="ficha.estabilidad" type="text" class="form-control" />
        </div>

        <div class="col-md-6">
          <label class="form-label">País</label>
          <input v-model="ficha.pais" type="text" class="form-control" />
        </div>

        <div class="col-md-6">
          <label class="form-label">IP Pública</label>
          <input v-model="ficha.ipPublica" type="text" class="form-control" />
        </div>

        <div class="col-md-6">
          <label class="form-label">Estado Seguridad</label>
          <input v-model="ficha.estadoSeguridad" type="text" class="form-control" />
        </div>

        <div class="col-md-6">
          <label class="form-label">HTTPS</label>
          <input v-model="ficha.httpsActivo" type="text" class="form-control" />
        </div>

        <div class="col-12 text-center mt-4">
          <button type="submit" class="btn btn-primary px-5">
            <i class="bi bi-save"></i> {{ editando ? 'Actualizar Ficha' : 'Guardar Ficha' }}
          </button>
          <button
            v-if="editando"
            type="button"
            class="btn btn-secondary px-4 ms-2"
            @click="cancelarEdicion"
          >
            <i class="bi bi-x-circle"></i> Cancelar
          </button>
        </div>
      </form>
    </div>

    <!-- Tabla de fichas -->
    <div class="card shadow mt-5 p-4">
      <h3 class="mb-3 text-center">Fichas Guardadas</h3>
      <div v-if="fichas.length === 0" class="text-center text-muted">No hay fichas guardadas aún.</div>
      <div v-else class="table-responsive">
        <table class="table table-striped table-hover align-middle">
          <thead class="table-dark">
            <tr>
                <th>Usuario</th>
                <th>Contraseña</th>
                <th>Tiempo</th>
                <th>Velocidad Internet</th>
                <th>Fecha Inicio</th>
                <th>Datos Descargados</th>
                <th>Datos Subidos</th>
                <th>Velocidad Actual</th>
                <th>Estabilidad</th>
                <th>País</th>
                <th>IP Pública</th>
                <th>Estado Seguridad</th>
                <th>HTTPS</th>
                <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(f, index) in fichas" :key="f.id || index">
              <td>{{ f.usuario }}</td>
                <td>{{ f.contraseña }}</td>
                <td>{{ f.tiempo }}</td>
                <td>{{ f.velocidadInternet }}</td>
                <td>{{ f.fechaInicio }}</td>
                <td>{{ f.datosDescargados }}</td>
                <td>{{ f.datosSubidos }}</td>
                <td>{{ f.velocidadActual }}</td>
                <td>{{ f.estabilidad }}</td>
                <td>{{ f.pais }}</td>
                <td>{{ f.ipPublica }}</td>
                <td>{{ f.estadoSeguridad }}</td>
                <td>{{ f.httpsActivo }}</td>
              <td>
                <button class="btn btn-sm btn-warning me-2" @click="editarFicha(f)">
                  <i class="bi bi-pencil-square"></i> Editar
                </button>
                <button class="btn btn-sm btn-danger" @click="eliminarFicha(f.id)">
                  <i class="bi bi-trash"></i> Eliminar
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const ficha = ref({
  usuario: '',
  contraseña: '',
  tiempo: '',
  velocidadInternet: '',
  fechaInicio: '',
  datosDescargados: '',
  datosSubidos: '',
  velocidadActual: '',
  estabilidad: '',
  pais: '',
  ipPublica: '',
  estadoSeguridad: '',
  httpsActivo: ''
})

const fichas = ref([])
const editando = ref(false)
const idEditando = ref(null)

const limpiarFicha = () => {
  ficha.value = {
    usuario: '',
    contraseña: '',
    tiempo: '',
    velocidadInternet: '',
    fechaInicio: '',
    datosDescargados: '',
    datosSubidos: '',
    velocidadActual: '',
    estabilidad: '',
    pais: '',
    ipPublica: '',
    estadoSeguridad: '',
    httpsActivo: ''
  }
}

const cargarFichas = async () => {
  try {
    const res = await axios.get('http://localhost:8080/fichas/TraerFichas')
    fichas.value = res.data
  } catch (error) {
    alert('Error al cargar fichas: ' + error.message)
  }
}

const guardarFicha = async () => {
  try {
    if (editando.value) {
      await axios.put(`http://localhost:8080/fichas/ModificarFichas/${idEditando.value}`, ficha.value)
      alert('Ficha actualizada correctamente')
      editando.value = false
      idEditando.value = null
    } else {
      await axios.post('http://localhost:8080/fichas/CrearFichas', ficha.value)
      alert('Ficha guardada correctamente')
    }
    limpiarFicha()
    await cargarFichas() // ✅ Refresca la tabla tras guardar
  } catch (error) {
    alert('Error al guardar la ficha: ' + error.message)
  }
}

const editarFicha = (f) => {
  ficha.value = { ...f }
  editando.value = true
  idEditando.value = f.id
}

const cancelarEdicion = () => {
  limpiarFicha()
  editando.value = false
  idEditando.value = null
}

const eliminarFicha = async (id) => {
  if (confirm('¿Estás seguro de eliminar esta ficha?')) {
    try {
      await axios.delete(`http://localhost:8080/fichas/EliminarFichas/${id}`)
      alert('Ficha eliminada correctamente')
      await cargarFichas()
    } catch (error) {
      alert('Error al eliminar ficha: ' + error.message)
    }
  }
}

onMounted(() => {
  cargarFichas()
})
</script>


<style scoped>
.container {
  max-width: 1000px;
}

h2, h3 {
  color: #1e4b89;
}

.btn-primary {
  background-color: #1e4b89;
  border: none;
}

.btn-primary:hover {
  background-color: #144072;
}

.btn-secondary {
  background-color: #6c757d;
  border: none;
}

.btn-secondary:hover {
  background-color: #5a6268;
}

.table-dark {
  background-color: #1e4b89 !important;
}

.table-striped > tbody > tr:nth-of-type(odd) {
  background-color: #f2f6fc;
}

.table-hover tbody tr:hover {
  background-color: #dbe4f7;
}
.table-responsive {
  overflow-x: auto;
  -webkit-overflow-scrolling: touch;
}

table {
  width: 100%;
  border-collapse: collapse;
  font-size: 0.9rem;
}

table th, table td {
  min-width: 120px;
  padding: 8px 12px;
  text-align: center;
  vertical-align: middle;
  white-space: nowrap;
  border-bottom: 1px solid #ddd;
}

table tbody tr {
  height: 48px;
}

td {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  max-width: 150px;
}
table tbody tr td:not(:last-child) {
  max-width: 150px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

table tbody tr td:last-child {
  max-width: none;
  white-space: nowrap;
  overflow: visible;
  text-align: center;

  display: flex;
  justify-content: center;
  gap: 8px;
}

</style>
