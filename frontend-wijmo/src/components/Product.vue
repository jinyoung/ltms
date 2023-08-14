<template>
    <div>
        <div class="label-title">제품명</div>
        <String label="제품명" v-model="value.name" :editMode="editMode"/>
        <div class="label-title">제품코드</div>
        <String label="제품코드" v-model="value.code" :editMode="editMode"/>
        <div class="label-title">제품규격</div>
        <String label="제품규격" v-model="value.spec" :editMode="editMode"/>
        <div class="label-title" style="color: black">제품상태</div>
        <Status offline label="제품상태" v-model="value.status" :editMode="editMode" @change="change"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'Product',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "products"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

