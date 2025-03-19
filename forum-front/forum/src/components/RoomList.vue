<script>
export default {
    name: 'RoomList',
    props: {
        rooms: Array
    }
};

</script>


<template>

    <div>
        <ul>
            <li v-for="room in rooms" :key="room.id">
                <router-link :to="`/rooms/${room.id}/posts`">{{ room.nome }}</router-link>
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