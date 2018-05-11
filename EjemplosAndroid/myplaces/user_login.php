<?php
header("Content-Type: text/html;charset=utf-8");
try {
	$res=0;
	$desc="";
	$json = file_get_contents('php://input');
	if ($json) {
		$input = json_decode($json,true);
		$email = $input["email"];
		$pass = $input["pass"];
		include("conexion.php");
		$sql="SELECT * FROM users where user_email='$email' and user_pass='$pass'";
		if ($datos = mysqli_query($conn,$sql)) {
			if ($fila=$datos->fetch_assoc()) {
				$res = $fila["user_id"];
				$desc = $fila["user_name"];
			} else {
				$res=-2;
				$desc="Datos true, but fila empty";
			}
			mysqli_free_result($datos);
		} else {
			$res=-3;
			$desc="Datos false";
		}
		mysqli_close($conn);
	} else {
		$res=-4;
		$desc="JSON es nulo";
	}
} catch (Exception $e){
	$res=-1;
	$desc="Exception:".$e->getMessage();
}	
$respuesta=array('res'=>$res,'desc'=>$desc);
echo json_encode($respuesta);
?>