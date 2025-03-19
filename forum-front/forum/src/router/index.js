import Home from '@/views/Home.vue'
import Posts from '@/views/Posts.vue'
import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/rooms/:roomId/posts',
      name: 'Posts',
      component: Posts,
      props: true
    }
  ],
})

export default router
