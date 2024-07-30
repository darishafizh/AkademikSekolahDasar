package com.example.budayaindonesia.data.remote.response

import com.google.gson.annotations.SerializedName

data class LaguResponse(

	@field:SerializedName("result")
	val result: List<LaguItem?>? = null
)

data class LaguItem(

	@field:SerializedName("id_lagu")
	val idLagu: String? = null,

	@field:SerializedName("asal_daerah")
	val asalDaerah: String? = null,

	@field:SerializedName("lirik_lagu")
	val lirikLagu: String? = null,

	@field:SerializedName("nama_lagu")
	val namaLagu: String? = null
)
