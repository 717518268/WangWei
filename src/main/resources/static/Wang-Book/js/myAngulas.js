/**
 * 
 */
 var app=angular.module('app',[]);
    	app.controller('mainController',['$scope','$http',function($scope,$http){
    		
    	/*	$http({
     			method:'GET',
        		 url:'/active/getStauts',
        		headers:{
        			"Content-Type":'application/x-www-form-urlencoded'
        		},
        		//params:data1,	//angular用此传值
     			}).success(function(data){
     			 
     				 
     			});*/
    		
    		$scope.Giftlist=function(){
    			 
    			//加载列表
        		$http({
         			method:'GET',
            		 url:'/Wang-Book/getGiftList',
            		headers:{
            			"Content-Type":'application/x-www-form-urlencoded'
            		},
            		//params:data1,	//angular用此传值
         			}).success(function(data){
         				//alert("成功00");
         				 
         				$scope.commentArr=data;
         			});
    		}
    		$scope.GetCount=function(){
   			 
    			//获取抽奖数
     			$http({
     	 			method:'GET',
     	    		 url:'/Wang-Book/getCount',
     	    		headers:{
     	    			"Content-Type":'application/x-www-form-urlencoded'
     	    		},
     	    		//params:data1,	//angular用此传值
     	 			}).success(function(value){
     	 				//alert("成功00");
     	 				
     	 				$scope.count=value;
     	 				if(value==0){
     	 					$scope.mySwitch=true;//将按钮状态设置
     	 					$scope.endSubmint=true;//将按钮状态设置
     	 				}
     	 			});
    		}
    		
    		//加载列表
    		$http({
     			method:'GET',
        		 url:'/Wang-Book/getGiftList',
        		headers:{
        			"Content-Type":'application/x-www-form-urlencoded'
        		},
        		//params:data1,	//angular用此传值
     			}).success(function(data){
     				//alert("成功00");
     				 
     				$scope.commentArr=data;
     				$scope.demo();
     			});
     			//获取抽奖数
     			$http({
     	 			method:'GET',
     	    		 url:'/Wang-Book/getCount',
     	    		headers:{
     	    			"Content-Type":'application/x-www-form-urlencoded'
     	    		},
     	    		//params:data1,	//angular用此传值
     	 			}).success(function(value){
     	 				//alert("成功00");
     	 				
     	 				$scope.count=value;
     	 				if(value==0){
     	 					$scope.mySwitch=true;//将按钮状态设置
     	 					$scope.endSubmint=true;//将按钮状态设置
     	 				}
     	 			});
     	 				
    		
    		//获取验证码方法
    		 $scope.getPhoneCode=function(){
    			 var phone=$scope.phone;
    			 var name=$scope.name;
    			 var data1={phone:phone,name:name};
    		  
    		$http({
     			method:'POST',
        		 url:'/Wang-Book/getPhoneCode',
        		headers:{
        			"Content-Type":'application/x-www-form-urlencoded'
        		},
        		params:data1,	//angular用此传值
     			}).success(function(data){
     				 
     				/*
     				 * 返回值 -7短信操作数量不足
     				 * -6活动被停止了
     				 * -5为超时返回值
     				 *   返回值 -4 重复提交
					 * 返回值 -3用户手机已经注册了
					 * 返回值 -2汉字匹配不正确
					 * 返回值 -1手机号匹配不成功
					 * 返回值  0 抽奖次数用完了
					 * 返回值  1 成功返回
					 */
     				 if(data==0){
     					$scope.message1="抽奖次数用完了";
     					 $scope.mySwitch=true;//将按钮状态设置
     				 }else if(data==-1){
     					$scope.message1="";
     					$scope.messagephone="手机格式不正确";
     					$scope.mySwitch=false;//将按钮状态设置
     				 }else if(data==-2){
     					$scope.messagephone="";
     					$scope.messagename="名字格式不正确";
     					$scope.mySwitch=false;//将按钮状态设置
     				 }else if(data==-3){
     					$scope.messagephone="用户手机已经注册了";
     					$scope.messagename="";
     					$scope.mySwitch=false;//将按钮状态设置
     				 }else if(data==-4){
     					$scope.messagephone="重复提交";
     					$scope.mySwitch=false;//将按钮状态设置
     				 }else if(data==-5){
     					//返回值 -5 操作繁忙
     					$scope.message1="操作繁忙";
     					
     				 }else if(data==-6){
      					 
      					$scope.message1="活动被管理员停止了";
      					//6活动被管理员停止了
      				 }else if(data==-7){
     					 
      					$scope.message1=" 短信停止服务了";
      					//6活动被管理员停止了
      				 }else if(data==1){
     					$scope.messagename="";
     					$scope.messagephone="发送成功";
     					$scope.mySwitch=true;//将按钮状态设置
     					 var time = 120;
          				var secondEle = document.getElementById("second");
          				var timer = setInterval(function(){
          					secondEle.innerHTML = time;
          					time--;
          					if(time==0){
          						clearInterval(timer);
          						$scope.mySwitch=false;//将按钮状态设置
          					}
          						
          				},1000);
     				 }
     			});
     			
    		 } 
    		$scope.chenckEnd=function(){
    			 var phone=$scope.phone;
    			 var name=$scope.name;
    			 var phoneCode=$scope.phoneCode;
    			 var data2={phone:phone,name:name,phoneCode:phoneCode};
    			$http({
     	 			method:'POST',
     	    		 url:'/Wang-Book/getAllContent',
     	    		headers:{
     	    			"Content-Type":'application/x-www-form-urlencoded'
     	    		},
     	    		params:data2,	//angular用此传值
     	 			}).success(function(data){
     	 				//alert("成功00");
     	 				/*
     	 				 * 返回值 -1 手机号匹配不成功
						 * 返回值 -2 汉字匹配不正确
						 * 返回值 -3 用户手机已经注册了
						 * 返回值 -8 用户还没获取获取验证码
						 * 返回值 -9 验证码格式不对
						 * 返回值 -10 验证码不正确
						 * 返回值 -0 活动截止了
						 * 返回值 1 成功
     	 				*/
     	 				 if(data==0){
          					$scope.message1="抽奖次数用完了";
          					 $scope.endSubmint=true;//将按钮状态设置
          				 }else if(data==-1){
          					$scope.messagephone="手机格式不正确";
          					$scope.endSubmint=false;//将按钮状态设置
          				 }else if(data==-2){
          					$scope.messagephone="";
          					$scope.messagename="名字格式不正确";
          					$scope.endSubmint=false;//将按钮状态设置
          				 }else if(data==-3){
          					$scope.messagephone="用户手机已经注册了";
          					$scope.messagename="";
          					$scope.endSubmint=false;//将按钮状态设置
          				 }else if(data==-8){
          					$scope.messagecode="没获取获取验证码";
          					$scope.messagename="";
          					$scope.messagephone="";
          					$scope.endSubmint=false;//将按钮状态设置
          				 }else if(data==-9||data==-10){
          					$scope.messagecode="验证码不正确";
          					$scope.messagename="";
          					$scope.messagephone="";
          					$scope.endSubmint=false;//将按钮状态设置
          				 } 
          				 else if(data==1){
          					$scope.messagename="";
          					$scope.messagephone="";
          					$scope.messagecode="";
          					$scope.phone="";
          					$scope.name="";
          					$scope.phoneCode="";
          					alert("成功");
          					$scope.endSubmint=true;//将按钮状态设置
          					$scope.Giftlist();//重新加载列表
          					$scope.GetCount();//重新加载数量
          				 }
     	 				
     	 				
     	 				 
     	 			});
    		}
    		
    		/**
    		 * 广告页
    		 */
    		$scope.getAdvertising=function(){
    			
    		 
    		$http({
     			method:'GET',
        		 url:'/Wang-Book/getAdvertising',
        		headers:{
        			"Content-Type":'application/x-www-form-urlencoded'
        		},
        		//params:data1,	//angular用此传值
     			}).success(function(data){
     				//alert(data.title);
     				$scope.advesHrefurl=data.hrefurl;
     				$scope.advestitle=data.title;
     				$scope.advesImageurl=data.imageurl;
     				// alert("data"+data);
     			});
    		}
    		
    		$scope.getAdvertising();
    		
    	}]);
        
