<?php
header("Content-Type: text/html;charset=utf-8");
$respuesta=array();
try {
	$status=200;
	$res=0;
	$desc="";
	$json = file_get_contents('php://input');
	if ($json) {
		$input = json_decode($json,true);
		//List of msgs of a chat
		$user = $input["user"];
		include("conexion.php");
		$sql="SELECT * FROM places";
		if ($datos = mysqli_query($conn,$sql)) {
			while ($fila=$datos->fetch_assoc()) {
				$resp["id"]=$fila["p_id"];
				$resp["name"]=$fila["p_name"];
				$resp["city"]=$fila["p_city"];
				$resp["url"]=$fila["p_url"];
				$resp["lat"]=$fila["p_lat"];
				$resp["lon"]=$fila["p_lon"];
				array_push($respuesta,$resp);
			}
			mysqli_free_result($datos);
		} else {
			$status=401;
		}
		mysqli_close($conn);
	} else {
		$status=400;
	}
} catch (Exception $e){
	$status=500;
	$desc="Exception:".$e->getMessage();
}
http_response_code($status);
echo json_encode($respuesta, JSON_UNESCAPED_UNICODE); //Para que no casque si encuentra tildes o 'ñ'
?>