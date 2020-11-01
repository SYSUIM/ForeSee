<template>
    <div>
        <div id="main"></div>
    </div>
</template>

<script>
    import {graph} from '../assets/js/LineChart.js'
    export default {
        props: ['jsonObj'],
        mounted() {
            setTimeout(() => {
                this.graph(this.jsonObj)
            }, 500)
        },
        methods: {
            graph
        }
    }
</script>


<style scoped>
    #main {
        width: 100%;
        height: 400px;
        border: 1px solid #EBEEF5;
        margin: 0 auto;
        margin-top: 30px;
    }
</style>