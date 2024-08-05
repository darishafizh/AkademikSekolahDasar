<?php
require_once ('connection.php');

$id_lagu = $_POST['id_lagu'];
$nama_lagu = $_POST['nama_lagu'];
$asal_daerah = $_POST['asal_daerah'];
$lirik_lagu = $_POST['lirik_lagu'];

if (!$id_lagu || !$nama_lagu || !$asal_daerah || !$lirik_lagu) {
    echo json_encode(array('message' => 'required field is empety.'));

} else {
    $query = mysqli_query($CON, "UPDATE lagu_daerah Set nama_lagu = '$nama_lagu',
   asal_daerah = '$asal_daerah', lirik_lagu = '$lirik_lagu' WHERE id_lagu = '$id_lagu'");
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