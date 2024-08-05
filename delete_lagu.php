<?php
require_once ('connection.php');
$id_lagu = $_GET['id_lagu'];
if (!$id_lagu) {
    echo json_encode(array('message' => 'Parameter id dibutuhkan.'));

} else {
    $query = mysqli_query($CON, "DELETE FROM lagu_daerah WHERE id_lagu = '$id_lagu'");
    if ($query) {
        echo json_encode(array('message' => 'Data berhasil dihapus.'));

    } else {
        echo json_encode(array('message' => 'Data gagal dihapus.'));
    }
}
?>