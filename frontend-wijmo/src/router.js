
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import CompanyManager from "./components/ui/CompanyGrid"
//import ProductManager from "./components/ui/ProductGrid"

import SalesOrderManager from "./components/ui/SalesOrderGrid"



<<<<<<< HEAD
//import InventoryManager from "./components/ui/InventoryGrid"
=======
import InventoryManager from "./components/ui/InventoryGrid"
import DeliveryManager from "./components/ui/DeliveryGrid"
import InventoryManager from "./components/ui/InventoryGrid"
>>>>>>> origin/template


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/companies',
                name: 'CompanyManager',
                component: CompanyManager
            },
            // {
            //     path: '/products',
            //     name: 'ProductManager',
            //     component: ProductManager
            // },

            {
                path: '/salesOrders',
                name: 'SalesOrderManager',
                component: SalesOrderManager
            },



            {
                path: '/inventories',
                name: 'InventoryManager',
                component: InventoryManager
            },
            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },
            {
                path: '/inventories',
                name: 'InventoryManager',
                component: InventoryManager
            },



    ]
})
