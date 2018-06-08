/**
 * @apiDefine CentraServerGroup Centra-Server
 *
 * 中心服务器 包括用户登录 注册 等
 */

/**
 * @apiDefine UserParam
 * @apiParam {Number} osType User os type.
 * @apiParam {String} AppId .
 * @apiParam {String} userId Users unique ID.
 * @apiParam {Number} TimeStamp time stamp.
 * @apiParam {String} cmdName .
 * @apiParam {String} deviceId .
 * @apiParam {Number} reqType .
 * @apiParam {String} sign .
 * @apiParam {String} password User password.
 */

/**
 * @api {post} http://cafe03.cafari.com:8080/user/signin  User sign in
 * @apiName signIn
 * @apiGroup CentraServerGroup
 * @apiUse UserParam
 * @apiParam {String} url 此处请求地址为http://cafe03.cafari.com:8080/user/signin .
 * @apiParamExample {json} Request-Example:
        {
           "osType": 0,
           "password": "99",
           "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
           "TimeStamp": 1514954405076,
           "cmdName": "login",
           "deviceId": "54c9df6653ce",
           "reqType": 4,
           "sign": "a24ab1b7bdc8bbfcd59ebe58d3cf113d",
           "userId": "99@qq.com"
        }

 
 * @apiSuccess {String} firstname Firstname of the User.
 * @apiSuccess {String} lastname  Lastname of the User.
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
 *     {
 *       "firstname": "John",
 *       "lastname": "Doe"
 *     }
 *
 * @apiErrorExample Error-Response:
       {
           "info": {
             "message": "Something went wrong with your Signin"
           },
           "code": 0
       }
 */

/**
 * @api {post} http://cafe03.cafari.com:8080/user/signup  User sign up
 * @apiName signUp
 * @apiGroup CentraServerGroup
 *
 * @apiParam {String} url 此处请求地址为http://cafe03.cafari.com:8080/user/signup .
 * @apiParam {String} firstName User optional.
 * @apiParam {String} cellPhone User optional.
 * @apiParam {String} lastName User optional.
 * @apiUse UserParam
 *
 * @apiParamExample {json} Request-Example:
    {
       "cellPhone": "",
       "firstName": "",
       "lastName": "",
       "password": "66",
       "username": "66",
       "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
       "TimeStamp": 1514955556940,
       "cmdName": "register",
       "deviceId": "54c9df6653ce",
       "reqType": 4,
       "sign": "f0d0e1501b37b901e30fa7ecfc07ad6a",
       "userId": "66@qq.com"
     }
 *    
 * @apiSuccess {String} accessId Users unique.
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
     {
       "user": {
         "verified": false,
         "accessId": "$2a$08$eQValOjCAQ2NNOEIHK\/SkuVbtA0JzKQFvXoVVr7Jsh4lizeQYIatS",
         "userId": "66@qq.com",
         "password": "$2a$08$dpo4OI42liP6xdXpJbc3FeGU\/TbgPPFhwuPoBBZiy8XB30OHNgkLe",
         "accountType": 1,
         "updatedAt": "2018-01-03T04:59:12.698Z",
         "createdAt": "2018-01-03T04:59:12.698Z"
       },
       "code": 1
     }
 * @apiError message error message.
 *
 * @apiErrorExample Error-Response:
       {
           "info": {
             "message": "Something went wrong with your Signin"
           },
           "code": 0
       }
 */

