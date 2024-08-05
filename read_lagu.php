<?php
require_once ('connection.php');
$resul = array();
if ($CON->connect_error) {
    die("Connection failed : " . $CON->connect_error);
    echo json_encode(array('message' => 'Connection Error.'));
}
$query = mysqli_query($CON, "SELECT * FROM lagu_daerah ORDER BY id_lagu DESC");
if (mysqli_num_rows($query) > 0) {
    while ($row = mysqli_fetch_assoc($query)) {
        $result[] = $row;
    }
    echo json_encode(array('result' => $result));
} else {
    echo json_encode(array('message' => 'zero result.'));
}
?>