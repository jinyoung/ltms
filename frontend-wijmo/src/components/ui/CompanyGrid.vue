<template>
    <div style="max-height:80vh;">
        <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" small color="primary" :disabled="!hasRole('Admin')">
                    <v-icon small>mdi-plus-circle-outline</v-icon>등록
                </v-btn>
                <v-btn  @click="editSelectedRow" small color="primary" :disabled="!hasRole('Admin')">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
                <v-btn @click="openUpdateCompany" small color="primary" :disabled="!hasRole('Admin')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>회사 업데이트
                </v-btn>
                <v-dialog v-model="updateCompanyDiagram" width="500">
                    <UpdateCompanyCommand
                        @closeDialog="closeUpdateCompany"
                        @updateCompany="updateCompany"
                    ></UpdateCompanyCommand>
                </v-dialog>
                <v-btn @click="deleteSelectedRows" small color="primary" :disabled="!hasRole('Admin')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>삭제
                </v-btn>
            <excel-export-button :exportService="this.exportService" :getFlex="getFlex" />
        </div>
        <CompanyQuery @search="search"></CompanyQuery>


        <!-- the grid -->
        <wj-flex-grid
            ref="flexGrid"
            :key="value.length"
            :autoGenerateColumns="false"
            :allowAddNew="false"
            :allowDelete="true"
            :allowPinning="'SingleColumn'"
            :newRowAtTop="false"
            :showMarquee="true"
            :selectionMode="'MultiRange'"
            :validateEdits="false"
            :itemsSource="value"
            :initialized="flexInitialized"
            :selectionChanged="onSelectionChanged"
            style="margin-top:10px; max-height:65vh;"
            class="wj-felx-grid"
        >
            <wj-flex-grid-filter :filterColumns="['RowHeader','name','industry','foundedDate','code',]" />
            <wj-flex-grid-cell-template cellType="RowHeader" v-slot="cell">{{cell.row.index + 1}}</wj-flex-grid-cell-template>
            <wj-flex-grid-column binding="name" header="이름" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="industry" header="산업" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="foundedDate" header="설립일자" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="code" header="회사코드" width="2*" :isReadOnly="true" align="center" />
        </wj-flex-grid>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
                class="add-edit-dialog"
            >
                <template>
                    <v-card>
                        <v-toolbar
                            color="primary"
                            class="elevation-0"
                            height="50px"
                        >
                            <div style="color:white; font-size:17px; font-weight:700;">회사 등록</div>
                            <v-spacer></v-spacer>
                            <v-icon
                                color="white"
                                small
                                @click="closeDialog()"
                            >mdi-close</v-icon>
                        </v-toolbar>
                        <v-card-text>
                            <Company :offline="offline"
                                :isNew="!itemToEdit"
                                :editMode="true"
                                v-model="newValue"
                                @add="append"
                                @edit="edit"
                            />
                        </v-card-text>
                    </v-card>
                </template>
            </v-dialog>
        </v-col>
        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                    width="332.5"
                    fullscreen
                    hide-overlay
                    transition="dialog-bottom-transition"
                >
                    <v-btn
                        style="position:absolute; top:2%; right:2%"
                        @click="closeDialog()"
                        depressed
                        icon 
                        absolute
                    >
                        <v-icon>mdi-close</v-icon>
                    </v-btn>
                </v-dialog>
            </div>
        </v-col>
    </div>
</template>

<script>
import CompanyQuery from '../CompanyQuery.vue';
import Company from '../Company.vue'
import BaseGrid from '../base-ui/BaseGrid'

export default {
    name: 'companyGrid',
    mixins:[BaseGrid],
    components:{
        CompanyQuery,
        Company,
    },
    data: () => ({
        path: 'companies',
    }),
    watch: {
        newValue: {
            deep:true,
            handler:function(){
                if(!this.newValue){
                    this.newValue = {
                        'name': '',
                        'industry': '',
                        'foundedDate': '2023-08-14',
                        'code': '',
                    }
                }
            }
        }
    },
    methods:{
        updateCompany(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "updateCompany", params)
                this.$mainApp.success("UpdateCompany 성공적으로 처리되었습니다.")
            }catch(e){
                this.$mainApp.error(e)
            }
        },
    }
}
</script>