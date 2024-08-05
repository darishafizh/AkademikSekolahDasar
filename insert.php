<?php
include ('connection.php');
$id_bahasa = $_POST['id_bahasa'];
$nama_bahasa = $_POST['nama_bahasa'];
$asal_daerah = $_POST['asal_daerah'];
$penutur = $_POST['penutur'];

if (!$id_bahasa || !$nama_bahasa || !$asal_daerah || !$penutur) {
    echo json_encode(array('message' => 'Data tidak boleh dikongkan.'));
} else {
    $query = mysqli_query($CON, "INSERT INTO bahasa_daerah VALUES('$id_bahasa', '$nama_bahasa', '$asal_daerah', '$penutur')");
    if ($query) {
        echo json_encode(array('message' => 'Data berhasil dimasukan.'));
    } else {
        echo json_encode(array('message' => 'Data gagal dimasukan.'));
    }
}
?>