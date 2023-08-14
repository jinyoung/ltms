<template>
    <div>
        <apexchart 
                width="800" 
                :type="type" 
                :options="options"
                :series="series"
                ref="barChart"
        ></apexchart>
    </div>
</template>

<script>
    import VueApexCharts from 'vue-apexcharts';
    const axios = require('axios').default;

    export default {
        name: 'BarchartChart',
        components: {
            'apexchart': VueApexCharts,
        },
        props: {
            value: Object
        },
        data: () => ({
            type: "bar",
            options: {
                chart: {
                    id: "barchart-bar"
                },
                xaxis: {
                    categories: []
                },
            },
            series: [
                {
                    data: []
                }
            ],
            productionByMonth: [],
        }),
        async created() {
            var temp = await axios.get(axios.fixUrl('/productionByMonths'));

            temp.data._embedded.productionByMonths.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1]);

            this.productionByMonth = temp.data._embedded.productionByMonths;
            const categories = [ "yymm" ];
            const data = [ "amount" ];

            if(this.productionByMonth && this.productionByMonth.length > 0) {
                this.productionByMonth.forEach((item) => {
                    if (item) {
                        if (categories && categories.length > 0) {
                            categories.forEach((category) => {
                                if (item[category]) {
                                    this.options.xaxis.categories.push(item[category]);
                                }
                            })
                        }
                        if (data && data.length > 0) {
                            data.forEach((val) => {
                                if (item[val]) {
                                    this.series[0].data.push(item[data]);
                                }
                            })
                        }
                    }
                });
            }

            this.$refs.barChart.refresh();
        },
        methods: {
        }
    }
</script>

