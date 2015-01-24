/**
 * Created by eron on 17/01/15.
 */
Ext.define('MyApp.model.Company', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id',  type: 'string'},
        {name: 'name',   type: 'string'}
    ],proxy: {
        type:'rest',
        reader:{
            type:'json',
            rootProperty:'companies',
            totalProperty:'total'
        },
        api:{
            read:'/webapp-2.1.1-RELEASE/AllCompany'
        }
    }
});