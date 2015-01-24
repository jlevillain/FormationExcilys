/**
 * Created by eron on 24/01/15.
 */
Ext.define('MyApp.view.computer.AddComputerController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.addcomputer',
    init:function() {
        var combo = Ext.getCmp("comboBox")
        if(combo!=null && combo.getStore()!=null && combo.getStore().first()!=null) {
            combo.setValue(combo.getStore().first().data.id);
        }

    },
    AddComputer:function() {
        var me = this;
        var form = Ext.getCmp("form");
        var comboBox = Ext.getCmp("comboBox");
        var id = comboBox.getValue();
        var introduced = Ext.getCmp("introduced");
        var discontinued = Ext.getCmp("discontinued");
        if (form.isValid()) {
            form.submit({
                params:{
                    company:{id:id,name:""},
                    introduced:introduced.getSubmitValue(),
                    discontinued:discontinued.getSubmitValue(),
                    id:"-1"
                },
                success: function(form) {
                    Ext.Msg.alert('Success', "success");
                    me.redirectTo('home');
                },
                failure: function(form, action) {
                    Ext.Msg.alert('Failed', "fail");
                }
            });
        }
    },
    Cancel:function() {
        this.redirectTo('home');
    }
});