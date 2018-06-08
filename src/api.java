/**
 * @apiDefine CentraServerGroup Centra-Server
 *用户登录 注册 等
 */

/**
 * @apiDefine UserParam
 * @apiParam {Number} reqType .
 * @apiParam {String} sign .
 * @apiParam {String} password User password.
 */

/**
 * @api {post} /user/signin  User sign in
 * @apiName signIn
 * @apiGroup CentraServerGroup
 * @apiUse UserParam
 * @apiParamExample {json} Request-Example:
        {
           "osType": 0,
           "password": "99",
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
