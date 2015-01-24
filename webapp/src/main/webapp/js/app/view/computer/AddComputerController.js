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
        alert("computer added");
    },
    Cancel:function() {
        this.redirectTo('home');
    }
});