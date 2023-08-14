
<template>

    <v-data-table
        :headers="headers"
        :items="productionByMonth"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ProductionByMonthView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "yymm", value: "yymm" },
                { text: "amount", value: "amount" },
                { text: "year", value: "year" },
                { text: "month", value: "month" },
            ],
            productionByMonth : [],
        }),
        async created() {
            var me = this;
            setInterval(function(){me.load()}, 1000);
        },
        methods: {
            async load() {
                var temp = await axios.get(axios.fixUrl('/productionByMonths'))

                temp.data._embedded.productionByMonths.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

                this.productionByMonth = temp.data._embedded.productionByMonths;
            }
        }
    }
</script>

