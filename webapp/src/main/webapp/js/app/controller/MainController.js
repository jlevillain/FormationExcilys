/**
 * Created by eron on 10/01/15.
 */
Ext.define('MyApp.controller.MainController', {
    extend: 'Ext.app.Controller',
    requires: [
        'Ext.MessageBox'
    ],routes:{
        'user/:id': {
            action:'loadUser'
        },
        'user' : {
            action:'onUser'
        },
        'home':{
            action:'onHome'
        }
    },
    views:[
      'MyApp.view.main.Main'
    ],
    alias: 'controller.main',
    init:function() {
        this.addRef([{
            ref: 'main',
            selector: '[xtype=main]'
        }]);
        this.callParent();
    },
    onUser: function() {
        var view = this.getMain();//('MyApp.view.computer.addComputer');
        var center = view.down('#center');
        center.removeAll();
        var cmp = center.add({
            xtype: 'addcomputer'
        });
        return cmp;
    },
    onHome: function() {
        var view = this.getMain();//('MyApp.view.computer.addComputer');
        var center = view.down('#center');
        center.removeAll();
        var cmp = center.add({
            xtype: 'homeview'
        });
        return cmp;
    },
    loadUser: function(id) {
        console.log(id);

        var me =this;
        var view = this.getMain();//('MyApp.view.computer.addComputer');
        var center = view.down('#center');
        center.removeAll();
        var cmp = center.add({
            xtype: 'updatecomputer'
        });
        Ext.getStore('ComputerStore').getModel().load(id, { // load user with ID of "1"
            success: function (user) {
                var form = Ext.getCmp('form');
                form.loadRecord(user);
                var model = Ext.getCmp("UpdateComputer").getViewModel();
                var combo = Ext.getCmp("comboBox");
                console.log(model);
                if(model && combo) {
                    if(user.data.company!=null) {
                        model.set('id', user.data.company.id);
                        combo.setValue(user.data.company.id);
                    }else {
                        model.set('id',"0");
                        combo.setValue("0");
                    }
                }
            },failure: function(user) {
                me.redirectTo('home');
                Ext.Msg.alert('Failed', "fail to load computer");
            }
        });

        return cmp;
    }
//    onClickButton: function (button, e, eOpts) {
//        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
//    },
//
//    onConfirm: function (choice) {
//        if (choice === 'yes') {
//            //
//            console.log("coucou");
//            window.alert("Hello");
//        }
//    },
//
//    init: function(application) {
//        this.control({
//            "main button": {
//                click: this.onClickButton,
//                confirm: this.onConfirm
//            }
//        });
//    }
});
