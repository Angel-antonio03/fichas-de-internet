

import { createRouter, createWebHistory } from 'vue-router';
import iniciosecion from '../components/iniciosecion.vue';
import logeo from '../components/logeo.vue';

const routes = [
  { path: '/', component: iniciosecion },
  { path: '/logeo', component: logeo }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
