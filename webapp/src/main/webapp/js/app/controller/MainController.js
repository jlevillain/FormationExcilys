/**
 * Created by eron on 10/01/15.
 */
Ext.define('MyApp.controller.MainController', {
    extend: 'Ext.app.Controller',
    failLoading:'Fail to load computer',
    requires: [
        'Ext.MessageBox'
    ],routes:{
        'user/:id/:lang': {
            action:'loadUser'
        },
        'user/:lang' : {
            action:'onUser'
        },
        'home/:lang':{
            action:'onHome'
        },
        'disconnect':{
            action:'disconnect'
        }
    },
    views:[
      'Main'
    ],
    alias: 'controller.main',
    init:function() {
        var me = this;
        console.log('init main')
        loggedIn = localStorage.getItem("LoggedIn");
        if(loggedIn) {
            me.redirectTo('home/'+LOCALE);
        }
        this.addRef([{
            ref: 'main',
            selector: '[xtype=app-main]',
            autoCreate:true
        }]);
        this.callParent();
    },
    onUser: function(lang) {
        this.setLocale(lang);
        var view = this.getMain();//('MyApp.view.computer.addComputer');
        var center = view.down('#center');
        center.removeAll();
        var cmp = center.add({
            xtype: 'addcomputer'
        });
        return cmp;
    },
    onHome: function(lang) {
        this.setLocale(lang);
        var view = this.getMain();//('MyApp.view.computer.addComputer');
        var center = view.down('#center');
        center.removeAll();
        var cmp = center.add({
            xtype: 'homeview'
        });
        return cmp;
    },
    loadUser: function(id, lang) {
        console.log(id);
        this.setLocale(lang);
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
                if(form) {
                    form.loadRecord(user);
                    var model = Ext.getCmp("UpdateComputer").getViewModel();
                    var combo = Ext.getCmp("comboBox");
                    if(model && combo) {
                        if(user.data.company!=null) {
                            model.set('id', user.data.company.id);
                            combo.setValue(user.data.company.id);
                        }else {
                            model.set('id',"0");
                            combo.setValue("0");
                        }
                    }
                }
            },failure: function(user) {
                me.redirectTo('home/'+LOCALE);
                Ext.Msg.alert('Failed', this.failLoading);
            }
        });

        return cmp;
    },
    setLocale : function(locale) {
        var homeTitle  = "";
        var diconnectButtonText = "";
        var homeTitleText="";
        if (locale=="fr") {
            LOCALE = "fr";
            eval(SCRIPT_FR);
            eval(SCRIPT_TEXT_FR);
            var view = this.getMain();//('MyApp.view.computer.addComputer');
            var center = view.down('#menu');
            homeTitle=homeTitleFr;
            diconnectButtonText = disconnectButtonFr;
        } else {
            LOCALE = "en";
            eval(SCRIPT_EN);
            eval(SCRIPT_TEXT_EN);
            homeTitle=homeTitleEn;
            diconnectButtonText = disconnectButtonEn;
        }
        var view = this.getMain();//('MyApp.view.computer.addComputer');
        var center = view.down('#menu');
        var button = '<span style="float: right;position: relative;top: -50px;right:20px;"><a id="logout" href="/webapp-2.1.1-RELEASE/#disconnect">'+diconnectButtonText+'</a><br><br><a href="#home/en"><img src="/webapp-2.1.1-RELEASE/resources/images/anglais.png"></a> | <a href="#home/fr"><img src="/webapp-2.1.1-RELEASE/resources/images/francais.png"></a></span>'
        center.body.update('<h1><a id="titleLink" href="/webapp-2.1.1-RELEASE/#home/'+LOCALE+'">'+homeTitle+'</a></h1>'+button, true);
    },
    disconnect: function () {
        console.log("disconnect");
        // Remove the localStorage key/value
        localStorage.removeItem('LoggedIn');

        // Remove Main View

        this.getMain().destroy();

        // Add the Login Window
        Ext.widget('login');
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
