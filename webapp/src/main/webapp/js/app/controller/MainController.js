/**
 * Created by eron on 10/01/15.
 */
Ext.define('MyApp.controller.MainController', {
    extend: 'Ext.app.Controller',
    requires: [
        'Ext.MessageBox'
    ],routes:{
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
        console.log('onHome');
        var view = this.getMain();//('MyApp.view.computer.addComputer');
        console.log('getView');
        var center = view.down('#center');
        console.log('center');
        center.removeAll();
        console.log('removeAll')
        var cmp = center.add({
            xtype: 'homeview'
        });
        console.log('add');
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
