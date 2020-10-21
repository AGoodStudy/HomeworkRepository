package cn.dsh.shixun.utils;

/**
 * 存放静态常量
 *
 * @author dsh
 */
public class Constant {

    /**
     * 成功的字符串
     */
    public static final String SUCCESS = "success";

    /**
     * 失败字符串
     */
    public static final String FALSE = "false";


    /**
     * id查不到用户的情况
     */
    public static final String NOUSER = "无此用户";

    /**
     * 用户初始名字
     */
    public static final String INITNAME = "这个用户很懒还没有名字";

    /**
     * 分享或浏览文件链接前缀
     */
    public static final String LINKPREFIX = "http://www.dsihano.cn/tfwp/os/";

    /**
     * 空字符串
     */
    public static final String NULL = "null";

    /**
     * result字符串
     */
    public static final String RESULT = "result";

    /**
     * 没有这个文件字符串
     */
    public static final String NOFILE = "nofile";

    /**
     * 目录类型
     */
    public static final String FOLDERTYPE = "folder";

    /**
     * 文件类型
     */
    public static final String FILETYPE = "file";

    /**
     * 一天的时间
     */
    public static final long ONEDAY = 1000 * 60 * 60 * 24;

    /**
     * 10分钟
     */
    public static final long TENMINUTE = 1000 * 60 * 10;

    /**
     * 私密浏览type
     */
    public static final String SECRET = "o";

    /**
     * 分享type
     */
    public static final String NOTSECRET = "s";

    /**
     * txt字符串
     */
    public static final String TXT = "txt";

    /**
     * txt文件的contentType
     */
    public static final String TXTMIME = "text/plain";

    /**
     * pdf字符串
     */
    public static final String PDF = "pdf";

    /**
     * pdf文件的contentType
     */
    public static final String PDFMIME = "application/pdf";

    /**
     * dir字符串
     */
    public static final String DIR = "dir";

    /**
     * 请求头中token失效
     */
    public static final String HEADTOKENFAILURE = "凭证失效,请重新登录";

    /**
     * 请求头中没有token
     */
    public static final String NOHEADTKEN = "无凭证，请重新登录";

    /**
     * 请求头重token错误
     */
    public static final String ERRORHEADTKEN = "凭证错误，请重新登录";

    /**
     * 未知状态
     */
    public static final String UNKNOWN = "unknown";

    /**
     * md文件后缀
     */
    public static final String MDPREFIX = ".md";

    /**
     * md为念mime
     */
    public static final String MDMIME = "application/x-genesis-rom";

    /**
     * 存在缓存
     */
    public static final String CACHE = "cache";

    /**
     * 缓存路径
     */
    public static final String CACHEPATH = "/home/upload/cachearea/";

    /**
     * 文件存储路径
     */
    public static final String STORAGEPATH = "/home/upload/storagearea/";

    /**
     * 一页内容的数量
     */
    public static final Integer PAGECOUNT = 20;

    /**
     * token私钥
     */
    public static final String TOKEN_SECRET = "dengsihan";

    /**
     * 返回链接提示
     */
    public static final String LINK = "link";

    /**
     * 请求成功
     */
    public static final String RESULTOK = "OK";

    /**
     * 返回前端提示内容
     */
    public static final String MESSAGE = "message";

    /**
     * 返回用户信息
     */
    public static final String USERINFO = "userinfo";

    /**
     * 查询用户信息是出错
     */
    public static final String USERINFOERROR = "ERROR_USERINFO";

    /**
     * 新建文件夹错误
     */
    public static final String ERRORBUILD = "ERROR_BUILD";

    /**
     * 更改昵称错误
     */
    public static final String ERRORNICKNAME = "ERROR_NICKNAME";

    /**
     * 更改密码错误
     */
    public static final String ERRORPWD = "ERROR_PWD";

    /**
     * 更改文件名或目录名错误
     */
    public static final String ERRORCHANGE = "ERROR_CHANGE";

    /**
     * 清空回收站错误
     */
    public static final String ERRORCLEAR = "ERROR_CLEAR";

    /**
     * 文件或目录移动错误
     */
    public static final String ERRORMOVE = "ERROR_MOVE";

    /**
     * 文件或目录复制错误
     */
    public static final String ERRORCOPY = "ERROR_COPY";

    /**
     * 删除错误
     */
    public static final String ERRORDELETE = "ERROR_DELETE";

    /**
     * 通过链接下载错误
     */
    public static final String ERRORLINK = "ERROR_LINK";

    /**
     * 下载错误
     */
    public static final String ERRORDOWNLOAD = "ERROR_DOWNLOAD";

    /**
     * 邮件发送错误
     */
    public static final String ERROREMAIL = "ERROR_EMAIL";


    /**
     * 登陆错误
     */
    public static final String ERRORLOGIN = "ERROR_LOGIN";

