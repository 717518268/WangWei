/**
 * 
 */
  var app=angular.module('app',[]);
                        	app.controller('RegisterProjectsController',['$scope','$http',function($scope,$http){
                        		
                        		 
                        			 
                        	 	$scope.seacherRegisterId=function(){
                        	 		var id=$scope.id;
                        	 		var data1={id:id};
                        	 		//加载列表
                            		$http({
                             			method:'GET',
                                		 url:'/Wang-Book/getRegisters/FindId',
                                		headers:{
                                			"Content-Type":'application/x-www-form-urlencoded'
                                		},
                                		params:data1,	//angular用此传值
                             			}).success(function(data){
                             				 
                             				if(data==null){
                             					$scope.error="查无结果";
                             				}else{
                             					
                             					$scope.userorder=data;
                             				}
                             				 
                             			});
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
            		          					 
            		          					alert("修改成功");
            		          					
            		          				}else{
            		          					alert("发生了未知的错误");
            		          				}
            		          				 
            		          				 
            		          			});
                    			}
                        		
                        	}]);
                            