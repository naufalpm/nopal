package com.polstat.ukmesport.auth

import com.polstat.ukmesport.retrofit.AuthApi
import com.polstat.ukmesport.retrofit.Result
import com.polstat.ukmesport.retrofit.Token
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class AuthHelperImpl @Inject constructor(
    private val authApi: AuthApi,
    private val sessionCache: SessionCache
): AuthHelper {

    val session get() = sessionCache.getActiveSession()

    private fun saveSession(session: Session) {
        sessionCache.saveSession(session)
    }
    override suspend fun login(email: String, password: String): Flow<Result<Token>> {
        return flow {
            val authToken = try {
                val request = LoginRequest(email, password)
                val response = authApi.login(request)
                val session = Session(
                    user = User(
                        name = response.name,
                        email = response.email,
                    ),
                    token = response.token
                )

                saveSession(session)

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

            emit(Result.Success(authToken.token))
        }
    }

    override suspend fun register(
        name: String,
        email: String,
        password: String
    ): Flow<Result<RegisterResponse>> {
        return flow {
            val registerResponse = try {
                val request = RegisterRequest(name, email, password)
                val response = authApi.register(request)

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

            emit(Result.Success(registerResponse))
        }
    }
}
