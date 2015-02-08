/**
 * Created by eron on 31/01/15.
 */
Ext.define('MyApp.view.computer.UpdateComputerController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.updatecomputer',
    successTitle:'Success',
    successText:"success",
    failTitle:"Failed",
    failText:"fail",
    init:function() {
        console.log('init update')
        var combo = Ext.getCmp('comboBox');
        combo.getStore().load();
    },
    UpdateComputer:function() {
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
                    Ext.Msg.alert(this.successTitle, this.successText);
                    me.redirectTo('home/'+LOCALE);
                },
                failure: function(form, action) {
                    Ext.Msg.alert(this.failTitle, this.failText);
                }
            });
        }
    },
    Cancel:function() {
        this.redirectTo('home/'+LOCALE);
    }
});