/**
 * Created by eron on 10/01/15.
 */
Ext.define('MyApp.controller.MainController', {
    extend: 'Ext.app.Controller',
    requires: [
        'Ext.MessageBox'
    ],
    renderTo:Ext.getBody(),
    alias: 'controller.main',

    onClickButton: function (button, e, eOpts) {
        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
    },

    onConfirm: function (choice) {
        if (choice === 'yes') {
            //
            console.log("coucou");
            window.alert("Hello");
        }
    },

    init: function(application) {
        this.control({
            "main button": {
                click: this.onClickButton,
                confirm: this.onConfirm
            }
        });
    }
});
