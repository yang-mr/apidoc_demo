package com.zjxx.android.cafebox;

/**
 * Created by mark on 2018/1/3.
 */

public class Test {
    //url:http://192.168.50.222:8080/command/WeiPhoto/md5CheckFile.json
    //请求body:{"AppId":"60076467277E4B1DD42F21B4DB5BD5A7","TimeStamp":1514960523713,"accessId":"yiliangaccess","cmdName":"md5CheckFile","data":{"fileMd5":"A0235E6793AC2FFBB4B66E167442DF9B","fileSize":3222043},"deviceId":"54c9df6653ce","reqType":4,"sign":"dbd9cdb6428c79f665bde8a9af079ed2","userId":"MYUNIONID"}
    //响应body:{"userId":"MYUNIONID","accessId":"yiliangaccess","deviceId":"54c9df6653ce","cmdName":"md5CheckFile","reqType":4,"code":1,"info":"成功","data":{"isHave":false}}
    /**
     * @api {post} /md5CheckFile.json 上传地址
     * @apiName 上传地址
     * @apiGroup HomePage
     * @apiVersion 0.1.0
     *
     *@apiParamExample {json} 请求参数:
     *{
    "AppId":"60076467277E4B1DD42F21B4DB5BD5A7",
    "TimeStamp":1514960523713,
    "accessId":"yiliangaccess",
    "cmdName":"md5CheckFile",
    "data":{
    "fileMd5":"A0235E6793AC2FFBB4B66E167442DF9B",
    "fileSize":3222043
    },
    "deviceId":"54c9df6653ce",
    "reqType":4,
    "sign":"dbd9cdb6428c79f665bde8a9af079ed2",
    "userId":"MYUNIONID"
    }
     *
     * @apiParam {String} cmdName md5CheckFile.
     * @apiParam {String} fileMd5 生成文件MD5.
     *
     *

     *
     *@apiSuccessExample {json} Success-Response:
     *     HTTP/1.1 200 OK
     *    {
    "userId":"MYUNIONID",
    "accessId":"yiliangaccess",
    "deviceId":"54c9df6653ce",
    "cmdName":"md5CheckFile",
    "reqType":4,
    "code":1,
    "info":"成功",
    "data":{
    "isHave":false
    }
    }
     */

    /**
     * @api {post} /device/directTransfer.json 首页列表
     * @apiName 第一层列表
     * @apiGroup All
     * @apiVersion 0.1.0
     *
     *@apiParamExample {json} 请求参数:
     *{
     *"AppId":"60076467277E4B1DD42F21B4DB5BD5A7",
     *"TimeStamp":1514943756644,
     *"accessId":"yiliangaccess",
     *"cmdName":"getGroupedLabelList",
     *"data":{
     *"category":"",
     *"className":"photo",
     *"dateType":2,
     *"pageNo":0
     *},
     *"deviceId":"54c9df6653ce",
     *"reqType":4,
     *"sign":"c0ba6a9127a3c0dd2c44ad26dc452d01",
     *"userId":"MYUNIONID"
     *}
     *
     * @apiParam {String} AppId AppId 60076467277E4B1DD42F21B4DB5BD5A7.
     * @apiParam {String} TimeStamp 时间戳.
     * @apiParam {String} accessId accessId yiliangaccess.
     * @apiParam {String} cmdName getGroupedLabelList.
     * @apiParam {String} data getGroupedLabelList.
     * @apiParam {String} deviceId 设备MAC地址.
     * @apiParam {String} reqType 4.
     * @apiParam {String} sign 除data之外其他7个参数值的随机相加字符串的MD5值.
     * @apiParam {String} userId MYUNIONID.
     *@apiParam {String} category 选填.
     *@apiParam {String} className photo.
     *@apiParam {String} dateType 2.
     *@apiParam {String} pageNo 页数.
     *
     *
     *@apiParam {String} urlPerson 当前页面url,取前四个.
     *
     *
     * 1e135566fc2f5756e94ec4d0d32dfb58 为mac地址的SHA-1值后32位,+.cafe.cphotobox.com:10657端口.
     * 69BCD7F17DB413AA04276A4396A7BF74为labels.coverFace.
     *http://192.168.50.222:8080/face_thumb/69BCD7F17DB413AA04276A4396A7BF74.jpg.
     *http://1e135566fc2f5756e94ec4d0d32dfb58.cafe.cphotobox.com:10657/face_thumb/69BCD7F17DB413AA04276A4396A7BF74.jpg.
     *
     *@apiParam {String} urlTime 当前页面url,取前四个.
     *
     *
     * 57BDF02DE4124680E54E5A3100CEE47B为listPath.fileMd5.
     * http://192.168.50.222:8080/public/57BDF02DE4124680E54E5A3100CEE47B.jpg.
     * http://1e135566fc2f5756e94ec4d0d32dfb58.cafe.cphotobox.com:10657/public/57BDF02DE4124680E54E5A3100CEE47B.jpg.
     *
     *
     *
     *@apiSuccessExample {json} Success-Response:
     *     HTTP/1.1 200 OK
     *     {
     *    "userId":"MYUNIONID",
     *    "accessId":"yiliangaccess",
     *    "deviceId":"54c9df6653ce",
     *    "cmdName":"getGroupedLabelList",
     *    "reqType":4,
     *    "code":1,
     *    "info":"成功",
     *    "data":{
     *    "totalPages":1,
     *    "pageNo":0,
     *   "totalFiles":265,
     *   "listCate":[
    {
    "category":"person",
    "labelNum":34,
    "labels":{
    "id":25,
    "name":"other",
    "updateTime":1514951713545,
    "owner":"yiliangaccess",
    "imgId":0,
    "fileNum":3,
    "coverFace":"69BCD7F17DB413AA04276A4396A7BF74"
    }
    },
    {
    "category":"time",
    "totalFiles":265,
    "pageNo":0,
    "listPath":{
    "id":"257",
    "name":"IMG_20171226_111028.jpg",
    "fileMd5":"57BDF02DE4124680E54E5A3100CEE47B",
    "size":"2.69MB",
    "ower":"yiliangaccess",
    "isFile":true,
    "filePath":"/sdcard/cafari/photocomb/yiliangaccess/来自HUAWEI_SLA-TL10/2018-01/IMG_20171226_111028.jpg",
    "isPri":true,
    "isCollect":false,
    "lastModified":1514286631000,
    "mime_type":"image/jpeg"
    }
    }
    ]
     *   }
     *   }
     */


