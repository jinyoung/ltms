

<template>
    <v-app id="inspire">
        <div>
            <v-snackbar
                v-model="snackbar.status"
                :top="true"
                :timeout="snackbar.timeout"
                :color="snackbar.color"
            >
                {{ snackbar.text }}
                <v-btn dark text @click="snackbar.status = false">
                    Close
                </v-btn>
            </v-snackbar>
            <v-app-bar app clipped-left flat>
                <v-toolbar-title>
                    <span class="second-word font uppercase"
                        style="font-weight:700;"
                    >
                        <v-app-bar-nav-icon
                            @click="openSideBar()"
                            style="z-index:1;
                            height:56px;
                            width:30px;
                            margin-right:10px;
                            font-weight:300;
                            font-size:55px;"
                        >
                            <div style="line-height:100%;">≡</div>
                        </v-app-bar-nav-icon>
                        newtest
                    </span>
                </v-toolbar-title>
                <span v-if="urlPath!=null" 
                    class="mdi mdi-home" 
                    key="" 
                    to="/" 
                    @click="goHome()"
                    style="margin-left:10px; font-size:20px; cursor:pointer;"
                    ></span> 
                <v-spacer></v-spacer>

                <b style="margin-left:10px; font-size:10px">{{username}} 님</b>
                <v-btn
                    text
                    color="deep-purple lighten-2"
                    style="font-size:10px"
                    @click="logout()"
                >
                    Logout
                </v-btn>
            </v-app-bar>

            <v-navigation-drawer app clipped flat v-model="sideBar">
                <v-list>
                    <v-list-group>
                        <template v-slot:activator>
                            <v-list-item-content>
                                <v-list-item-title>기준정보</v-list-item-title>
                            </v-list-item-content>
                        </template>

                        <v-list-item
                            class="px-2"
                            key="companies"
                            to="/companies"
                            @click="changeUrl()"
                            style="font-weight:700;
                            font-size:14px;"
                        >
                            회사
                        </v-list-item>
                        <v-list-item
                            class="px-2"
                            key="products"
                            to="/products"
                            @click="changeUrl()"
                            style="font-weight:700;
                            font-size:14px;"
                        >
                            상품정보
                        </v-list-item>
                    </v-list-group>
                </v-list>
                <v-list>
                    <v-list-group>
                        <template v-slot:activator>
                            <v-list-item-content>
                                <v-list-item-title>영업</v-list-item-title>
                            </v-list-item-content>
                        </template>

                        <v-list-item
                            class="px-2"
                            key="salesOrders"
                            to="/salesOrders"
                            @click="changeUrl()"
                            style="font-weight:700;
                            font-size:14px;"
                        >
                            수주
                        </v-list-item>
                    </v-list-group>
                </v-list>
                <v-list>
                    <v-list-group>
                        <template v-slot:activator>
                            <v-list-item-content>
                                <v-list-item-title>재고</v-list-item-title>
                            </v-list-item-content>
                        </template>

                        <v-list-item
                            class="px-2"
                            key="inventories"
                            to="/inventories"
                            @click="changeUrl()"
                            style="font-weight:700;
                            font-size:14px;"
                        >
                            재고
                        </v-list-item>
                    </v-list-group>
                </v-list>
                <v-list>
                    <v-list-group>
                        <template v-slot:activator>
                            <v-list-item-content>
                                <v-list-item-title>레포트</v-list-item-title>
                            </v-list-item-content>
                        </template>

                        <v-list-item
                            class="px-2"
                            key="productionByMonths"
                            to="/productionByMonths"
                            @click="changeUrl()"
                            style="font-weight:700;
                            font-size:14px;"
                        >
                            월별생산량
                        </v-list-item>

                    </v-list-group>
                </v-list>
            </v-navigation-drawer>
        </div>

        <v-main>
            <v-container v-if="urlPath" style="max-width:100vw !important;" class="py-8 px-6 mt-10" fluid>
                <router-view></router-view>
            </v-container>
            <v-container v-else class="py-8 px-6 mt-10" fluid>
                <v-row>
                        <v-card
                            class="mx-auto"
                            style="height:300px; width:300px; margin-bottom:20px;"
                            outlined
                        >
                            <v-list-item>
                                <v-list-item-avatar 
                                    class="mx-auto"
                                    size="80"
                                    style="margin-top:80px;"
                                ><span class="mdi mdi-apps" style="font-size:60px; color:#9575CD;"></span>
                                </v-list-item-avatar>
                            </v-list-item>

                            <v-card-actions>
                                <v-tooltip bottom>
                                    <template v-slot:activator="{ on }">
                                        <v-btn 
                                            v-on="on"
                                            class="mx-auto"
                                            outlined
                                            rounded
                                            key="companies"
                                            to="/companies"
                                            @click="changeUrl()"
                                            style="font-weight:500; font-size:20px; padding:15px; border:solid 2px; max-width:250px; overflow:hidden"
                                        >
                                            회사
                                        </v-btn>
                                    </template>
                                    <span>회사</span>
                                </v-tooltip>
                            </v-card-actions>
                        </v-card>
                        <v-card
                            class="mx-auto"
                            style="height:300px; width:300px; margin-bottom:20px;"
                            outlined
                        >
                            <v-list-item>
                                <v-list-item-avatar 
                                    class="mx-auto"
                                    size="80"
                                    style="margin-top:80px;"
                                ><span class="mdi mdi-apps" style="font-size:60px; color:#9575CD;"></span>
                                </v-list-item-avatar>
                            </v-list-item>

                            <v-card-actions>
                                <v-tooltip bottom>
                                    <template v-slot:activator="{ on }">
                                        <v-btn 
                                            v-on="on"
                                            class="mx-auto"
                                            outlined
                                            rounded
                                            key="products"
                                            to="/products"
                                            @click="changeUrl()"
                                            style="font-weight:500; font-size:20px; padding:15px; border:solid 2px; max-width:250px; overflow:hidden"
                                        >
                                            상품정보
                                        </v-btn>
                                    </template>
                                    <span>상품정보</span>
                                </v-tooltip>
                            </v-card-actions>
                        </v-card>

                        <v-card
                            class="mx-auto"
                            style="height:300px; width:300px; margin-bottom:20px;"
                            outlined
                        >
                            <v-list-item>
                                <v-list-item-avatar 
                                    class="mx-auto"
                                    size="80"
                                    style="margin-top:80px;"
                                ><span class="mdi mdi-apps" style="font-size:60px; color:#9575CD;"></span>
                                </v-list-item-avatar>
                            </v-list-item>

                            <v-card-actions>
                                <v-tooltip bottom>
                                    <template v-slot:activator="{ on }">
                                        <v-btn 
                                            v-on="on"
                                            class="mx-auto"
                                            outlined
                                            rounded
                                            key="salesOrders"
                                            to="/salesOrders"
                                            @click="changeUrl()"
                                            style="font-weight:500; font-size:20px; padding:15px; border:solid 2px; max-width:250px; overflow:hidden"
                                        >
                                            수주
                                        </v-btn>
                                    </template>
                                    <span>수주</span>
                                </v-tooltip>
                            </v-card-actions>
                        </v-card>



                        <v-card
                            class="mx-auto"
                            style="height:300px; width:300px; margin-bottom:20px;"
                            outlined
                        >
                            <v-list-item>
                                <v-list-item-avatar 
                                    class="mx-auto"
                                    size="80"
                                    style="margin-top:80px;"
                                ><span class="mdi mdi-apps" style="font-size:60px; color:#9575CD;"></span>
                                </v-list-item-avatar>
                            </v-list-item>

                            <v-card-actions>
                                <v-tooltip bottom>
                                    <template v-slot:activator="{ on }">
                                        <v-btn 
                                            v-on="on"
                                            class="mx-auto"
                                            outlined
                                            rounded
                                            key="inventories"
                                            to="/inventories"
                                            @click="changeUrl()"
                                            style="font-weight:500; font-size:20px; padding:15px; border:solid 2px; max-width:250px; overflow:hidden"
                                        >
                                            재고
                                        </v-btn>
                                    </template>
                                    <span>재고</span>
                                </v-tooltip>
                            </v-card-actions>
                        </v-card>


                </v-row>
            </v-container>
        </v-main>
    </v-app>
</template>

<script>
import BaseGrid from './components/base-ui/BaseGrid'
import Vue from 'vue'

export default {
    name: "App",
    mixins:[BaseGrid],
    data: () => ({
        useComponent: "",
        drawer: true,
        components: {},
        sideBar: true,
        urlPath: null,
        snackbar: {
            status: false,
            timeout: 5000,
            text: '',
            color: 'info'
        },
    }),
    
    async created() {
      var path = document.location.href.split("#/")
      this.urlPath = path[1];
    },

    mounted() {
        var me = this;
        me.components = this.$ManagerLists;
        Vue.prototype.$mainApp = this
    },

    methods: {
        openSideBar(){
            this.sideBar = !this.sideBar
        },
        changeUrl() {
            var path = document.location.href.split("#/")
            this.urlPath = path[1];
        },
        goHome() {
            this.urlPath = null;
        },
        error(e){
            this.snackbar.status = true
            this.snackbar.color= 'error'
            if(e.response && e.response.data.message) {
                this.snackbar.text = e.response.data.message
            } else {
                this.snackbar.text = e
            }
        },
        success(msg){
            this.snackbar.color= 'info'
            this.snackbar.status = true
            this.snackbar.text = msg
        }
    }
};
</script>
<style>
</style>
