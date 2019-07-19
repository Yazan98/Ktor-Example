# Reflex
Backend Project With Ktor and Mongo DB With Firebase

# Description

Reflex Is A Sample Application Written With Kotlin Depends On Ktor
That Support Firebase , Mongo Database , Swagger UI 

# Versions

Kotlin Version : 1.3.10

Ktor Version : 1.2.2

Koin Version : 2.0.1

Swagger Page : http://localhost:7090/

# Response 

1. Success Response :
```
{
  "data": {
    "id": "ace5fce3-a7f1-489e-8a95-9cdc6829895b",
    "email": "sjbfskfjb",
    "password": "dfosmngknsdlg",
    "name": "name",
    "enabled": true,
    "type": "USER",
    "phoneNumber": "+96283435435",
    "location": {
      "id": "548d6650-69ad-40a7-82b4-7de2aa1c4e1c",
      "locationName": "srgsf",
      "latitude": 1531.55,
      "longitude": 1535.2
    }
  },
  "code": 200,
  "message": "Success"
}
```

2. Error Response :
```
{
  "message": "Data Not Found",
  "code": 404,
  "stackTrace": [
    {
      "methodName": "getEntityById",
      "fileName": "ProfilePresenter.kt",
      "lineNumber": 80,
      "className": "presenter.ProfilePresenter",
      "nativeMethod": false
    },
    {
      "methodName": "invokeSuspend",
      "fileName": "ProfilePresenter.kt",
      "lineNumber": -1,
      "className": "presenter.ProfilePresenter$getEntityById$1",
      "nativeMethod": false
    },
    {
      "methodName": "resumeWith",
      "fileName": "ContinuationImpl.kt",
      "lineNumber": 33,
      "className": "kotlin.coroutines.jvm.internal.BaseContinuationImpl",
      "nativeMethod": false
    },
    {
      "methodName": "run",
      "fileName": "Dispatched.kt",
      "lineNumber": 238,
      "className": "kotlinx.coroutines.DispatchedTask",
      "nativeMethod": false
    },
    {
      "methodName": "safeExecute",
      "fileName": "AbstractEventExecutor.java",
      "lineNumber": 163,
      "className": "io.netty.util.concurrent.AbstractEventExecutor",
      "nativeMethod": false
    },
    {
      "methodName": "runAllTasks",
      "fileName": "SingleThreadEventExecutor.java",
      "lineNumber": 405,
      "className": "io.netty.util.concurrent.SingleThreadEventExecutor",
      "nativeMethod": false
    },
    {
      "methodName": "run",
      "fileName": "NioEventLoop.java",
      "lineNumber": 500,
      "className": "io.netty.channel.nio.NioEventLoop",
      "nativeMethod": false
    },
    {
      "methodName": "run",
      "fileName": "SingleThreadEventExecutor.java",
      "lineNumber": 906,
      "className": "io.netty.util.concurrent.SingleThreadEventExecutor$5",
      "nativeMethod": false
    },
    {
      "methodName": "run",
      "fileName": "ThreadExecutorMap.java",
      "lineNumber": 74,
      "className": "io.netty.util.internal.ThreadExecutorMap$2",
      "nativeMethod": false
    },
    {
      "methodName": "run",
      "fileName": "FastThreadLocalRunnable.java",
      "lineNumber": 30,
      "className": "io.netty.util.concurrent.FastThreadLocalRunnable",
      "nativeMethod": false
    },
    {
      "methodName": "run",
      "fileName": "Thread.java",
      "lineNumber": 748,
      "className": "java.lang.Thread",
      "nativeMethod": false
    }
  ]
}
```
