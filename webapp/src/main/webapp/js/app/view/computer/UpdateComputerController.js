/**
 * Created by eron on 31/01/15.
 */
Ext.define('MyApp.view.computer.UpdateComputerController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.updatecomputer',
    init:function() {
        console.log(Ext.getCmp("UpdateComputer").getViewModel().get('id'));
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
                    discontinued:discontinued.getSubmitValue()
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
    },
    Load: function () {
        console.log(Ext.getCmp("UpdateComputer").getViewModel().get('id'));
        var combo = Ext.getCmp('comboBox');
        console.log(combo.getRawValue());
        if(combo.getRawValue()=="") {
            this.redirectTo('home');
        }
    }
});