    /**
     * @api {post} /device/directTransfer.json 第二层列表-Time
     * @apiName 第二层列表-Time
     * @apiGroup List
     *
     * @apiParamExample {json} 请求参数:
     * {
    "AppId":"60076467277E4B1DD42F21B4DB5BD5A7",
    "TimeStamp":1514950936491,
    "accessId":"yiliangaccess",
    "cmdName":"getFilePathByTime",
    "data":{
    "category":"time",
    "className":"photo",
    "dateType":2,
    "pageNo":0
    },
    "deviceId":"54c9df6653ce",
    "reqType":4,
    "sign":"9ae6ed6ac3a8713e620f4e8415b9a526",
    "userId":"MYUNIONID"
    }
     * @apiVersion 0.1.0
     * @apiParam {String} cmdName getFilePathByTime.
     * @apiParam {String} category time.
     * @apiParam {String} url 当前页面展示的url.
     *
     * 当在内网时 = 盒子ip地址+:8080端口+/public+listpath.fileMd5+.jpg.
     *http://192.168.50.222:8080/public/E095FC290160F501D230016D8D83F829.jpg .
     *
     * 当在外网时 = mac地址的SHA-1值后32位,+.cafe.cphotobox.com:10657端口+/public+listpath.fileMd5+.jpg.
     *http://1e135566fc2f5756e94ec4d0d32dfb58.cafe.cphotobox.com:10657/public/E095FC290160F501D230016D8D83F829.jpg
     *
     *
     *
     * @apiParam {String} ThirdLayerURL 用在第三层中展示,如果本地有此图片则加载本地图片,没有则去网络获取.
     *
     * 当在内网时 = 盒子ip地址+:8083端口+/getFile?fileId= +当前图片id+&accessId=yiliangaccess&deviceId=54c9df6653ce.
     *http://192.168.50.222:8083/getFile?fileId=261&accessId=yiliangaccess&deviceId=54c9df6653ce.
     *
     * 当在外网时 = mac地址的SHA-1值后32位,+.cafe.cphotobox.com:10660端口+/getFile?fileId= +当前图片id+ &accessId=yiliangaccess&deviceId=54c9df6653ce.
     *http://1e135566fc2f5756e94ec4d0d32dfb58.cafe.cphotobox.com:10660/getFile?fileId=261&accessId=yiliangaccess&deviceId=54c9df6653ce .
     *
     * @apiSuccessExample {json} Success-Response:
     * {
    "userId":"MYUNIONID",
    "accessId":"yiliangaccess",
    "deviceId":"54c9df6653ce",
    "cmdName":"getFilePathByTime",
    "reqType":4,
    "code":1,
    "info":"成功",
    "data":{
    "category":"time",
    "totalFiles":265,
    "pageNo":0,
    "listPath":[
    {
    "id":"261",
    "name":"IMG_20171222_141515.jpg",
    "fileMd5":"E095FC290160F501D230016D8D83F829",
    "size":"2.90MB",
    "ower":"yiliangaccess",
    "isFile":true,
    "filePath":"/sdcard/cafari/photocomb/yiliangaccess/来自HUAWEI_SLA-TL10/2018-01/IMG_20171222_141515.jpg",
    "isPri":true,
    "isCollect":false,
    "lastModified":1513952118000,
    "mime_type":"image/jpeg"
    }
    ]
    }
    }
     *
     */


