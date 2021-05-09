# mailQueue
简单的stmp邮件队列，wordpress配合这个玩意评论加速。  
# 使用方法：  
设置一个token，设置smtp参数，post提交就完事~  

 ```
function my_wp_mail($args) {
$mailJson = array();
$mailJson['from'] = '浅忆博客(系统)<server@curlc.com>';
$mailJson['to'] = $args['to'];
$mailJson['subject'] = $args['subject'];
$mailJson['text'] = $args['message'];
$mailText = json_encode($mailJson);
//die($mailText);
// echo json_encode($phpmailer);
// die();
$re =  post('http://HOST:8080/api/v1/sendMail?token=token',$mailText);
unset ( $args['to'] );
return $args;
}
add_filter('wp_mail', 'my_wp_mail', 10,1);
 ```