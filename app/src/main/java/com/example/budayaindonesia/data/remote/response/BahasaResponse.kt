package com.example.budayaindonesia.data.remote.response

import com.google.gson.annotations.SerializedName

data class BahasaResponse(

	@field:SerializedName("result")
	val result: List<ResultItem?>? = null
)

data class ResultItem(

	@field:SerializedName("id_bahasa")
	val idBahasa: String? = null,

	@field:SerializedName("penutur")
	val penutur: String? = null,

	@field:SerializedName("nama_bahasa")
	val namaBahasa: String? = null,

	@field:SerializedName("asal_daerah")
	val asalDaerah: String? = null
)
