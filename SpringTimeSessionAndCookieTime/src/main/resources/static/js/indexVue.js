$(document).ready(function () {
    $("#loginTable").show()
    $("#registerTable").hide()

    var loginTable = new Vue({
        el: "#loginTable",//用vue接管id为app的区域
        data: {
            loginAccount: {
                number: "",
                password: ""
            },
            loginPrompt: ""
        },
        created: function () {
            var wholeUrl = window.location.href;
            console.log(wholeUrl)
            var indexofid = wholeUrl.indexOf("=");
            console.log(indexofid)
            if (indexofid > 0) {
                var flag = wholeUrl.substring(indexofid + 1)
                console.log(flag)
                if (flag == "1") {
                    alert("请先登陆")
                }
            }
        },
        methods: {
            login: function () {
                var _this = this;
                axios.post('http://localhost:8080/accountLogin', _this.loginAccount)
                    .then(function (response) {
                        if (response.data.username == null) {
                            _this.loginPrompt = "账号或者密码错误"
                        } else {
                            window.location.href = "mainpage.html";
                            window.sessionStorage.setItem("accountname", response.data.username);
                            window.sessionStorage.setItem("accountnumber", response.data.number);
                        }
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },

            showRegister: function () {
                this.loginPrompt = ""
                $("#registerTable").show()
                $("#loginTable").hide()
            }
        }
    });

    var registerTable = new Vue({
        el: "#registerTable",//用vue接管id为app的区域
        data: {
            registerAccount: {
                username: "",
                number: "",
                password: ""
            },
            registerPrompt: ""
        },
        methods: {
            register: function () {
                var _this = this;
                axios.post('http://localhost:8080/accountRegister', _this.registerAccount)
                    .then(function (response) {
                        if (response.data != null && response.data == "success") {
                            _this.registerPrompt = "注册成功，可登陆"
                        } else {
                            _this.registerPrompt = "注册失败"
                        }
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },

            showLogin: function () {
                this.registerPrompt = "";
                $("#registerTable").hide()
                $("#loginTable").show()
            }
        }
    });


});
