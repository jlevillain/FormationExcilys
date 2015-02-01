/**
 * Created by eron on 17/01/15.
 */
Ext.define('MyApp.store.CompanyStore', {
    extend: 'Ext.data.Store',
    requires: [
        'MyApp.model.Company'
    ],
    model: 'MyApp.model.Company',
    autoLoad:true
});