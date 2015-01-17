/**
 * Created by eron on 17/01/15.
 */
Ext.define('MyApp.store.ComputerStore', {
    extend: 'Ext.data.Store',
    requires: [
        'MyApp.model.Computer'
    ],
    model: 'MyApp.model.Computer',
    data : [
        {id: '1',    name: 'MacBook Pro 15.4 inch',introduced:'2015-01-04 18:35:09', discontinued:'2015-01-04 18:35:09',company_id:'1'},
        {id: '2',    name: 'CM-2a',introduced:'2015-01-04 18:35:09', discontinued:'2015-01-04 18:35:09',company_id:'2'},
        {id: '3',    name: 'CM-200',introduced:'2015-01-04 18:35:09', discontinued:'2015-01-04 18:35:09',company_id:'2'},
        {id: '4',    name: 'CM-5e',introduced:'2015-01-04 18:35:09', discontinued:'2015-01-04 18:35:09',company_id:'2'}
    ]
});