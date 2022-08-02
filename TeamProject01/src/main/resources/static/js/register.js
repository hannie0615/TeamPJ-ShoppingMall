$("#nickDupTestMsg").css("display", "none");
$("#mailDupTestMsg").css("display", "none");
let isclicked = false
let checked = false;
let n_nameCheck = false;
let emailCheck = false;
let tempId = ''
let tempPw = ''



function vali_email() {
    let mail_check = document.forms["registration"]["email01"].value;

    let regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

    if (mail_check.length == 0) {
        alert("이메일을 입력해주세요");
        $("#email01").focus();
        return false;
    } else {
        if (mail_check.match(regEmail)!=null) {
            return true;
        } else {
            alert("이메일 형식을 확인해주세요");
            $("#email01").focus();
            return false;
        }
    }
}

// 이메일 체크
function mailDupleTest(){
    $("#mailDupTestMsg").css("display", "");
    let mail_check = document.forms["registration"]["email01"].value;
    let regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    if (mail_check.length == 0) {
        $("#mailDupTestMsg").text("이메일을 입력해주세요");
        $("#mailDupTestMsg").addClass("mailDupTestMsgF");
        $("#mailDupTestMsg").removeClass("mailDupTestMsgT");
        return false;
    }
    if (mail_check.match(regEmail) != null) {
        const mail = $("#email01").val();
        $.ajax({
            type: "get",
            async: false,
            url: "/register/mailCheck",
            data: {mail: mail},
            success: function (data) {
                if (data == 1) {
                    $("#mailDupTestMsg").text("이미 사용중인 이메일 입니다.");
                    $("#mailDupTestMsg").addClass("mailDupTestMsgF");
                    $("#mailDupTestMsg").removeClass("mailDupTestMsgT");
                    emailCheck = false;
                } else {
                    $("#mailDupTestMsg").text("사용 가능한 이메일 입니다.");
                    $("#mailDupTestMsg").addClass("mailDupTestMsgT");
                    $("#mailDupTestMsg").removeClass("mailDupTestMsgF");
                    $("#signUp").attr("type", "submit");
                    emailCheck = true;
                }
            }
        });
    } else {
        $("#mailDupTestMsg").text("이메일의 형식을 확인해주세요");
        $("#mailDupTestMsg").addClass("mailDupTestMsgF");
        $("#mailDupTestMsg").removeClass("mailDupTestMsgT");
        return false;
    }
}


//아이디 중복검사 여부
$("#duplicate_check").click(function () {
    let id_check = document.forms["registration"]["id01"].value;
    let regId = /^[a-z0-9-_]{5,12}$/g;
    if (id_check.match(regId) != null) {
        $("#signUp").attr("type", "button");
        const id = $("#user_id").val();
        $.ajax({
            type: "get",
            async: false,
            url: "/register/idcheck",
            data: {id: id},
            success: function (data) {
                if (data == 1) {
                    $("#dupTestMsg").text("이미 사용중인 ID 입니다.");
                    $("#dupTestMsg").addClass("dupTestMsgF");
                    $("#dupTestMsg").removeClass("dupTestMsgT");
                } else {
                    $("#dupTestMsg").text("사용 가능한 ID 입니다.");
                    $("#dupTestMsg").addClass("dupTestMsgT");
                    $("#dupTestMsg").removeClass("dupTestMsgF");
                    $("#signUp").attr("type", "submit");
                    isclicked = true;
                    tempId = $("#user_id").val();
                }
            }
        })
        return true;
    } else {
        alert("아이디는 영어 소문자, 숫자, 특수문자 '-' , '_' 만을 사용하여 5 ~ 12자로 사용 가능합니다. ")
        $("#user_id").focus();
        return false;
    }


});

// 중복검사 완료 후 아이디 변경할 때
function after_change_id(){
    if (tempId != $("#user_id").val()) {
        isclicked = false;
    }
}

//  비밀번호의 유효성 검사
function vali_pw(){

    let pw_check = document.forms["registration"]["pwd01"].value;

    let pwRule = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/;

    if (pw_check.length == 0) {
        alert("비밀번호를 입력해주세요");
        $("#pwd01").focus();
        return false;
    } else {
        if (pw_check.match(pwRule) != null) {
            tempPw = pw_check
            return true;
        } else {
            alert("비밀번호는 특수문자를 포함하여 8~20자 사이로 입력하셔야합니다.")
            return false;
        }
    }

}
// 비밀번호 확인
function vali_confirm_pw(){
    let pw_con = document.forms["registration"]["pwd02"].value;
    if (pw_con.length == 0) {
        alert("'비밀번호 확인'란을 입력해주세요.");
        $("#pwd02").focus();
        return false;
    } else {
        if (pw_con != tempPw) {
            alert("'비밀번호'와 '비밀번호 확인'에 입력된 값이 서로 다릅니다.")
            return false;
        } else {
            return true;
        }
    }
}

