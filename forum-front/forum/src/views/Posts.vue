<template>
    <posts-list :posts="posts"/>
</template>

<script>
import ForumServices from '@/services/ForumServices';
import PostsList from '../components/PostsList.vue';

export default {
    name: 'Posts', 
    components:{
        PostsList
    },
    data() {
        return {
            posts: []
        }
    },

    async created(){
        const roomId = this.$route.params.roomId

        try {
            this.posts = await ForumServices.getPostsByRoom(roomId)
        } catch (error){
            console.log(error)
        }
    }
}

</script>