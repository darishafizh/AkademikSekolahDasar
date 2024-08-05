<?php
include 'connection.php';

header("Content-Type: application/json");

$method = $_SERVER['REQUEST_METHOD'];

if ($method == 'PUT') {
    // Mendapatkan input JSON dari request body
    $input = json_decode(file_get_contents('php://input'), true);

    if (isset($input['id_bahasa']) && isset($input['nama_bahasa']) && isset($input['asal_daerah']) && isset($input['penutur'])) {
        $id_bahasa = $input['id_bahasa'];
        $nama_bahasa = $input['nama_bahasa'];
        $asal_daerah = $input['asal_daerah'];
        $penutur = $input['penutur'];


        // Update data di database
        $sql = "UPDATE bahasa_daerah SET nama_bahasa=?, asal_daerah=?, penutur=?, WHERE id_bahasa=?";

        $stmt = $CON->prepare($sql);
        $stmt->bind_param('ssssi', $nama_bahasa, $asal_daerah, $penutur, $id_bahasa);

        if ($stmt->execute()) {
            $response = [
                "status" => "success",
                "message" => "Data berhasil diupdate"
            ];
        } else {
            $response = [
                "status" => "error",
                "message" => "Error: " . $stmt->error
            ];
        }
    } else {
        $response = [
            "status" => "error",
            "message" => "Invalid_bahasa input"
        ];
    }

    echo json_encode($response);
    $CON->close();
} else {
    echo json_encode(["message" => "Invalid_bahasa request method"]);
}
?>