/**
 * @api {post} user/getnatinfo getnatinfo获取net info  
 * @apiName getnatinfo 
 * @apiGroup CentraServerGroup
 *
 * @apiParam {String} url (该字段不需要)此处请求地址为http://cafe03.cafari.com:8080/user/getnatinfo .成功返回202 并且带code
如果是400 并且告知incomplete request就是请求不完整缺了什么东西
401 是用户不存在 或者用户没有logged in
建议直接说用户未登录, 因为这里主要是查用户有没有login时cacahe的token 没有就说明是没有login, 当然用户不存在的话也是没有login了
 *
 * @apiParamExample {json} Request-Example:
     {
      "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
      "TimeStamp": 1528440103202,
      "accessId": "3180518198@qq.com",
      "cmdName": "getnetinfo",
      "deviceId": "c44eac125aaf",
      "reqType": 4,
      "sign": "6ff3bde4c181c982d5eb84cbceb7356f",
      "userId": "3180518198@qq.com"
    }
 *    
 * @apiSuccess {String} accessId Users unique.
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
 {
	"deviceId": "c44eac125aaf",
	"lastHeartbeat": "2018-06-08T07:22:37.861Z",
	"internalIp": "192.168.50.228",
	"realIp": "113.66.229.63",
	"sslPort": "54396"
 }
 */

/**
 * @api {post} user/invite invite user  
 * @apiName invite 
 * @apiGroup CentraServerGroup
 * @apiParam {String} url (该字段不需要)此处请求地址为http://cafe03.cafari.com:8080/user/invite 干嘛的？
拥有者用该接口生成邀请码(有效期一个小时)，新用户绑定盒子可以通过询问拥有者邀请码；
怎么用？（userId:你想要邀请的新用户的userId(用户注册的手机或者邮箱))
(针对拥有者）

 (post)url:http://cafe03.cafari.com/user/invite/
 请求body:
 │ {
 │   "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
 │   "TimeStamp": 1523438017926,
 │   "accessId": "3180518198@qq.com",
 │   "cmdName": "invite",
 │   "deviceId": "c44eac125aa4",
 │   "reqType": 4,
 │   "sign": "35db33295801f6a0df24ede6a8e1692b",
 │   "targetId": "2225544@qq.com",
 │   "token": "Ov3Lf2zWjTpVZxvUWxxLHA==",
 │   "userId": "3180518198@qq.com"
 │ }
 └────────────────────────────────────────────────────────────────────────────────────────────────────────────────
 ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────
 │ HttpBus$1.onSuccess  (HttpBus.java:163)
 │    HttpBus$1.onSuccess  (HttpBus.java:208)
 ├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄
 │ 响应body:
 └────────────────────────────────────────────────────────────────────────────────────────────────────────────────
 ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────
 │ HttpBus$1.onSuccess  (HttpBus.java:163)
 │    HttpBus$1.onSuccess  (HttpBus.java:209)
 ├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄
 │ {
 │   "invitation": "511547"
 │ }
 └──
(针对新用户，绑定盒子的第二种方式：通过getnatinfo接口拿到url和deviceId，这里顺带提一下第一种方式：通过蓝牙得到url和deviceId） 
 * @apiParamExample {json} Request-Example:
     {
      "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
      "TimeStamp": 1528440103202,
      "accessId": "3180518198@qq.com",
      "cmdName": "getnetinfo",
      "deviceId": "c44eac125aaf",
      "reqType": 4,
      "sign": "6ff3bde4c181c982d5eb84cbceb7356f",
      "userId": "3180518198@qq.com"
    }
 *    
 * @apiSuccess {String} invitation User invitation.
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
     {
        "invitation": "511547"
     }
 */

/**
 * @api {post} user/verfication phone code  
 * @apiName verfication 
 * @apiGroup CentraServerGroup
 * @apiParam {String} url (该字段不需要)此处请求地址为http://cafe03.cafari.com:8080/user/verfication
 202表示成功(但是不代表发送成功, 只是发送消息放入队列重, 如果此时他的邮箱或者电话是错误的导致信息不能送达 或者我们的发送服务器有问题, 是不会知道的, 但是app上可以认为是发送成功了)
400 表示请求不完整
403表示用户发送请求已经超过一天最大次数 现在是4次 之后我打算用11次(4次是为了方便测试)
404表示表示如果是找回密码状态 用户不存在
409表示用户如果是注册请求激活码, 用户已存在
429表示激活码发送处于冷却(现在是60秒只能发一次, app这里已经做了限制, 服务器这里也加一层防止被攻击) 
@apiParamExample {json} Request-Example:
     {
      "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
      "TimeStamp": 1528440103202,
      "cmdName": "verfication",
      "deviceId": "c44eac125aaf",
      "reqType": 4,
      "sign": "6ff3bde4c181c982d5eb84cbceb7356f",
      "userId": "3180518198@qq.com"
      "email": "3180518198@qq.com"
      "phone": ""
    }
 *    
 * @apiSuccess {String} invitation User invitation.
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
     {
        "ok"
     }
 */

