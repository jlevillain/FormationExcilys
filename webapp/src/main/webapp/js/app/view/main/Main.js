Ext.define('MyApp.view.main.Main', {
    extend: 'Ext.container.Container',
    xtype:'app-main',
    alias:"widget.main",
    width:'100%',
    height:'100%',
    layout: {
        type: 'border'
    },
    items: [{
        xtype: 'panel',
        region: 'north',
        html: '<h1><a href="/webapp-2.1.1-RELEASE/">Application - Computer Database</a></h1>',
        bodyStyle:{
            marginTop:'20px',
            marginBottom:'30px',
            backgroundColor:'black',
            color:'white',
            marginLeft:'20px'
        },
        style:{
            backgroundColor:'black',
            color:'white'
        },
        width: '100%',
        height:100
    },{
        region: 'center',
        xtype: 'gridpanel',
//        items:[{
//            title: 'Tab 1',
//            html: '<h2>Content ...</h2>'
//        }]
        title:'Computer found',
        store:'ComputerStore',
        width:'100%',
        height:'100%',
        columns:[
            {text:'Name',dataIndex:'name', hideable:false, flex:1},
            {text:'Introduced', dataIndex:'introduced', hideable:false, flex:1},
            {text:'Discontinued', dataIndex:'discontinued', hideable:false, flex:1},
            {text:'Company', dataIndex:'company', hideable:false,flex:1,renderer:function(data) {return data.name}}
        ],
        dockedItems: [{
            xtype: 'pagingtoolbar',
            store: 'ComputerStore',   // same store GridPanel is using
            dock: 'bottom',
            displayInfo: true
        }]
    }]
});