// 이름 확인
function vali_name(){
    let check_name = document.forms["registration"]["name01"].value;
    let nameRule = /^[가-힣]{2,20}$/;
    if (check_name.length == 0) {
        alert("이름을 입력해주세요");
        $("#user_name").focus();
        return false;
    } else {
        if (check_name.match(nameRule) != null) {
            return true;
        } else {
            alert("이름은 한글만 사용 가능합니다.")
            $("user_name").focus()
            return false;
        }
    }
}
// 닉네임 확인
function vali_nick_name(){
    let checkN_name = document.forms["registration"]["n_name"].value;
    let n_nameRule = /^(?=.*[A-Za-z가-힣])[A-Za-z가-힣0-9-_]{3,10}$/;
    if (checkN_name.length == 0) {
        alert("닉네임을 입력해주세요");
        $("#user_Nickname").focus();
        return false;
    } else {
        if (checkN_name.match(n_nameRule) != null) {
            return true;
        } else {
            alert("닉네임은 영어 및 한글을 반드시 포함하여 3~10자 사이로 설정하여야 합니다(특수문자'-','_' 사용가능)");
            $("#user_Nickname").focus();
            return false;
        }
    }
}

//닉네임 중복검사
function nicknamedupTest() {
    $("#nickDupTestMsg").css('display', '');
    let checkN_name = document.forms["registration"]["n_name"].value;
    let n_nameRule = /^(?=.*[A-Za-z가-힣])[A-Za-z가-힣0-9-_]{3,10}$/;
    if (checkN_name.length == 0) {
        $("#nickDupTestMsg").text("닉네임을 입력해주세요");
        $("#nickDupTestMsg").addClass("nickDupTestMsgF");
        $("#nickDupTestMsg").removeClass("nickDupTestMsgT");
        return false;
    }else {
        if (checkN_name.match(n_nameRule) != null) {
            const n_name = $("#user_Nickname").val();
            $.ajax({
                type: "get",
                async: false,
                url: "/register/nicknameCheck",
                data: {nickname: n_name},
                success: function (data) {
                    if (data == 1) {
                        $("#nickDupTestMsg").text("이미 사용중인 닉네임 입니다.");
                        $("#nickDupTestMsg").addClass("nickDupTestMsgF");
                        $("#nickDupTestMsg").removeClass("nickDupTestMsgT");
                        n_nameCheck = false;
                    } else {
                        $("#nickDupTestMsg").text("사용 가능한 닉네임 입니다.");
                        $("#nickDupTestMsg").addClass("nickDupTestMsgT");
                        $("#nickDupTestMsg").removeClass("nickDupTestMsgF");
                        n_nameCheck = true;
                    }
                }
            });
        } else {
            $("#nickDupTestMsg").text("닉네임은 영어 및 한글을 반드시 포함하여 3~10자 사이로 설정하여야 합니다(특수문자'-','_' 사용가능)");
            $("#nickDupTestMsg").addClass("nickDupTestMsgF");
            $("#nickDupTestMsg").removeClass("nickDupTestMsgT");
            return false;
        }
    }
}

// 주소 검증
    function vali_address() {
        let addressCode = document.forms["registration"]["addr01"].value;
        let address = document.forms["registration"]["addr02"].value;
        let detail_address = document.forms["registration"]["addr03"].value;
        if (addressCode.length == 0 || address.length == 0) {
            alert("우편번호 찾기 버튼을 눌러 우편번호와 주소를 입력해주세요");
            $("#find_button").click();
            return false;
        } else {
            if (detail_address.length == 0) {
                alert("상세주소를 입력해주세요");
                $("#detail").focus();
                return false;
            } else {
                return true;
            }
        }
    }

// 약관동의 체크해제 했을 경우
    function checkHandler() {
        if (checked == true) {
            checked = false;
        } else {
            checked = true;
        }
    }

    function reg_submitHandler() {

        if (vali_email() == false) {
            $("#email01").focus();
            return false;
        } else if (emailCheck == false) {
            alert("이미 가입된 이메일입니다, 다른 이메일을 입력해주세요");
            $("#email01").focus();
            return false;
        } else if (isclicked == false) {
            alert("아이디를 입력하신 후 아이디 중복검사를 실행해주세요");
            $("#user_id").focus();
            return false;
        } else if (vali_pw() == false) {
            $("#pwd01").focus();
            return false;
        } else if (vali_confirm_pw() == false) {
            $("#pwd02").focus();
            return false;
        } else if (vali_name() == false) {
            $("#user_name").focus();
            return false;
        } else if (vali_nick_name() == false) {
            $("#user_Nickname").focus();
            return false;
        } else if (n_nameCheck == false) {
            alert("이미 사용중인 닉네임입니다. 다른 닉네임을 입력해주세요");
            $("#user_Nickname").focus();
            return false;
        } else if (vali_address() == false) {
            $("#detail").focus();
            return false;
        } else if (checked == false) {
            alert("약관 동의에 체크해주세요");
            $("#registering").focus();
            return false;
        } else {
            return true;
        }
    }
