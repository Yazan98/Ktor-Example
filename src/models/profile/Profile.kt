package models.profile

import org.bson.codecs.pojo.annotations.BsonId
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
 * Time : 7:53 PM
 */

data class Profile(
    @BsonId var id: UUID = UUID.randomUUID(),
    var email: String,
    var password: String?,
    var name: String,
    var enabled: Boolean,
    var type: String,
    var phoneNumber: String,
    var location: ProfileLocation
)

data class ProfileLocation(
    @BsonId var id: UUID = UUID.randomUUID(),
    var locationName: String,
    var latitude: Double,
    var longitude: Double
)
