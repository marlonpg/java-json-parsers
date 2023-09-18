### Presentation

1-slide
	Json parsers in Java

2-slide
	Most used today
	Jackson from
	Gson from Google
	Fastjson2 from Alibaba https://github.com/alibaba/fastjson2
	JSON in Java https://github.com/stleary/JSON-java

3-slide Jackson
	streaming api 
		(good for big json files)
		(convert the json document as stream of tokens, which can be consumed one by one, avoiding memory issues)
		
	tree model 
		(convert it to JsonNode)
	data binding
	[pending] how it works
	[pending] algorithm
	[ok] exemplo de codigo
	[ok] data structures 
	[ok] libs importadas
	
<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-databind</artifactId>
	<version>2.15.2</version>
</dependency>
size 1500kb	

https://reflectoring.io/jackson/

4-slide Gson
	[pending] how it works
	[pending] algorithm
	[ok] exemplo de codigo
	[ok] data structures 
	[ok] libs importadas
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
size 275kb
	
5-slide Fastjson2
	[pending] how it works
	[pending] algorithm
	[pending] exemplo de codigo
	[pending] data structures 
	[ok] libs importadas
<dependency>
    <groupId>com.alibaba.fastjson2</groupId>
    <artifactId>fastjson2</artifactId>
    <version>2.0.40</version>
</dependency>
size 1900kb
	
	
X-slide performance results
