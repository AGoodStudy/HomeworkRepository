$(document).ready(function () {

    setInterval(function () {
        axios.post('http://localhost:8080/checkSession')
            .then(function (response) {
                if (response.data == "nullsession") {
                    window.location.reload()
                }
            })
            .catch(function (error) {
                console.log(error);
            });
    }, 10 * 60 * 1000)

    var loginTable = new Vue({
        el: "#mainarea",//用vue接管id为app的区域
        data: {
            lastTime: "",
            account: {
                username: window.sessionStorage.getItem("accountname")
            }
        },
        beforeCreate: function () {
            var account = {
                number: window.sessionStorage.getItem("accountnumber")
            }
            var _this = this
            axios.post('http://localhost:8080/getLastTime', account)
                .then(function (response) {
                    _this.lastTime = response.data
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
    });

});

