Ext.define('MyApp.view.login.LoginController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.login',
    errorMessage:'Login/password incorrect',

    onLoginClick: function(){

        // This would be the ideal location to verify the user's credentials via
        // a server-side lookup. We'll just move forward for the sake of this example.

        // Set the localStorage value to true
        //localStorage.setItem("LoggedIn", true);
        var form = Ext.getCmp("loginForm");
        var me  = this;
        Ext.Ajax.request({
            url:'/webapp-2.1.1-RELEASE/j_spring_security_check',
            params:form.getValues(),
            success: function (response) {
                console.log(response.status);
                console.log(response.responseText);
                if(response.responseText=="ERROR") {
                    window.alert(me.errorMessage);
                }else {
                    localStorage.setItem("LoggedIn", true);
                    me.getView("MyApp.view.login.Login").destroy();
                    Ext.widget('app-main');
                    me.redirectTo('home/'+LOCALE);
                }
            },
            failure: function (response) {
                console.log(response.status);
                console.log(response.responseText);
            },
            method:'POST'

        });
        // Remove Login Window
        //this.getView("MyApp.view.login.Login").destroy();

        // Add the main view to the viewport
        //Ext.widget('app-main');
        //this.redirectTo('home/'+LOCALE);
    }
});