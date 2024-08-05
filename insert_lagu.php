<?php
include ('connection.php');
$id_lagu = $_POST['id_lagu'];
$nama_lagu = $_POST['nama_lagu'];
$asal_daerah = $_POST['asal_daerah'];
$lirik_lagu = $_POST['lirik_lagu'];

if (!$id_lagu || !$nama_lagu || !$asal_daerah || !$lirik_lagu) {
    echo json_encode(array('message' => 'Data tidak boleh dikongkan.'));
} else {
    $query = mysqli_query($CON, "INSERT INTO lagu_daerah VALUES('$id_lagu', '$nama_lagu', '$asal_daerah', '$lirik_lagu')");
    if ($query) {
        echo json_encode(array('message' => 'Data berhasil dimasukan.'));
    } else {
        echo json_encode(array('message' => 'Data gagal dimasukan.'));
    }
}
?>