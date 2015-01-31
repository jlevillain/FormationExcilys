/**
 * Created by eron on 17/01/15.
 */
Ext.define('MyApp.model.Computer', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id',  type: 'int'},
        {name: 'name',   type: 'string'},
        {name: 'introduced',   type: 'date', dateFormat:'Y-m-d'},
        {name: 'discontinued',   type: 'date',dateFormat:'Y-m-d'},
        {name: 'company', reference:{type:'Company',associations:'ComputersByCompany',role:'company',inverse:'computers'}, sortType:function(data) {
            if(data==null) {
                return '';
            }
            return data.name
        }}
    ],
    proxy: {
        type:'rest',
        reader:{
            type:'json',
            rootProperty:'computers',
            totalProperty:'total'
        },
        api:{
            create:'/webapp-2.1.1-RELEASE/AddComputer',
            read:'/webapp-2.1.1-RELEASE/AllComputer',
            update:'/webapp-2.1.1-RELEASE/UpdateComputer',
            destroy:'/webapp-2.1.1-RELEASE/DeleteComputer'
        }
    }
});