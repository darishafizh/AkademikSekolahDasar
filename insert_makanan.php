<?php
include ('connection.php');
$id_makanan = $_POST['id_makanan'];
$nama_makanan = $_POST['nama_makanan'];
$sajian = $_POST['sajian'];
$asal_daerah = $_POST['asal_daerah'];
$bahan_utama = $_POST['bahan_utama'];

if (!$id_makanan || !$nama_makanan || !$sajian || !$asal_daerah || !$bahan_utama) {
    echo json_encode(array('message' => 'Data tidak boleh dikongkan.'));
} else {
    $query = mysqli_query($CON, "INSERT INTO makanan_daerah VALUES('$id_makanan', '$nama_makanan', '$sajian', '$asal_daerah', '$bahan_utama')");
    if ($query) {
        echo json_encode(array('message' => 'Data berhasil dimasukan.'));
    } else {
        echo json_encode(array('message' => 'Data gagal dimasukan.'));
    }
}
?>