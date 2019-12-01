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
