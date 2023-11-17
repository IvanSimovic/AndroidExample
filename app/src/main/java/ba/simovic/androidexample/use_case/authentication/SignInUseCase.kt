package ba.simovic.androidexample.use_case.authentication

import javax.inject.Inject

class SignInUseCase @Inject constructor() {

    suspend fun run(email: String, password: String): Boolean =
        email == "test@test.com" && password == "test"

}