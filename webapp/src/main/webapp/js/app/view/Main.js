Ext.define('MyApp.view.Main', {
    extend: 'Ext.container.Container',
    alias:"widget.main",
    width:'100%',
    height:'100%',
    id:'MainPage',
    homeTitle:'Application - Computer Database',
    disconnectButton:'Logout',
    layout: {
        type: 'border'
    },
    xtype:'app-main',
    plugins: 'viewport',
    renderTo:Ext.getBody(),
    /*items: [{
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
    }]*/
    initComponent : function(config) {
        console.log('initComponentMain');
        Ext.apply(this, {
            items: [
                {
                    xtype: 'panel',
                    region: 'north',
                    itemId: 'menu',
                    html: '<h1><a id="titleLink" href="/webapp-2.1.1-RELEASE/#home/'+LOCALE+'">'+this.homeTitle+'</a></h1><span style="float: right"><a href="/webapp-2.1.1-RELEASE/#disconnect">'+this.disconnectButton+'</a><br><a href="#home/en"><img src="/webapp-2.1.1-RELEASE/resources/images/anglais.png"></a> | <a href="#home/fr"><img src="/webapp-2.1.1-RELEASE/resources/images/francais.png"></a></span>',
                    bodyStyle: {
                        paddingTop: '20px',
                        paddingBottom: '30px',
                        backgroundColor: 'black',
                        color: 'white',
                        paddingLeft: '20px'
                    },
                    style: {
                        backgroundColor: 'black',
                        color: 'white'
                    },
                    width: '100%',
                    height: 100
                },
                {
                    width: '100%',
                    height: '100%',
                    region: 'center',
                    itemId: 'center',
                    layout: {type: 'fit'},
                    xtype: 'container'
                }
            ]
        });
        this.callParent(arguments);
    }
});