/**
 * @api {get} user/keystore get user keyStore  
 * @apiName keystore 
 * @apiGroup CentraServerGroup
 * @apiParam {String} description (该字段不需要)此处请求地址为http://cafe03.cafari.com:8080/user/keystore
200 keystore返回成功
400请求不完整
401 用户没有登录(可能用户不存在)
404 找不到记录(一斑就是用户不存在, 我可能以后会去掉这个错误吗,现在暂时留着)
500 服务器错误
@apiParamExample {json} Request-Example:
    {
      "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
      "TimeStamp": 1528440103202,
      "cmdName": "keystore",
      "deviceId": "c44eac125aaf",
      "reqType": 4,
      "sign": "6ff3bde4c181c982d5eb84cbceb7356f",
      "userId": "3180518198@qq.com"
    }
 *    
 * @apiSuccess {String} file keystore file.
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
     {
        "ok"
     }
 */

/**
 * @api {post} user/comment user comment 
 * @apiName comment 
 * @apiGroup CentraServerGroup
 * @apiParam {String} url (该字段不需要)此处请求地址为http://cafe03.cafari.com:8080/user/comment
200 意见提交成功
401 用户没有登录或者用户不存在
429 表示请求过于频繁 15分钟内只能发一次
500 服务器错误
@apiParamExample {json} Request-Example:
     {
      "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
      "TimeStamp": 1528440103202,
      "cmdName": "comment",
      "deviceId": "c44eac125aaf",
      "reqType": 4,
      "sign": "6ff3bde4c181c982d5eb84cbceb7356f",
      "userId": "3180518198@qq.com"
      "email": "3180518198@qq.com"
      "phone": ""
      "comment":"my name is comment"
    }
 *    
 * @apiSuccess {String} comment comment.
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
     {
        "ok"
     }
 */
/**
 * @api {post} user/getbinddevice getbinddevice 
 * @apiName getbinddevice 
 * @apiGroup CentraServerGroup
 * @apiParam {String} url (该字段不需要)此处请求地址为http://cafe03.cafari.com:8080/user/getbinddevice
200 返回ownerdevice
400 请求不完整
401 没有登录或者用户不存在
404 没有ownerdevice
500 服务器错误
@apiParamExample {json} Request-Example:
{
	"AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
	"TimeStamp": 1528442549578,
	"accessId": "3180518198@qq.com",
	"cmdName": "getbinddevice",
	"deviceId": "",
	"reqType": 4,
	"sign": "61536adaaedfe245a7f45bb99b67f49c",
	"token": "H8IPm7M0c8FaxYdMVvzLqA==",
	"userId": "3180518198@qq.com"
}
 *    
 * @apiSuccess {String} deviceId User bind box deviceId 
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
     {
       {"deviceId":"c44eac125aaf"}
     }
 */

/**
 * @api {post} user/appinfo App update info 
 * @apiName appinfo
 * @apiGroup CentraServerGroup
 * @apiParam {String} url (该字段不需要)此处请求地址为http://cafe03.cafari.com:8080/user/appinfo
@apiParamExample {json} Request-Example:
     {
      "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
      "TimeStamp": 1528440103202,
      "cmdName": "appinfo",
      "deviceId": "c44eac125aaf",
      "reqType": 4,
      "sign": "6ff3bde4c181c982d5eb84cbceb7356f",
      "userId": "3180518198@qq.com"
    }
 *    
 * @apiSuccess {String} version Version num.
 * @apiSuccess {String} updateUrl download url.
 * @apiSuccess {String} info hite info.
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
    {
       "version": "1012",
       "updateUrl": "http:\/\/cafe02.cafari.com:19065\/APKs\/CafeClient1012.apk",
       "info": "undefined"
    }
 */


