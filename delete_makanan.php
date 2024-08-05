<?php
require_once ('connection.php');
$id_makanan = $_GET['id_makanan'];
if (!$id_makanan) {
    echo json_encode(array('message' => 'Parameter id dibutuhkan.'));

} else {
    $query = mysqli_query($CON, "DELETE FROM makanan_daerah WHERE id_makanan = '$id_makanan'");
    if ($query) {
        echo json_encode(array('message' => 'Data berhasil dihapus.'));

    } else {
        echo json_encode(array('message' => 'Data gagal dihapus.'));
    }
}
?>