/**
 * Created by eron on 23/01/15.
 */
Ext.define('MyApp.view.home.HomeView', {
    extend: 'Ext.panel.Panel',
    alias:'widget.homeview',
    width:'100%',
    height:'100%',
    controller:'home',
    columnName:"Name",
    columnIntroduced:"Introduced",
    columnDiscontinued:"Discontinued",
    columnCompany:"Company",
    homeTitle:"Computers found",
    buttonAdd:"Add computer",
    tooltipDelete:'Delete',
    me:this,/*
    items: [
        {
        xtype: 'gridpanel',
        id:'grid',
        title:me.homeTitle,
        header:{
            titlePosition: 0,
            items:[{
                xtype:'button',
                text: me.buttonAdd,
                handler: 'AddComputer'
            }]
        },
        store:'ComputerStore',
        width:'100%',
        height:'100%',
        plugins:'gridfilters',
        columns:[
            {text:me.columnName, dataIndex:'name', hideable:false, flex:1,filter:'string',xtype:'templatecolumn', tpl:'<a href="/webapp-2.1.1-RELEASE/#user/{id}/"'+LOCALE+'>{name}</a>'},
            {text:me.columnIntroduced, dataIndex:'introduced', hideable:false, flex:1,xtype: 'datecolumn',   format:'Y-m-d'},
            {text:me.columnDiscontinued, dataIndex:'discontinued', hideable:false, flex:1,xtype: 'datecolumn',   format:'Y-m-d'},
            {text:me.columnCompany, dataIndex:'company', hideable:false,flex:1,renderer:function(data) {if(data!=null) {return data.name}else {return ''}},filter:'string'},
            {xtype:'actioncolumn',width:50,hideable:false, sortable:false, tooltip:me.tooltipDelete, handler:'DeleteComputer', icon:'/webapp-2.1.1-RELEASE/images/delete.png'}
        ],
        dockedItems: [{
            xtype: 'pagingtoolbar',
            store: 'ComputerStore',   // same store GridPanel is using
            dock: 'bottom',
            displayInfo: true,
            items: ['->'],
            prependButtons: true
        }]
        }
    ]*/
    initComponent : function(config) {
        Ext.apply(this, {
            items: [
                {
                    xtype: 'gridpanel',
                    id:'grid',
                    title:this.homeTitle,
                    header:{
                        titlePosition: 0,
                        items:[{
                            xtype:'button',
                            text: this.buttonAdd,
                            handler: 'AddComputer'
                        }]
                    },
                    store:'ComputerStore',
                    width:'100%',
                    height:'100%',
                    plugins:'gridfilters',
                    columns:[
                        {text:this.columnName, dataIndex:'name', hideable:false, flex:1,filter:'string',xtype:'templatecolumn', tpl:'<a href="/webapp-2.1.1-RELEASE/#user/{id}/"'+LOCALE+'>{name}</a>'},
                        {text:this.columnIntroduced, dataIndex:'introduced', hideable:false, flex:1,xtype: 'datecolumn',   format:'Y-m-d'},
                        {text:this.columnDiscontinued, dataIndex:'discontinued', hideable:false, flex:1,xtype: 'datecolumn',   format:'Y-m-d'},
                        {text:this.columnCompany, dataIndex:'company', hideable:false,flex:1,renderer:function(data) {if(data!=null) {return data.name}else {return ''}},filter:'string'},
                        {xtype:'actioncolumn',width:50,hideable:false, sortable:false, tooltip:this.tooltipDelete, handler:'DeleteComputer', icon:'/webapp-2.1.1-RELEASE/images/delete.png'}
                    ],
                    dockedItems: [{
                        xtype: 'pagingtoolbar',
                        store: 'ComputerStore',   // same store GridPanel is using
                        dock: 'bottom',
                        displayInfo: true,
                        items: ['->'],
                        prependButtons: true
                    }]
                }
            ]
        });

        this.callParent(arguments);
    }
});