/**
 * @apiDefine DeviceFromBServerGroup DeviceFromB-Server 
 *
 * B-Server deviceInfo etc 
 */

/**
 * @apiDefine ParamFromBServer
 * @apiParam {String} AppId .
 * @apiParam {Number} TimeStamp time stamp.
 * @apiParam {String} accessId sign in or sign back.
 * @apiParam {String} cmdName .
 * @apiParam {String} deviceId .
 * @apiParam {Number} reqType .
 * @apiParam {String} sign .
 * @apiParam {String} userId .
 */

/**
 * @api {post} /pingDevice.json ping device 
 * @apiName pingDevice 
 * @apiGroup DeviceFromBServerGroup
 * @apiUse ParamFromBServer
 * @apiParam {String} deviceId box id

 * @apiParamExample {json} Request-Example:
     {
       "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
       "TimeStamp": 1528442791398,
       "accessId": "3180518198@qq.com",
       "cmdName": "pingDevice",
       "data": {
         "deviceId": "c44eac125aaf"
       },
       "deviceId": "c44eac125aaf",
       "reqType": 4,
       "sign": "f65ee524ec475b64c08353ed164bbdd1",
       "userId": "3180518198@qq.com"
     }

 * @apiSuccess {String} info Hint info.
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
    {
       "userId": "3180518198@qq.com",
       "accessId": "3180518198@qq.com",
       "deviceId": "c44eac125aaf",
       "cmdName": "pingDevice",
       "reqType": 4,
       "code": 1,
       "info": "成功",
       "data": "Success"
     }
 *
 * @apiErrorExample Error-Response:
    {
       "userId": "MYUNIONID",
       "accessId": "",
       "deviceId": "54c9df6653ce",
       "cmdName": "pingDevice",
       "reqType": 4,
       "code": 2001,
       "info": "无权限访问"
    }
 */


/**
 * @api {post} /createOperateCode.json Create operate code 
 * @apiName createOperateCode 
 * @apiGroup DeviceFromBServerGroup
 * @apiUse ParamFromBServer
 * @apiParam {String} operateCode 让用户输入6位数字

 * @apiParamExample {json} Request-Example:
    {
       "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
       "TimeStamp": 1514957926305,
       "accessId": "yiliangaccess",
       "cmdName": "createOperateCode",
       "data": {
         "operateCode": "888555"
       },
       "deviceId": "54c9df6653ce",
       "reqType": 4,
       "sign": "963330dff95eabee42ee260459e0168c",
       "userId": "MYUNIONID"
    }

 * @apiSuccess {String} info Hint info.
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
    {
       "userId": "MYUNIONID",
       "accessId": "yiliangaccess",
       "deviceId": "54c9df6653ce",
       "cmdName": "createOperateCode",
       "reqType": 4,
       "code": 1,
       "info": "成功"
    }
 *
 * @apiErrorExample Error-Response:
    {
       "userId": "MYUNIONID",
       "accessId": "",
       "deviceId": "54c9df6653ce",
       "cmdName": "createOperateCode",
       "reqType": 4,
       "code": 2001,
       "info": "无权限访问"
    }
 */

