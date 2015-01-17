/**
 * Created by eron on 17/01/15.
 */
Ext.define('MyApp.model.Computer', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id',  type: 'int'},
        {name: 'name',   type: 'string'},
        {name: 'introduced',   type: 'date', dateFormat:'Y-m-d H:i:s'},
        {name: 'discontinued',   type: 'date',dateFormat:'Y-m-d H:i:s'},
        {name: 'company_id',   type: 'int'}
    ]
});