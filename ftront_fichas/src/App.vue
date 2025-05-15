<template>
  <router-view />
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const fichas = ref([]);

const cargarFichas = async () => {
  const responde = await axios.get('http://localhost:8080/fichas/TraerFichas');
  fichas.value = responde.data;
  console.log(fichas.value);
};

onMounted(cargarFichas);
</script>







