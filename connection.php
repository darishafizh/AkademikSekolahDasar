<?php
$HOST = 'localhost';
$USER = 'root';
$PASS = '';
$DB = 'budaya_indonesia';
$CON = mysqli_connect($HOST, $USER, $PASS, $DB);
if (!$CON) {
    die(json_encode(array('message' => 'Koneksi Gagal : ' . mysqli_connect_error())));
}