/**
 * @api {post} /changeOperateCode.json Change operate code 
 * @apiName changeOperateCode
 * @apiGroup DeviceFromBServerGroup
 * @apiUse ParamFromBServer
 * @apiParam {String} newOperateCode 让用户输入new 6位数字
 * @apiParam {String} oldOperateCode old 6位数字

 * @apiParamExample {json} Request-Example:
    {
      "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
      "TimeStamp": 1514958301886,
      "accessId": "yiliangaccess",
      "cmdName": "changeOperateCode",
      "data": {
        "newOperateCode": "111111",
        "oldOperateCode": "888555"
      },
      "deviceId": "54c9df6653ce",
      "reqType": 4,
      "sign": "a6bdc2cec593c3aab88cb852aa78cd37",
      "userId": "MYUNIONID"
    }

 * @apiSuccess {String} info Hint info.
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
    {
       "userId": "MYUNIONID",
       "accessId": "yiliangaccess",
       "deviceId": "54c9df6653ce",
       "cmdName": "changeOperateCode",
       "reqType": 4,
       "code": 1,
       "info": "成功"
    }
 *
 * @apiError {String} info Hint info.
 * @apiError {Number} code Error code.
 *
 * @apiErrorExample Error-Response:
    {
       "userId": "MYUNIONID",
       "accessId": "",
       "deviceId": "54c9df6653ce",
       "cmdName": "changeOperateCode",
       "reqType": 4,
       "code": 2001,
       "info": "无权限访问"
    }
 */

/**
 * @api {post} /getUserList.json Get users from device 
 * @apiName getUserList
 * @apiGroup DeviceFromBServerGroup
 * @apiUse ParamFromBServer
 * @apiParam {Boolean} isIncludeUser . 
 * @apiParam {Number} pageNo . 

 * @apiParamExample {json} Request-Example:
    {
       "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
       "TimeStamp": 1514959261606,
       "accessId": "",
       "cmdName": "getUserList",
       "data": {
         "isIncludeUser": false,
         "pageNo": 0
       },
       "deviceId": "54c9df6653ce",
       "reqType": 4,
       "sign": "c9414d716a6da46809c110daffb1ddd5",
       "userId": "MYUNIONID"
    }

 * @apiSuccess {Number} isowner 1: isOwner 0: 普通用户.
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
    {
       "userId": "MYUNIONID",
       "accessId": "yiliangaccess",
       "deviceId": "54c9df6653ce",
       "cmdName": "getUserList",
       "reqType": 4,
       "code": 1,
       "info": "成功",
       "data": {
         "userNum": 1,
         "userList": [
           {
             "accessId": "yiliangaccess",
             "userName": "",
             "avatar": "",
             "isowner": 1,
             "fileNum": 2
           }
         ],
         "totalPages": 1,
         "pageNo": 0
       }
    }
 *
 * @apiError {String} info Hint info.
 * @apiError {Number} code Error code.
 *
 * @apiErrorExample Error-Response:
    {
       "userId": "MYUNIONID",
       "accessId": "",
       "deviceId": "54c9df6653ce",
       "cmdName": "getUserList",
       "reqType": 4,
       "code": 2001,
       "info": "无权限访问"
    }
 */

/**
 * @api {post} /getDeviceInfo.json Get deviceInfo from device 
 * @apiName getDeviceInfo
 * @apiGroup DeviceFromBServerGroup
 * @apiUse ParamFromBServer

 * @apiParamExample {json} Request-Example:
    {
      "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
      "TimeStamp": 1514959261597,
      "accessId": "",
      "cmdName": "getDeviceInfo",
      "data": {},
      "deviceId": "54c9df6653ce",
      "reqType": 4,
      "sign": "57dbdee8e8d555e14e216daacbd895d2",
      "userId": "MYUNIONID"
    }

 * @apiSuccess {Number} appCode .
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
    {
       "code": 1,
       "info": "成功",
       "data": {
         "userdCapacity": "163.28MB",
         "freeCapacity": "8.44GB",
         "capacity": "9.95GB",
         "ownerName": "",
         "ownerImg": "",
         "ownerAccessId": "yiliangaccess",
         "appCode": 1,
         "deviceSn": "CBMOCHA0102BBHUIJDEPF",
         "appVersion": "1.0",
         "mac": "02:00:00:00:00:00",
         "atoCode": 100000,
         "percent": "1.60%",
         "hasOperateCode": false
       },
       "deviceId": "54c9df6651d2",
       "cmdName": "getDeviceInfo"
    }
 *
 * @apiError {String} info Hint info.
 * @apiError {Number} code Error code.
 *
 * @apiErrorExample Error-Response:
    {
       "userId": "MYUNIONID",
       "accessId": "",
       "deviceId": "54c9df6653ce",
       "cmdName": "getDeviceInfo",
       "reqType": 4,
       "code": 2001,
       "info": "无权限访问"
    }
 */

