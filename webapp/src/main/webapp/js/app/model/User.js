/**
 * Created by eron on 10/01/15.
 */
Ext.define('MyApp.model.User', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'name',  type: 'string'},
        {name: 'age',   type: 'int'}
    ]
});