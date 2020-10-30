<template>
    <div>
        <div id="main"></div>
    </div>
</template>

<script>
    import {graph} from '../assets/js/LineChart.js'
    export default {
        data () {
            return {
                jsonObj: {}
            }
        },
        mounted() {
            this.getData(),
            setTimeout(() => {
                this.graph(this.jsonObj)
            }, 500)
        },
        methods: {
            async getData(){
                let  {data}  = await this.$get("/data/公司营收情况.json");
                this.jsonObj = data
            },
            graph
        }
    }
</script>


<style scoped>
    #main {
        width: 100%;
        height: 400px;
        border: 1px solid black;
        margin: 0 auto;
    }
</style>