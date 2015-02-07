/**
 * Created by eron on 24/01/15.
 */
Ext.define('MyApp.view.home.HomeController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.home',
    init:function() {

    },
    AddComputer:function() {
        this.redirectTo('user');
    },
    DeleteComputer:function(grid, rowIndex, colIndex) {
        var store = grid.getStore();
        var rec = store.getAt(rowIndex);
        rec.erase({success:function() {
            alert(rec.get('name')+' deleted');
        }});
    }
});