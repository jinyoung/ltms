<template>

    <v-card outlined>
        <v-card-title>
            ProductionByMonth # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Yymm" v-model="item.yymm" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Amount" v-model="item.amount" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Year" v-model="item.year" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Month" v-model="item.month" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'ProductionByMonthViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/productionByMonths/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

