

import { createRouter, createWebHistory } from 'vue-router';
import iniciosecion from '../components/iniciosecion.vue'; 
import logeo from '../components/logeo.vue';
import GestionFichas from '../components/GestionFichas.vue';
import Formulario from '../components/Formulario.vue';

const routes = [
  { path: '/', component: iniciosecion },
  { path: '/logeo', component: logeo },
  { path: '/Gestionfichas', component: GestionFichas },
  {path: '/Formulario', component: Formulario},
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
