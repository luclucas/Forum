<script>
import ForumServices from "@/services/ForumServices";
import RoomList from "../components/RoomList.vue";

export default {
    name: 'Home',
    components: {
        RoomList
    },
    data() {
        return {
            rooms: []
        }
    },
    async mounted() {
        try {
            this.rooms = await ForumServices.getRooms()
            console.log(this.rooms)
        } catch (error) {
            console.log(error)
        }
    }
}



</script>


<template>

    <div>
        <room-list :rooms="rooms"></room-list>
    </div>

</template>

<style scoped></style>