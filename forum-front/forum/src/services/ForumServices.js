const BASE_URL = "http://localhost:8080/api/v1"

export default {
    async getRooms() {
        try {
            console.log(BASE_URL)

            const response = await fetch(`${BASE_URL}/rooms`)
            console.log(response)
            if (!response.ok) {
                throw new Error('Erro ao buscar salas')
            }
            const data = await response.json()
            return data
        } catch (error) {
            console.error('Erro ao buscar salas:', error)
            throw error
        }
    },

    async getPostsByRoom(roomId) {
        try {
            const response = await fetch(`${BASE_URL}/rooms/${roomId}/posts`)
            if (!response.ok) {
                throw new Error('Erro ao buscar posts')
            }

            const data = await response.json()
            return data

        } catch (error) {
            console.error(`Erro ao buscar posts da sala ${roomId}:`, error);
            throw error;
        }

    }
}