Ext.define('MyApp.view.login.LoginController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.login',

    onLoginClick: function(){

        // This would be the ideal location to verify the user's credentials via
        // a server-side lookup. We'll just move forward for the sake of this example.

        // Set the localStorage value to true
        localStorage.setItem("LoggedIn", true);

        // Remove Login Window
        this.getView("MyApp.view.login.Login").destroy();

        // Add the main view to the viewport
        Ext.widget('app-main');
        this.redirectTo('home/'+LOCALE);
    }
});