/**
 * @api {post} /unBind.json unBind user 
 * @apiName unBind 
 * @apiGroup DeviceFromBServerGroup
 * @apiUse ParamFromBServer
 * @apiParam {String} delAccessId 被删除用户的accessId 
 * @apiParam {String} operateCode 6位数字

 * @apiParamExample {json} Request-Example:
    {
      "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
      "TimeStamp": 1514958301886,
      "accessId": "yiliangaccess",
      "cmdName": "unBind",
      "data": {
        "delAccessId": "111111",
        "operateCode": "888555"
      },
      "deviceId": "54c9df6653ce",
      "reqType": 4,
      "sign": "a6bdc2cec593c3aab88cb852aa78cd37",
      "userId": "MYUNIONID"
    }

 * @apiSuccess {String} info Hint info.
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
    {
       "userId": "MYUNIONID",
       "accessId": "yiliangaccess",
       "deviceId": "54c9df6653ce",
       "cmdName": "unBind",
       "reqType": 4,
       "code": 1,
       "info": "成功"
    }
 *
 * @apiError {String} info Hint info.
 * @apiError {Number} code Error code.
 *
 * @apiErrorExample Error-Response:
    {
       "userId": "MYUNIONID",
       "accessId": "",
       "deviceId": "54c9df6653ce",
       "cmdName": "unBind",
       "reqType": 4,
       "code": 2001,
       "info": "无权限访问"
    }
 */

/**
 * @api {post} /changeDeviceOwner.json changeDeviceOwner 
 * @apiName changeDeviceOwner 
 * @apiGroup DeviceFromBServerGroup
 * @apiUse ParamFromBServer
 * @apiParam {String} changer 被删除用户的accessId 
 * @apiParam {String} operateCode 6位数字

 * @apiParamExample {json} Request-Example:
    {
      "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
      "TimeStamp": 1514958301886,
      "accessId": "yiliangaccess",
      "cmdName": "changeOperateCode",
      "data": {
        "changer": "111111",
        "operateCode": "888555"
      },
      "deviceId": "54c9df6653ce",
      "reqType": 4,
      "sign": "a6bdc2cec593c3aab88cb852aa78cd37",
      "userId": "MYUNIONID"
    }

 * @apiSuccess {String} info Hint info.
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
    {
       "userId": "MYUNIONID",
       "accessId": "yiliangaccess",
       "deviceId": "54c9df6653ce",
       "cmdName": "changeOperateCode",
       "reqType": 4,
       "code": 1,
       "info": "成功"
    }
 *
 * @apiError {String} info Hint info.
 * @apiError {Number} code Error code.
 *
 * @apiErrorExample Error-Response:
    {
       "userId": "MYUNIONID",
       "accessId": "",
       "deviceId": "54c9df6653ce",
       "cmdName": "changeOperateCode",
       "reqType": 4,
       "code": 2001,
       "info": "无权限访问"
    }
 */

