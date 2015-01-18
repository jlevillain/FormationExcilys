/**
 * Created by eron on 17/01/15.
 */
Ext.define('MyApp.store.ComputerStore', {
    extend: 'Ext.data.Store',
    requires: [
        'MyApp.model.Computer'
    ],
    model: 'MyApp.model.Computer',
    autoLoad:true,
    remoteSort:true,
    sorters:[
        {property:'name'}
    ],
    remoteFilter:true
//    data : ["[{"property":"name","direction":"ASC"},{"property":"introduced","direction":"ASC"},{"property":"discontinued","direction":"ASC"},{"property":"company","direction":"ASC"}]"
//        {id: '1',    name: 'MacBook Pro 15.4 inch',introduced:'2015-01-04 18:35:09', discontinued:'2015-01-04 18:35:09',company:{id:'1',name:'Apple Inc.'}},
//        {id: '2',    name: 'CM-2a',introduced:'2015-01-04 18:35:09', discontinued:'2015-01-04 18:35:09',company:{id:'2',name:'Thinking Machine'}},
//        {id: '3',    name: 'CM-200',introduced:'2015-01-04 18:35:09', discontinued:'2015-01-04 18:35:09',company:{id:'2',name:'Thinking Machine'}},
//        {id: '4',    name: 'CM-5e',introduced:'2015-01-04 18:35:09', discontinued:'2015-01-04 18:35:09',company:{id:'2',name:'Thinking Machine'}}
//    ]
});