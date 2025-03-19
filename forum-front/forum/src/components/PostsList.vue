<script>
export default {
    name: 'PostsList',
    props: {
        posts: Array
    }
};

</script>

<template>

<div>
    <ul>
        <li v-for="post in posts" :key="post.id">
            {{ post.titulo }}
        </li>
    </ul>
</div>


</template>

<style scoped>
li {
    color: black;
}

ul {
    list-style: none;
}
</style>