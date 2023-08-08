<template>
    <div>
        <BasePicker v-if="editMode" searchApiPath="basic.products/search/Query" searchParameterName="" idField="id" nameField="" path="basic.products" :label="label" v-model="value" @selected="pick" :editMode="editMode" />
        <div v-else>
            <span>{{ value && value.name ? value.name : '' }}</span>
        </div>
    </div>

</template>

<script>
import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'ProductId',
    mixins:[BaseEntity],
    components:{
    },
    data: () => ({
        path: 'basic.products',
    }),
    watch: {
        value(val){
            this.value = val;
            this.change();
        },
    },
    async created(){
        if (this.value && this.value.id !== undefined) {
            this.value = await this.repository.findById(this.value.id)
        }
    },
    methods: {
        pick(val){
            this.value = val;
            this.change();
        },
    }
}
</script>

