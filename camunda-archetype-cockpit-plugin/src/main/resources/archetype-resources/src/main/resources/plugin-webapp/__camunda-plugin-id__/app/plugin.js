#set ($symbol_dollar = '$') 
ngDefine('cockpit.plugin.${camunda-plugin-id}', function(module) {

  var DashboardController = function($scope, $http, Uri) {

    ${symbol_dollar}http.get(Uri.appUri("plugin://${camunda-plugin-id}/:engine/process-instance"))
      .success(function(data) {
        $scope.processInstanceCounts = data;
      });
  };

  DashboardController.$inject = ["$scope", "$http", "Uri"];


  var Configuration = function Configuration(ViewsProvider) {

    ViewsProvider.registerDefaultView('cockpit.dashboard', {
      id: '${camunda-plugin-id}',
      label: '${camunda-plugin-name}',
      url: 'plugin://${camunda-plugin-id}/static/app/dashboard.html',
      controller: DashboardController,

      // make sure we have a higher priority than the default plugin
      priority: 12
    });
  };

  Configuration.$inject = ['ViewsProvider'];

  module.config(Configuration);

  return module;
});
