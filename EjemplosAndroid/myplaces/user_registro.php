<?php
header("Content-Type: text/html;charset=utf-8");
try {
	$res=0;
	$desc="";
	$json = file_get_contents('php://input');
	if ($json) {
		$input = json_decode($json,true);
		$nombre = $input["nombre"];
		$email = $input["email"];
		$pass = $input["pass"];
		include("conexion.php");
		//Comprobar que el mail no este ya registrado:
		$sql="SELECT * FROM users where user_email='$email'";
		if ($datos = mysqli_query($conn,$sql)) {
			if ($fila=$datos->fetch_assoc()) {
				$res = -1;
				$desc = "Error, mail ya registrado";
			} else {
				//Se puede registrar el usuario:
				$sql="insert into users (user_name, user_email, user_pass) 
					values ('$nombre','$email','$pass')";
				mysqli_query($conn,$sql);
				$res=1;
				$desc="Usuario registrado ok";
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