<?php
	include('smtp/PHPMailerAutoload.php');

	if(isset($_POST["txt_email"])) {
		$email = test_input($_POST["txt_email"]);
		$subject = test_input($_POST["txt_name"]);
		$html = $_POST["txt_message"]."<br>Mobile No. : ".$_POST["txt_phone"];
		if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
	  		echo "Invalid Email format";
		} else {
			//echo smtp_mailer($email,$subject,$html);
			echo 'Your message send successfully!.';
		}	
	}
	else {
		echo "Invalid Email format";
	}
	// PHP mail Send Funtion
	function smtp_mailer($to,$subject, $msg){
		$mailConfigData = json_decode(file_get_contents("config.json"),true);
		$mail = new PHPMailer(); 
		//$mail->SMTPDebug  = 3;  // For Debug
		$mail->IsSMTP(); 
		$mail->SMTPAuth = true; 
		$mail->SMTPSecure = $mailConfigData['smtpsecure']; 
		$mail->Host = $mailConfigData['host'];
		$mail->Port = 587; 
		$mail->IsHTML(true);
		$mail->CharSet = 'UTF-8';
		$mail->Username = $mailConfigData['username'];
		$mail->Password = $mailConfigData['password'];
		$mail->SetFrom($mailConfigData['username']);
		$mail->Subject = $subject;
		$mail->Body =$msg;
		$mail->AddAddress($to);
		$mail->AddAddress($mailConfigData['username']);
		$mail->SMTPOptions=array('ssl'=>array(
			'verify_peer'=>false,
			'verify_peer_name'=>false,
			'allow_self_signed'=>false
		));
		if(!$mail->Send()){
			return $mail->ErrorInfo;
		}else{
			return 'Your message send successfully!.';
		}
	}
	// Input Data Validation
	function test_input($data) {
	  	$data = trim($data);
	  	$data = stripslashes($data);
	  	$data = htmlspecialchars($data);
	  	return $data;
	}
?>