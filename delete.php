<?php
require_once ('connection.php');
$id_bahasa = $_GET['id_bahasa'];
if (!$id_bahasa) {
    echo json_encode(array('message' => 'Parameter id dibutuhkan.'));

} else {
    $query = mysqli_query($CON, "DELETE FROM bahasa_daerah WHERE id_bahasa = '$id_bahasa'");
    if ($query) {
        echo json_encode(array('message' => 'Data berhasil dihapus.'));

    } else {
        echo json_encode(array('message' => 'Data gagal dihapus.'));
    }
}
?>