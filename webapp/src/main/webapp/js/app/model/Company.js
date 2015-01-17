/**
 * Created by eron on 17/01/15.
 */
Ext.define('MyApp.model.Company', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id',  type: 'int'},
        {name: 'name',   type: 'string'}
    ]
});