<template>

    <v-card outlined>
        <v-card-title>
            Produce
        </v-card-title>

        <v-card-text>
            <Date label="제조일자" v-model="value.productionDate" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="produce"
            >
                Produce
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'ProduceCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.productionDate = '2023-08-14';
        },
        watch: {
        },
        methods: {
            produce() {
                this.change()
                this.$emit('produce', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

