
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import BasicCompanyManager from "./components/listers/BasicCompanyCards"
import BasicCompanyDetail from "./components/listers/BasicCompanyDetail"
import BasicProductManager from "./components/listers/BasicProductCards"
import BasicProductDetail from "./components/listers/BasicProductDetail"

import CompanyQueryView from "./components/CompanyQueryView"
import CompanyQueryViewDetail from "./components/CompanyQueryViewDetail"
import ProductQueryView from "./components/ProductQueryView"
import ProductQueryViewDetail from "./components/ProductQueryViewDetail"
import SalesSalesOrderManager from "./components/listers/SalesSalesOrderCards"
import SalesSalesOrderDetail from "./components/listers/SalesSalesOrderDetail"



import InventoryInventoryManager from "./components/listers/InventoryInventoryCards"
import InventoryInventoryDetail from "./components/listers/InventoryInventoryDetail"


import ProductionByMonthView from "./components/ProductionByMonthView"
import ProductionByMonthViewDetail from "./components/ProductionByMonthViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/basics/companies',
                name: 'BasicCompanyManager',
                component: BasicCompanyManager
            },
            {
                path: '/basics/companies/:id',
                name: 'BasicCompanyDetail',
                component: BasicCompanyDetail
            },
            {
                path: '/basics/products',
                name: 'BasicProductManager',
                component: BasicProductManager
            },
            {
                path: '/basics/products/:id',
                name: 'BasicProductDetail',
                component: BasicProductDetail
            },

            {
                path: '/companyQueries',
                name: 'CompanyQueryView',
                component: CompanyQueryView
            },
            {
                path: '/companyQueries/:id',
                name: 'CompanyQueryViewDetail',
                component: CompanyQueryViewDetail
            },
            {
                path: '/productQueries',
                name: 'ProductQueryView',
                component: ProductQueryView
            },
            {
                path: '/productQueries/:id',
                name: 'ProductQueryViewDetail',
                component: ProductQueryViewDetail
            },
            {
                path: '/sales/salesOrders',
                name: 'SalesSalesOrderManager',
                component: SalesSalesOrderManager
            },
            {
                path: '/sales/salesOrders/:id',
                name: 'SalesSalesOrderDetail',
                component: SalesSalesOrderDetail
            },



            {
                path: '/inventories/inventories',
                name: 'InventoryInventoryManager',
                component: InventoryInventoryManager
            },
            {
                path: '/inventories/inventories/:id',
                name: 'InventoryInventoryDetail',
                component: InventoryInventoryDetail
            },


            {
                path: '/productionByMonths',
                name: 'ProductionByMonthView',
                component: ProductionByMonthView
            },
            {
                path: '/productionByMonths/:id',
                name: 'ProductionByMonthViewDetail',
                component: ProductionByMonthViewDetail
            },


    ]
})
