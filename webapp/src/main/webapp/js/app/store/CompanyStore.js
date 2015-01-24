/**
 * Created by eron on 17/01/15.
 */
Ext.define('MyApp.store.CompanyStore', {
    extend: 'Ext.data.Store',
    requires: [
        'MyApp.model.Company'
    ],
    model: 'MyApp.model.Company',
    autoLoad:true,
    listeners: {
    load: function () {
        //this sets the default value to USA after the store loads
        var combo = Ext.getCmp('comboBox');
        if (combo != null) {
            combo.setValue(this.first().data.id);
        }
    }
    }
});