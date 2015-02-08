/**
 * Created by eron on 24/01/15.
 */
Ext.define('MyApp.view.home.HomeController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.home',
    deletedText:' deleted',
    init:function() {
        console.log('init home')
    },
    AddComputer:function() {
        this.redirectTo('user/'+LOCALE);
    },
    DeleteComputer:function(grid, rowIndex, colIndex) {
        var store = grid.getStore();
        var rec = store.getAt(rowIndex);
        rec.erase({success:function() {
            alert(rec.get('name')+this.deletedText);
        }});
    }
});