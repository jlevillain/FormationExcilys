/**
 * Created by eron on 23/01/15.
 */
Ext.define('MyApp.view.computer.AddComputer', {
    extend: 'Ext.panel.Panel',
    width:'100%',
    height:'100%',
    alias:'widget.addcomputer',
    controller:'addcomputer',
    title:'AddComputer',
    layout:{
        type: 'vbox',
        align: 'middle',
        pack: 'center'
    },
    items: [{
        xtype:'form',
        width:'40%',
        items:[{
            xtype:'textfield',
            fieldLabel:'Computer Name',
            allowBlank:false,
            width:'100%'
        }, {
            xtype:'datefield',
            fieldLabel:'Introduced Date',
            width:'100%'
        },{
            xtype:'datefield',
            fieldLabel:'Discountinued Date',
            width:'100%'
        },{
            xtype:'combobox',
            id:'comboBox',
            name:'company',
            fieldLabel:'Company',
            store:'CompanyStore',
            queryMode:'local',
            valueField:'id',
            displayField:'name',
            editable:false,
            allowBlank:false,
            forceSelection:true,
            autoLoadOnValue:true,
            width:'100%'
        },{
            xtype:'toolbar',
            width:'100%',
            layout:{
              pack:'center'
            },
            items:[
                {
                xtype:'button',
                text:'Add',
                handler:'AddComputer'
            },{
                xtype:'component',
                html:'or'
            },{
                xtype:'button',
                text:'Cancel',
                handler:'Cancel'
            }]
        }]
    }
    ]
});