    /**
     * @api {post} /device/directTransfer.json 第二层列表-Person
     * @apiName 第二层列表-Person
     * @apiGroup List
     *
     * @apiParamExample {json} 请求参数:
     * {
    "AppId":"60076467277E4B1DD42F21B4DB5BD5A7",
    "TimeStamp":1514953727726,
    "accessId":"yiliangaccess",
    "cmdName":"getLabelList",
    "data":{
    "category":"person",
    "className":"photo",
    "dateType":2,
    "pageNo":0
    },
    "deviceId":"54c9df6653ce",
    "reqType":4,
    "sign":"7263e3440a4f8a7bd0bf161375698ef3",
    "userId":"MYUNIONID"
    }
     * @apiVersion 0.1.0
     * @apiParam {String} cmdName getLabelList.
     * @apiParam {String} category person.
     *@apiSuccessExample {json} Success-Response:
     * {
    "userId":"MYUNIONID",
    "accessId":"yiliangaccess",
    "deviceId":"54c9df6653ce",
    "cmdName":"getLabelList",
    "reqType":4,
    "code":1,
    "info":"成功",
    "data":{
    "labelNum":34,
    "Labels":[
    {
    "id":25,
    "name":"other",
    "updateTime":1514951713545,
    "owner":"yiliangaccess",
    "imgId":0,
    "fileNum":3,
    "coverFace":"69BCD7F17DB413AA04276A4396A7BF74"
    }
    ],
    "totalPages":2,
    "pageNo":0
    }
    }
     *
     *
     */

    /**
     * @api {post} /device/directTransfer.json 第三层列表-暂时Person分类
     * @apiName 第三层列表-展示Person分类
     * @apiGroup List
     *
     * @apiParamExample {json} 请求参数:
     * {
    "AppId":"60076467277E4B1DD42F21B4DB5BD5A7",
    "TimeStamp":1514955655543,
    "accessId":"yiliangaccess",
    "cmdName":"getFilePathForLabel",
    "data":{
    "className":"photo",
    "dateType":2,
    "labelId":8,
    "pageNo":0
    },
    "deviceId":"54c9df6653ce",
    "reqType":4,
    "sign":"d9528d6968affdce49490511a2b8fc3e",
    "userId":"MYUNIONID"
    }
     * @apiVersion 0.1.0
     * @apiParam {String} cmdName getFilePathForLabel.
     * @apiParam {String} className photo.
     * @apiParam {String} labelId 上级界面传递.
     *
     * @apiParam {String} url 当前页面展示的url.
     *
     * 当在内网时 = 盒子ip地址+:8080端口+/public+listpath.fileMd5+.jpg.
     *http://192.168.50.222:8080/public/B633DA681E9C5BD741D0D87997EFB7EF.jpg
     *
     * 当在外网时 = mac地址的SHA-1值后32位,+.cafe.cphotobox.com:10657端口+/public+listpath.fileMd5+.jpg.
     *http://1e135566fc2f5756e94ec4d0d32dfb58.cafe.cphotobox.com:10657/public/B633DA681E9C5BD741D0D87997EFB7EF.jpg
     *
     *
     *
     * @apiParam {String} FourthLayerURL 用在第四层中展示,如果本地有此图片则加载本地图片,没有则去网络获取.
     *
     * 当在内网时 = 盒子ip地址+:8083端口+/getFile?fileId= +当前图片id+&accessId=yiliangaccess&deviceId=54c9df6653ce.
     *http://192.168.50.222:8083/getFile?fileId=15&accessId=yiliangaccess&deviceId=54c9df6653ce
     *
     * 当在外网时 = mac地址的SHA-1值后32位,+.cafe.cphotobox.com:10660端口+/getFile?fileId= +当前图片id+ &accessId=yiliangaccess&deviceId=54c9df6653ce.
     *http://1e135566fc2f5756e94ec4d0d32dfb58.cafe.cphotobox.com:10660/getFile?fileId=15&accessId=yiliangaccess&deviceId=54c9df6653ce .
     * @apiSuccessExample {json} Success-Response:
     * {
    "userId":"MYUNIONID",
    "accessId":"yiliangaccess",
    "deviceId":"54c9df6653ce",
    "cmdName":"getFilePathForLabel",
    "reqType":4,
    "code":1,
    "info":"成功",
    "data":{
    "coverFace":"77ED9C1C1BFD21EA34C3D5BA506DDE5F",
    "personName":"other",
    "labelId":8,
    "fileNum":1,
    "totalPages":1,
    "pageNo":0,
    "listPath":[
    {
    "id":"15",
    "name":"116398522127350595391.jpg",
    "fileMd5":"B633DA681E9C5BD741D0D87997EFB7EF",
    "size":"15.93KB",
    "ower":"yiliangaccess",
    "isFile":true,
    "filePath":"/sdcard/cafari/photocomb/yiliangaccess/来自HUAWEI_SLA-TL10/2018-01/116398522127350595391.jpg",
    "isPri":true,
    "isCollect":false,
    "lastModified":1512116730000,
    "mime_type":"image/jpeg"
    }
    ]
    }
    }
     *
     *
     */

}
