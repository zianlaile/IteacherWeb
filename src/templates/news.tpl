<!DOCTYPE html>
<html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<style type="text/css">
	img {
		max-width: 100%;
		box-sizing: border-box;
		}
	</style>
	</head>	
	<body>
		<h4 style="margin-bottom: 0px;">${news.title}</h4>
		<p style="color:gray;font-size:12px;">发布时间：${addtime}</p>
		<hr/>
		<div class="content">
			${news.content}
		</div>
	</body>
	
</html>