    /**
     * 还原错误
     */
    public static final String ERRORRESTORE = "ERROR_RESTORE";

    /**
     * 文件上传错误
     */
    public static final String ERRORUPLOAD = "ERROR_UPLOAD";

    /**
     * token验证错误
     */
    public static final String ERRORTOKEN = "ERROR_TOKEN";

    /**
     * 查看目录内容错误
     */
    public static final String ERRORVIEW = "ERROR_VIEW";

    /**
     * 和json格式相关异常
     */
    public static final String ERRORJSON = "ERROR_JSON";

    /**
     * 传值类型异常
     */
    public static final String ERRORTYPE = "ERROR_TYPE";

    /**
     * 传值参数异常
     */
    public static final String ERRORARGUMENT = "ERROR_ARGUMENT";

    /**
     * 请求方式异常
     */
    public static final String ERRORMETHOD = "ERROR_METHOD";

    /**
     * 目录错误
     */
    public static final String WRONGFOLDER = "请在正确的目录下新建目录";

    /**
     * 新建目录名字太长
     */
    public static final String LONGFOLDERNAME = "名字过长";

    /**
     * 新建目录插入数据库失败
     */
    public static final String BUILDERFAIL = "新建失败，请重新新建";

    /**
     * 当前目录已存在同名目录
     */
    public static final String SAMEFOLDER = "此目录已存在";

    /**
     * 当前目录有同名文件
     */
    public static final String SAMEFILE = "此文件已存在";

    /**
     * 更改数据库错误
     */
    public static final String CHANGEERROR = "更改失败，请重新更改";

    /**
     * 要操作的目录或者不存在
     */
    public static final String NORESOURCE = "此文件或目录不存在";

    /**
     * 清空回收站失败
     */
    public static final String CLEARFAIL = "清空失败";

    /**
     * 回收站彻底删除时该文件或目录没有被删除
     */
    public static final String NOTDELETE = "该文件或目录没有被删除";

    /**
     * 彻底删除失败
     */
    public static final String CLEARONEFAIL = "彻底删除失败";

    /**
     * 彻底删除时操作数据库失败
     */
    public static final String CLEARONEFAILSQL = "彻底删除失败,请重新操作";

    /**
     * 资源无法移动
     */
    public static final String CANTMOVE = "无法移动";

    /**
     * 资源无法复制
     */
    public static final String CANTCOPY = "无法移动";

    /**
     * 用户首页不能移动
     */
    public static final String CANTMOVEROOT = "首页不能被移动";

    /**
     * 用户首页不能被复制
     */
    public static final String CANTCOPYROOT = "首页不能被复制";

    /**
     * 移动复制等操作指定的目录不存在
     */
    public static final String NOTOFOLDER = "指定目录不存在";

    /**
     * 复制时对数据库操作失败
     */
    public static final String COPYFAIL = "复制失败";

    /**
     * 移动时对数据库操作失败
     */
    public static final String MOVEFAIL = "移动失败";

    /**
     * 需要操作的文件不存在
     */
    public static final String FILENOTEIXST = "此文件不存在";

    /**
     * 不能删除根目录
     */
    public static final String CANTDELETEROOT = "无法删除根目录";

    /**
     * 删除数据对数据库操作失败
     */
    public static final String DELETEFAIL = "删除失败,请重新删除";

    /**
     * 通过链接下载token超时
     */
    public static final String LINKfAILURE = "链接失效";

    /**
     * 通过链接下载token无效
     */
    public static final String LINKINVALID = "链接无效";

    /**
     * 私密链接无权访问
     */
    public static final String NOACCESS = "无权限访问";

    /**
     * 下载时出错
     */
    public static final String DOWNLOADFAIL = "下载失败，请重新下载";

    /**
     * 昵称不合法
     */
    public static final String WRONGFULNAME = "昵称不合法,只能由中英文以及数字组成";

    /**
     * 父级被删除，无法单独还原
     */
    public static final String CANTRESTORE = "此文件或目录无法被还原";

    /**
     * 还原时操作数据库操作失败
     */
    public static final String RESOREFAIL = "还原失败";

    /**
     * 当前目录不存在
     */
    public static final String NOCURRENTFOLDER = "当前目录不存在";

    /**
     * 上传的文件为空
     */
    public static final String EMPTYFILE = "此文件为空，请重新选择";

    /**
     * 上传时失败
     */
    public static final String UPLOADFAIL = "上传失败，请重新上传";

    /**
     * 邮箱验证码过期
     */
    public static final String VERCODEFAILURE = "验证码过期,请重新获取";

    /**
     * 输入验证码与发送验证码不一样
     */
    public static final String VERCODEERROR = "验证码错误";

    /**
     * 没有获取验证码
     */
    public static final String NOVERCODE = "请先获取验证码";

