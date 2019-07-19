package routers

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.*
import models.profile.Profile
import org.koin.java.KoinJavaComponent.inject
import presenter.ProfilePresenter
import response.SuccessResponse
import utils.ApiPaths
import java.util.*

/**
 * Copyright 2019 Yazan Yarifi
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

/**
 * Created By : Yazan Tarifi
 * Date : 7/17/2019
 * Time : 7:47 PM
 */

//private val presenter: ProfilePresenter by inject()
private val presenter: ProfilePresenter by lazy { ProfilePresenter() }

fun Route.profileRouting() {
    route(ApiPaths.PROFILES) {

        post<Profile>("/") { request ->
            val result: Profile = presenter.insertEntity(request)
            call.respond(
                HttpStatusCode.OK,
                SuccessResponse(
                    result,
                    HttpStatusCode.OK.value,
                    "Success"
                )
            )
        }

        get("/{id}") { request ->
            val result: Profile = presenter.getEntityById(UUID.fromString(call.parameters["id"]))
            call.respond(
                HttpStatusCode.OK,
                SuccessResponse(
                    result,
                    HttpStatusCode.OK.value,
                    "Success"
                )
            )
        }

        delete("/{id}")  { request ->
            presenter.deleteEntityById(UUID.fromString(call.parameters["id"]))
            call.respond(
                HttpStatusCode.OK,
                "Deleted Successfully"
            )
        }

        delete {
            presenter.deleteAllEntities()
            call.respond(
                HttpStatusCode.OK,
                "Deleted Successfully"
            )
        }

    }
}
