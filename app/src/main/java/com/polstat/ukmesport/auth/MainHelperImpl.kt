package com.polstat.ukmesport.auth

import android.provider.ContactsContract.Profile
import com.polstat.ukmesport.retrofit.AuthApi
import com.polstat.ukmesport.retrofit.MainApi
import com.polstat.ukmesport.retrofit.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MainHelperImpl @Inject constructor(
    private val mainApi: MainApi
): MainHelper{
    override suspend fun profile(bearer: String): Flow<Result<ProfileResponse>> {
        return flow {
            val profileResponse = try {
                val response = mainApi.profile(bearer)
                response
            }catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(message = "Authentication Error"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error(message = "Authentication Error"))
                return@flow
            }  catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(message = "Authentication Error"))
                return@flow
            }

            emit(Result.Success(profileResponse))
        }
    }


}



