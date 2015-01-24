Ext.define('MyApp.view.main.Main', {
    extend: 'Ext.container.Container',
    alias:"widget.main",
    width:'100%',
    height:'100%',
    layout: {
        type: 'border'
    },
    items: [{
        xtype: 'panel',
        region: 'north',
        itemId:'menu',
        html: '<h1><a id="titleLink" href="/webapp-2.1.1-RELEASE/">Application - Computer Database</a></h1>',
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
        width:'100%',
        height:'100%',
        region: 'center',
        itemId:'center',
        layout:{type:'fit'},
        xtype:'container'
    }]
});
