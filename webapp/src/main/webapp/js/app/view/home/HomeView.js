/**
 * Created by eron on 23/01/15.
 */
Ext.define('MyApp.view.home.HomeView', {
    extend: 'Ext.panel.Panel',
    alias:'widget.homeview',
    width:'100%',
    height:'100%',
    controller:'home',
    items: [
        {
        xtype: 'gridpanel',
        title:'Computers found',
        header:{
            titlePosition: 0,
            items:[{
                xtype:'button',
                text: 'Add Computer',
                handler: 'AddComputer'
            }]
        },
        store:'ComputerStore',
        width:'100%',
        height:'100%',
        plugins:'gridfilters',
        columns:[
            {text:'Name', dataIndex:'name', hideable:false, flex:1,filter:'string',xtype:'templatecolumn', tpl:'<a href="/webapp-2.1.1-RELEASE/#user/{id}">{name}</a>'},
            {text:'Introduced', dataIndex:'introduced', hideable:false, flex:1,xtype: 'datecolumn',   format:'Y-m-d'},
            {text:'Discontinued', dataIndex:'discontinued', hideable:false, flex:1,xtype: 'datecolumn',   format:'Y-m-d'},
            {text:'Company', dataIndex:'company', hideable:false,flex:1,renderer:function(data) {return data.name},filter:'string'}
        ],
        dockedItems: [{
            xtype: 'pagingtoolbar',
            store: 'ComputerStore',   // same store GridPanel is using
            dock: 'bottom',
            displayInfo: true,
            displayMsg:'Displaying {0} - {1} of {2} computers',
            items: ['->'],
            prependButtons: true
        }]
        }
    ]
});