    /**
     * 查看的目录不存在
     */
    public static final String NOVIEWFOLDER = "此目录不存在";

    /**
     * 文件大于20MB
     */
    public static final String TOOLARGEFILE = "文件不能大于20MB，请重新选择";

    /**
     * 前端格式不是json
     */
    public static final String JSONERROR = "传值格式错误";

    /**
     * 能进行正常的类型转换
     */
    public static final String ARGUMENTTYPEERROR = "传值类型错误";

    /**
     * 参数有问题
     */
    public static final String ARGUMENTERROR = "传值参数错误";

    /**
     * 前端请求方式错误
     */
    public static final String ERRORMETHODVALUE = "请求方式错误";

    /**
     * 当前目录传值为空
     */
    public static final String NULLCURRENTFOLDER = "请在正确的目录下新建目录";

    /**
     * 新建目录名为空
     */
    public static final String NULLNEWFOLDERNAME = "请输入新建目录名";

    /**
     * 新建目录成功
     */
    public static final String BUILSUCCESS = "新建成功";

    /**
     * 输入验证码为空
     */
    public static final String NULLVERCODE = "验证码不能为空";

    /**
     * 输入密码为空
     */
    public static final String NULLPASSWORD = "密码不能为空";

    /**
     * 更改成功提示
     */
    public static final String CHANGESUCCESS = "更改成功";

    /**
     * 没有传入对于资源id
     */
    public static final String NULLRESOURCE = "请选择文件或目录";

    /**
     * 没有更改资源的名字
     */
    public static final String NULLUPDATENAME = "请输入更改后的名字";

    /**
     * 清空成功提示
     */
    public static final String CLEARSUCCESS = "清空成功";

    /**
     * 没有传入彻底删除资源的id
     */
    public static final String NULLCLEARRESOURCE = "请选择想要彻底删除的目录或文件";

    /**
     * 彻底删除一个资源成功
     */
    public static final String CLEARONESUCCESS = "彻底删除成功";

    /**
     * 没有传入移动资源的id
     */
    public static final String NULLMOVERESOURCE = "请选择需要移动的文件或者目录";

    /**
     * 制定目录id没有传入
     */
    public static final String NULLTOFOLDER = "请选择指定的目录";

    /**
     * 移动成功提示
     */
    public static final String MOVESUCCESS = "移动成功";

    /**
     * 没有传入复制资源的id
     */
    public static final String NULLCOPYRESOURCE = "请选择需要复制的文件或目录";

    /**
     * 复制成功提示
     */
    public static final String COPYSUCCESS = "复制成功";

    /**
     * 没有传入删除资源的id
     */
    public static final String NULLDELETERESOURCE = "请选择需要删除的文件或目录";

    /**
     * 传入集合存在空的id
     */
    public static final String EXITNULLID = "存在空的文件或目录";

    /**
     * 删除成功提示
     */
    public static final String DELETESUCCESS = "删除成功";

    /**
     * 没有传入下载文件的id
     */
    public static final String NULLDOWNLOADFILE = "请选择下载文件";

    /**
     * 邮件发送成功提示
     */
    public static final String EMAILSUCCESS = "验证码已成功发送";

    /**
     * 邮件发送错误
     */
    public static final String EMAILERROR = "验证码发送失败，请重新获取";

    /**
     * 传入昵称为空
     */
    public static final String NULLNICKNAME = "昵称不能为空";

    /**
     * 创建新用户数据库异常
     */
    public static final String REGISTERERROR = "新用户添加失败,请重新登陆";

    /**
     * 账号密码为空时
     */
    public static final String NULLUSEREMAILPWD = "账号或密码不能为空";

    /**
     * 账号或密码错误时
     */
    public static final String ERRORUSEREMAILPWD = "账号或密码错误";

    /**
     * 需要还原资源id没有传入
     */
    public static final String NULLRESTORERESOURCE = "请选择需要还原的文件";

    /**
     * 成功还原提示
     */
    public static final String RESTORESUCCESS = "还原成功";

    /**
     * 分享文件id没有传入
     */
    public static final String NULLSHAREFILE = "请选择需要分享的文件";

    /**
     * 浏览文件id没有传入
     */
    public static final String NULLREADFILE = "请选择需要浏览的文件";


    /**
     * 上传时的目录id没有传入
     */
    public static final String NULLCURRENTFOLDERID = "当前目录id不能空";

    /**
     * 上传成功提示
     */
    public static final String UPLOADSUCCESS = "文件上传成功";

    /**
     * 传入的目录id为空
     */
    public static final String ERRORFOLDERID = "请选择正确的目录";

    /**
     * 传入的页数为空
     */
    public static final String ERRORPAGENUM = "请选择正确的页数";

    /**
     * 排序方式为空
     */
    public static final String ERRORSORTTYPE = "请选择正确的排序方式";
}