/**
 * @api {post} /mergeLabel.json mergeLabel 
 * @apiName mergeLabel
 * @apiGroup DeviceFromBServerGroup
 * @apiUse ParamFromBServer
 * @apiParam {Array} labelIds 被合并的LabelId在后 
 *
 * @apiParamExample {json} Request-Example:
    {
       "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
       "TimeStamp": 1514960955158,
       "accessId": "yiliangaccess",
       "cmdName": "mergeLabel",
       "data": {
         "labelIds": [
           25,
           2
         ]
       },
       "deviceId": "54c9df6653ce",
       "reqType": 4,
       "sign": "b3abbb670ecd7766668cf4bd6b5d9b15",
       "userId": "MYUNIONID"
    }

 * @apiSuccess {String} info Hint info.
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
    {
      "userId": "MYUNIONID",
      "accessId": "yiliangaccess",
      "deviceId": "54c9df6653ce",
      "cmdName": "mergeLabel",
      "reqType": 4,
      "code": 1,
      "info": "成功",
      "Status": {
        "Status": "Successful"
      }
    }
 *
 * @apiError {String} info Hint info.
 * @apiError {Number} code Error code.
 *
 * @apiErrorExample Error-Response:
    {
       "userId": "MYUNIONID",
       "accessId": "",
       "deviceId": "54c9df6653ce",
       "cmdName": "mergeLabel",
       "reqType": 4,
       "code": 2001,
       "info": "无权限访问"
    }
 */

/**
 * @api {post} /updateLabel.json updateLabel 
 * @apiName updateLabel
 * @apiGroup DeviceFromBServerGroup
 * @apiUse ParamFromBServer
 * @apiParam {labelId} labelId label的id 
 * @apiParam {String} newName 通讯录里面的人 
 *
 * @apiParamExample {json} Request-Example:
    {
       "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
       "TimeStamp": 1514961536579,
       "accessId": "yiliangaccess",
       "cmdName": "updateLabel",
       "data": {
         "labelId": 6,
         "newName": "李易峰",
         "photoId": 0
       },
       "deviceId": "54c9df6653ce",
       "reqType": 4,
       "sign": "c2472822d8296a3b3457ee2b37b323e7",
       "userId": "MYUNIONID"
    }

 * @apiSuccess {String} info Hint info.
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
    {
       "userId": "MYUNIONID",
       "accessId": "yiliangaccess",
       "deviceId": "54c9df6653ce",
       "cmdName": "updateLabel",
       "reqType": 4,
       "code": 1,
       "info": "成功"
    }
 *
 * @apiError {String} info Hint info.
 * @apiError {Number} code Error code.
 *
 * @apiErrorExample Error-Response:
    {
       "userId": "MYUNIONID",
       "accessId": "",
       "deviceId": "54c9df6653ce",
       "cmdName": "updateLabel",
       "reqType": 4,
       "code": 2001,
       "info": "无权限访问"
    }
 */

/**
 * @api {post} /createLabel.json createLabel 
 * @apiName createLabel
 * @apiGroup DeviceFromBServerGroup
 * @apiUse ParamFromBServer
 * @apiParam {labelId} labelId label的id 
 * @apiParam {String} name 通讯录里面的人 
 *
 * @apiParamExample {json} Request-Example:
    {
       "AppId": "60076467277E4B1DD42F21B4DB5BD5A7",
       "TimeStamp": 1514961536579,
       "accessId": "yiliangaccess",
       "cmdName": "createLabel",
       "data": {
         "labelId": 6,
         "name": "jack"
       },
       "deviceId": "54c9df6653ce",
       "reqType": 4,
       "sign": "c2472822d8296a3b3457ee2b37b323e7",
       "userId": "MYUNIONID"
    }

 * @apiSuccess {String} info Hint info.
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
    {
       "userId": "MYUNIONID",
       "accessId": "yiliangaccess",
       "deviceId": "54c9df6653ce",
       "cmdName": "createLabel",
       "reqType": 4,
       "code": 1,
       "info": "成功"
    }
 *
 * @apiError {String} info Hint info.
 * @apiError {Number} code Error code.
 *
 * @apiErrorExample Error-Response:
    {
       "userId": "MYUNIONID",
       "accessId": "",
       "deviceId": "54c9df6653ce",
       "cmdName": "createLabel",
       "reqType": 4,
       "code": 2001,
       "info": "无权限访问"
    }
 */
