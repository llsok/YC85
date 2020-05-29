function post(url, param, callback){
	var xhr
	try{
		xhr = new XMLHttpRequest(); //对象
	} catch (e) {
		xhr = new ActiveXObject("xxxxxx");
	}
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200 ){
			callback(xhr.responseText);
		}	
	}
	xhr.open("POST",url) // 开启连接   第三个参数 true异步|false同步
	// 如果是文件上传方式, 请求不要设置 Content-type, 因为太复杂
	/**
	 * if( ! param instanceof FormData) {  这里判断错了
	 * js 特有的问题, js 里面任何类型都可以当成  boolean 使用, 影响了运算优先级, java 里面没有这个问题
	 */
	if( ! (param instanceof FormData)) {
		// POST提交数据的编码方式
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	}
	xhr.send(param) // 发送请求 参数 发送的请求参数
}