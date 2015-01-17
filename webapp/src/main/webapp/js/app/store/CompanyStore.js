/**
 * Created by eron on 17/01/15.
 */
Ext.define('MyApp.store.CompanyStore', {
    extend: 'Ext.data.Store',
    requires: [
        'MyApp.model.Company'
    ],
    model: 'MyApp.model.Company',
    data : [
        {id: '1',    name: 'Apple Inc.'},
        {id: '2',    name: 'Thinking Machine'},
        {id: '3',    name: 'RCA'},
        {id: '4',    name: 'Netronics'}
    ]
});