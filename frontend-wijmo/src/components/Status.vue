<template>
    <div style="margin: 0 -15px 0 -15px;">
        <v-card-text>
            <div v-if="editMode" style="margin-top:-20px;">
                <v-select
                    v-model="newValue"
                    :label="label"
                    :items="statusList"
                ></v-select>
            </div>
            <div v-else style="margin-top:-20px;">
                Status : {{ value }}
            </div>
        </v-card-text>
    </div>
</template>

<script>
import BaseEntity from './base-ui/BaseEntity.vue';

export default {
    name: 'Status',
    mixins:[BaseEntity],
    components:{},
    props: {
        label: String
    },
    data: () => ({
        statusList : [ "Delivered",  "InProduction",  "Ready", ],
        newValue: '',
    }),
    async created() {
        if(!this.value) {
            this.newValue = this.statusList[0];
        } else {
            this.newValue = this.value;
        }
    },
    watch: {
        value(val) {
            this.$emit('input', val);
        },
        newValue(val) {
            this.$emit('input', val);
        },
    },
    methods: {
    }
}
</script>

