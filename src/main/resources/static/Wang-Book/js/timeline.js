/**
 * 
 */
   var app=angular.module('app',[]);
  	app.controller('timelineController',['$scope','$http',function($scope,$http){
  		

  			//加载列表Phone
      		$http({
       			method:'GET',
          		 url:'/Wang-Book/TphoneCountList',
          		headers:{
          			"Content-Type":'application/x-www-form-urlencoded'
          		},
       			}).success(function(data){
       				$scope.phoneCountList=data;
       			});
      		//计算数量
      		$http({
       			method:'GET',
          		 url:'/Wang-Book/TphoneCountContent',
          		headers:{
          			"Content-Type":'application/x-www-form-urlencoded'
          		},
       			}).success(function(data){
       				$scope.phonenumber=data;
       			});
      	//加载列表User
      		$http({
       			method:'GET',
          		 url:'/Wang-Book/TUserList',
          		headers:{
          			"Content-Type":'application/x-www-form-urlencoded'
          		},
       			}).success(function(data){
       				$scope.UserList=data;
       			});
      		$http({
       			method:'GET',
          		 url:'/Wang-Book/TUserContext',
          		headers:{
          			"Content-Type":'application/x-www-form-urlencoded'
          		},
       			}).success(function(data){
       				$scope.usercount=data;
       			});
      		//加载访问量
      		$http({
       			method:'GET',
          		 url:'/Wang-Book/TNumberList',
          		headers:{
          			"Content-Type":'application/x-www-form-urlencoded'
          		},
       			}).success(function(data){
       				$scope.NumberList=data;
       			});

      		$http({
       			method:'GET',
          		 url:'/Wang-Book/TNumberCount',
          		headers:{
          			"Content-Type":'application/x-www-form-urlencoded'
          		},
       			}).success(function(data){
       				$scope.NumberCount=data;
       			});
      	 
      		
   		 
         	//加载列表User
         		$http({
          			method:'GET',
             		 url:'/Wang-Book/getGiftList',
             		headers:{
             			"Content-Type":'application/x-www-form-urlencoded'
             		},
          			}).success(function(data){
          				$scope.GitfList=data;
          			});
      		//用于刷新
         		$scope.reloadGitl=function(){
         			$http({
              			method:'GET',
                 		 url:'/Wang-Book/getGiftList',
                 		headers:{
                 			"Content-Type":'application/x-www-form-urlencoded'
                 		},
              			}).success(function(data){
              				$scope.GitfList=data;
              			});
         		}
         		 
      		//删除
         		$scope.deleteIDGitf=function(index){
					
					if(!confirm("确定要删除吗？")){
						
					}else{
						var data2={index:index};
						$http({
		          			method:'GET',
		             		 url:'/Wang-Book/deleteGitfById',
		             		 
		             		headers:{
		             			"Content-Type":'application/x-www-form-urlencoded'
		             		},
		             		params:data2,
		          			}).success(function(data){
		          				
		          				$scope.reloadGitl();
		          				alert("删除成功");
		          			});
					}
					 
	      		
				}	
         		
         		//修改数量
         		$scope.updateCountRoot=function(index,aCount){
					
         				var count=prompt("当前数量是："+aCount);
						var data2={index:index,count:count};
						$http({
		          			method:'GET',
		             		 url:'/Wang-Book/updateCountForRootUser',
		             		 
		             		headers:{
		             			"Content-Type":'application/x-www-form-urlencoded'
		             		},
		             		params:data2,
		          			}).success(function(data){
		          				if(data>0){
		          					$scope.reloadGitl();
		          					alert("修改成功");
		          					 
		          				}
		          				 
		          				 
		          			});
					}
					 
	      		
				 	
  		
  	}]);
  	
  	
 	 
      