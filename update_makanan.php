<?php
require_once ('connection.php');

$id_makanan = $_POST['id_makanan'];
$nama_makanan = $_POST['nama_makanan'];
$sajian = $_POST['sajian'];
$asal_daerah = $_POST['asal_daerah'];
$bahan_utama = $_POST['bahan_utama'];

if (!$id_makanan || !$nama_makanan || !$sajian || !$asal_daerah || !$bahan_utama) {
    echo json_encode(array('message' => 'required field is empety.'));

} else {
    $query = mysqli_query($CON, "UPDATE makanan_daerah Set nama_makanan = '$nama_makanan', sajian = '$sajian',
   asal_daerah = '$asal_daerah', bahan_utama = '$bahan_utama' WHERE id_makanan = '$id_makanan'");
    if ($query) {
        echo json_encode(
            array(
                'message' => 'student data updated successfully.'
            )
        );
    } else {
        echo json_encode(array('message' => 'student data failed toupdate.'));
    }
}
?>