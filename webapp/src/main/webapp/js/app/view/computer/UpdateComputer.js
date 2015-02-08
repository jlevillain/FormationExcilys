/**
 * Created by eron on 31/01/15.
 */
/*
Ext.form.field.ComboBox.override( {
    setValue: function(v) {
        v = (v && v.toString) ? v.toString() : v;
        if(!this.store.isLoaded) {
            this.store.addListener('load', function() {
                this.store.isLoaded = true;
                this.setValue(v);
            }, this);
            this.store.load();
        } else {
            this.callOverridden(arguments);
        }
    }
});
*/
Ext.define('MyApp.view.computer.UpdateComputer', {
    extend: 'Ext.panel.Panel',
    width:'100%',
    height:'100%',
    id:'UpdateComputer',
    alias:'widget.updatecomputer',
    controller:'updatecomputer',
    viewModel:{
        type:'updatecomputer'
    },
    homeTile:'Update computer',
    fieldName:'Computer Name',
    fieldIntroduced:'Introduced Date',
    fieldDiscontinued:'Discountinued Date',
    fieldCompany:'Company',
    buttonSave:'Save',
    buttonCancel:'Cancel',
    layout:{
        type: 'vbox',
        align: 'middle',
        pack: 'center'
    },
    /*items: [{
        xtype:'form',
        id:'form',
        jsonSubmit:true,
        width:'40%',
        url:'/webapp-2.1.1-RELEASE/AllComputer/save',
        items:[{
            xtype: 'hiddenfield',
            name: 'id',
            value: '-1'
        }, {
            xtype:'textfield',
            fieldLabel:'Computer Name',
            name:'name',
            allowBlank:false,
            width:'100%',
            labelWidth:200
        }, {
            xtype:'datefield',
            fieldLabel:'Introduced Date',
            id:'introduced',
            name:'introduced',
            format:'d/m/Y',
            submitFormat:'Y-m-d',
            submitValue:true,
            width:'100%',
            labelWidth:200,
            submitValue:false
        },{
            xtype:'datefield',
            id:'discontinued',
            fieldLabel:'Discountinued Date',
            name:'discontinued',
            format:'d/m/Y',
            submitFormat:'Y-m-d',
            submitValue:true,
            width:'100%',
            labelWidth:200,
            submitValue:false
        },{
            xtype:'combobox',
            id:'comboBox',
            name:'company',
            fieldLabel:'Company',
            store:'CompanyStore',
            queryMode:'remote',
            valueField:'id',
            displayField:'name',
            editable:false,
            allowBlank:false,
            forceSelection:true,
            autoLoadOnValue:false,
            width:'100%',
            labelWidth:200,
            submitValue:false
        },{
            xtype:'toolbar',
            width:'100%',
            layout:{
                pack:'center'
            },
            items:[
                {
                    xtype:'button',
                    text:'Save',
                    handler:'UpdateComputer',
                    formBind: true, //only enabled once the form is valid
                    disabled: true
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
    ]*/
    initComponent : function(config) {
        Ext.apply(this, {
            title: this.homeTile,
            items: [
                {
                    xtype: 'form',
                    id: 'form',
                    jsonSubmit: true,
                    width: '40%',
                    url: '/webapp-2.1.1-RELEASE/AllComputer/save',
                    items: [
                        {
                            xtype: 'hiddenfield',
                            name: 'id',
                            value: '-1'
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: this.fieldName,
                            name: 'name',
                            allowBlank: false,
                            width: '100%',
                            labelWidth: 200
                        },
                        {
                            xtype: 'datefield',
                            fieldLabel: this.fieldIntroduced,
                            id: 'introduced',
                            name: 'introduced',
                            format: 'd/m/Y',
                            submitFormat: 'Y-m-d',
                            submitValue: true,
                            width: '100%',
                            labelWidth: 200,
                            submitValue: false
                        },
                        {
                            xtype: 'datefield',
                            id: 'discontinued',
                            fieldLabel: this.fieldDiscontinued,
                            name: 'discontinued',
                            format: 'd/m/Y',
                            submitFormat: 'Y-m-d',
                            submitValue: true,
                            width: '100%',
                            labelWidth: 200,
                            submitValue: false
                        },
                        {
                            xtype: 'combobox',
                            id: 'comboBox',
                            name: 'company',
                            fieldLabel: this.fieldCompany,
                            store: 'CompanyStore',
                            queryMode: 'remote',
                            valueField: 'id',
                            displayField: 'name',
                            editable: false,
                            allowBlank: false,
                            forceSelection: true,
                            autoLoadOnValue: false,
                            width: '100%',
                            labelWidth: 200,
                            submitValue: false
                        },
                        {
                            xtype: 'toolbar',
                            width: '100%',
                            layout: {
                                pack: 'center'
                            },
                            items: [
                                {
                                    xtype: 'button',
                                    text: this.buttonSave,
                                    handler: 'UpdateComputer',
                                    formBind: true, //only enabled once the form is valid
                                    disabled: true
                                },
                                {
                                    xtype: 'component',
                                    html: 'or'
                                },
                                {
                                    xtype: 'button',
                                    text: this.buttonCancel,
                                    handler: 'Cancel'
                                }
                            ]
                        }
                    ]
                }
            ]
        });
        this.callParent(arguments);
    }
});
