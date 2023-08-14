<template>
    <div>
        <BasePicker v-if="editMode" searchApiPath="products/search/findByProductQuery" searchParameterName="name" idField="id" nameField="name" path="products" label="ProductId" v-model="value" @selected="pick" :editMode="editMode" />
        <div v-else @click="toggleEditMode">
            <span>{{ value && value.name ? value.name : value }}</span>
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
        path: 'products',
        originalEditMode: false
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
        this.originalEditMode = this.editMode
    },
    methods: {
        toggleEditMode(){
            if(this.originalEditMode){
                this.editMode = !this.editMode
            }
        },
        pick(val){
            this.value = val;
            this.change();
            this.toggleEditMode()
        },
    }
}
</script>

