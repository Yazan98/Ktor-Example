package presenter

import com.mongodb.client.model.InsertOneOptions
import kotlinx.coroutines.runBlocking
import models.profile.Profile
import org.koin.java.KoinJavaComponent.inject
import org.litote.kmongo.coroutine.CoroutineClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import utils.ReflexConsts
import utils.getCorrectPhoneNumber
import utils.sendMessage
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

class ProfilePresenter : KtorBasePresenter<Profile> {

    val logger: Logger = LoggerFactory.getLogger("ProfilePresenter")
    val client: CoroutineClient by inject()

    override suspend fun insertEntity(entity: Profile): Profile {
        logger.debug("... Insert Entity Started ...")
        logger.debug("... Insert Entity Started ... Data : $entity")

        entity.phoneNumber = getCorrectPhoneNumber(entity.phoneNumber)
        entity.enabled = true

        client.getDatabase(ReflexConsts.databaseName)
            .getCollection<Profile>(ReflexConsts.profileCollection)
            .insertOne(entity, InsertOneOptions())

        runBlocking {
            sendMessage(
                sender = ReflexConsts.smsSender,
                content = ReflexConsts.createdNewAccountSms,
                reciver = entity.phoneNumber
            )
        }

        logger.debug("... Insert Entity Finished ...")
        return getEntityById(entity.id)
    }

    override suspend fun getEntityById(entityId: UUID): Profile {
        return client.getDatabase(ReflexConsts.databaseName)
            .getCollection<Profile>(ReflexConsts.profileCollection)
            .findOneById(entityId)!!
    }

    override suspend fun deleteEntityById(entityId: UUID) {
        client.getDatabase(ReflexConsts.databaseName)
            .getCollection<Profile>(ReflexConsts.profileCollection)
            .deleteOneById(entityId)
    }

    override suspend fun deleteAllEntities() {
        client.getDatabase(ReflexConsts.databaseName)
            .getCollection<Profile>(ReflexConsts.profileCollection)
            .deleteMany()
    }

    override suspend fun getAllEntities(): ArrayList<Profile> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun updateEntity(entity: Profile): Profile {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
