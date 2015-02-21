Ext.define("MyApp.view.login.Login",{
    extend: 'Ext.window.Window',
    xtype: 'login',
    username:'Username',
    password:'Password',
    hideEmptyLabel:'Enter any non-blank password',
    buttonLogin:'Login',
    loginTitle:'Login Window',
    requires: [
        'MyApp.view.login.LoginController',
        'Ext.form.Panel'
    ],

    controller: 'login',
    bodyPadding: 10,
    title: 'Login Window',
    closable: false,
    autoShow: true,
    initComponent : function(config) {
        Ext.apply(this, {
            title:this.loginTitle,
            items: {
                xtype: 'form',
                reference: 'form',
                items: [
                    {
                        xtype: 'textfield',
                        name: 'username',
                        fieldLabel: this.username,
                        allowBlank: false
                    },
                    {
                        xtype: 'textfield',
                        name: 'password',
                        inputType: 'password',
                        fieldLabel: this.password,
                        allowBlank: false
                    },
                    {
                        xtype: 'displayfield',
                        hideEmptyLabel: false,
                        value: this.hideEmptyLabel
                    }
                ],
                buttons: [
                    {
                        text: this.buttonLogin,
                        formBind: true,
                        listeners: {
                            click: 'onLoginClick'
                        }
                    }
                ]
            }
        });
        this.callParent(arguments);
    }
});