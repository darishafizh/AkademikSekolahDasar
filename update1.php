<?php
require_once ('connection.php');

$id_bahasa = $_POST['id_bahasa'];
$nama_bahasa = $_POST['nama_bahasa'];
$asal_daerah = $_POST['asal_daerah'];
$penutur = $_POST['penutur'];

if (!$id_bahasa || !$nama_bahasa || !$asal_daerah || !$penutur) {
    echo json_encode(array('message' => 'required field is empety.'));

} else {
    $query = mysqli_query($CON, "UPDATE bahasa_daerah Set nama_bahasa = '$nama_bahasa',
   asal_daerah = '$asal_daerah', penutur = '$penutur' WHERE id_bahasa = '$id_bahasa'");
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