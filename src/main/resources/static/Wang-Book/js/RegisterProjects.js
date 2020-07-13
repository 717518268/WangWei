/**
 * 
 */

     var app=angular.module('app',[]);
                        	app.controller('RegisterProjectsController',['$scope','$http',function($scope,$http){
                        		
                        		 
                        			 $scope.loding=function(){
                        				 
                        			  
                        			//加载列表
                            		$http({
                             			method:'GET',
                                		 url:'/Wang-Book/getRegisters/UpdatePraises',
                                		headers:{
                                			"Content-Type":'application/x-www-form-urlencoded'
                                		},
                                		//params:data1,	//angular用此传值
                             			}).success(function(data){
                             				//alert("成功00");
                             				 
                             				$scope.registerList=data;
                             			});
                        			 }
                        			 $scope.loding();
                        			$scope.reload=function(){
                        				 $scope.loding();
                        			 }
                        			 
                        			$scope.updateCountRoot=function(id,praisecount){
                        				var praisecount=prompt("当前数量是："+praisecount);
                						var data2={id:id,praisecount:praisecount};
                						$http({
                		          			method:'GET',
                		             		 url:'/Wang-Book/updateRegister/PraisesByID',
                		             		 
                		             		headers:{
                		             			"Content-Type":'application/x-www-form-urlencoded'
                		             		},
                		             		params:data2,
                		          			}).success(function(data){
                		          				if(data>0){
                		          					$scope.loding();
                		          					alert("修改成功");
                		          					
                		          				}else{
                		          					alert("发生了未知的错误");
                		          				}
                		          				 
                		          				 
                		          			});
                        			}
                        			 
                        	 	 
                        		
                        	}]);
                            