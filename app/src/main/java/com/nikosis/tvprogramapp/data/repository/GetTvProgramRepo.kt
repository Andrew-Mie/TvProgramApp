package com.nikosis.tvprogramapp.data.repository

import com.nikosis.tvprogramapp.common.Resources
import com.nikosis.tvprogramapp.data.dto.toTvProgramDrm
import com.nikosis.tvprogramapp.data.model.TvProgramDrm
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTvProgramRepo @Inject constructor(
    private val repository: TvProgramRepo
) {
    operator fun invoke(): Flow<Resources<List<TvProgramDrm>>> = flow {
        try {

            emit(Resources.Loading<List<TvProgramDrm>>())
            val tvProgramGo = repository.getTvProgramRepo().map { it.toTvProgramDrm() }
            emit(Resources.Success<List<TvProgramDrm>>(tvProgramGo))

        } catch (e: HttpException) {

            emit(
                Resources.Error<List<TvProgramDrm>>(
                    e.localizedMessage ?: "Could Not Reach Server. Check Internet Connection"
                )
            )

        } catch (e: IOException) {

            emit(Resources.Error<List<TvProgramDrm>>("Something went wrong! Unexpected error occurred"))
        }
    }
}