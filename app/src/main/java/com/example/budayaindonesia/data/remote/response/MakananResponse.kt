package com.example.budayaindonesia.data.remote.response

import com.google.gson.annotations.SerializedName

data class MakananResponse(

	@field:SerializedName("result")
	val result: List<MakananItem?>? = null
)

data class MakananItem(

	@field:SerializedName("id_makanan")
	val idMakanan: String? = null,

	@field:SerializedName("nama_makanan")
	val namaMakanan: String? = null,

	@field:SerializedName("bahan_utama")
	val bahanUtama: String? = null,

	@field:SerializedName("asal_daerah")
	val asalDaerah: String? = null,

	@field:SerializedName("sajian")
	val sajian: String? = null
)
