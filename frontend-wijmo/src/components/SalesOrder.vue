<template>
    <div>
        <div class="label-title">수주 번호</div>
        <String label="수주 번호" v-model="value.salesOrderNumber" :editMode="editMode"/>
        <div class="수주담당자">수주 담당자</div>
        <String label="입력하세요" v-model="value.salesPerson" :editMode="editMode"/>
        <SalesType offline label="수주유형" v-model="value.salesType" :editMode="editMode" @change="change"/>
        <CompanyId offline label="고객사" v-model="value.companyId" :editMode="editMode" @change="change"/>
        <Status offline label="상태" v-model="value.status" :editMode="editMode" @change="change"/>
        <div class="label-title">수주상세</div>
        <SalesItemsDetailGrid label="" offline v-model="value.salesItems" :editMode="editMode" @change="change"/>

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
    name: 'SalesOrder',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "salesOrders"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

