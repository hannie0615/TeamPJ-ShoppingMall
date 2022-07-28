$.validator.addMethod("regex",
    function (value, element, regexp) {
        var re = new RegExp(regexp);
        if (re.test(value) == false) {
            $('#duplicate_check').prop('disabled', true);
        } else {
            $('#duplicate_check').prop('disabled', false);
        }
        return this.optional(element) || re.test(value);
    },"Please check your input."
);
$.validator.addMethod("koreanLetters", function(value, element){
    return this.optional(element) || value.match("/^[가-힣]+$/");
}, "한글로 입력 해주세요.")

$(document).ready(function(){

    $("#registration").validate({
        rules:{
            email01:{
                required: true,
                email: true
            },
            id01:{
                Lock : true,
                regex : "^[A-Za-z0-9]*$"
            },
            pwd01:{
                required : true
            },
            pwd02:{
                required : true,
                equalTo: '#pwd01'
            },
            name01 : {
                required : true
            },
            n_name : {
                required : true
            },
            addr02 : {
                required : true
            },
            addr03 : {
                koreanLetters : true,
                required : true
            }
        },
        messages:{
            email01:{
                required: "이메일은 필수 입력 항목입니다.",
                email: "이메일 형식을 확인하세요."
            },
            id01 : {
                Lock : "아이디는 필수 입력 항목입니다.",
                regex: "아이디는 영문(대소문자 포함)과 숫자만 사용 가능합니다."
            },
            pwd01:{
                required : "패스워드는 필수 입력 항목 입니다."
            },
            pwd02:{
                required : "패스워드 확인은 필수 입력 항목 입니다.",
                equalTo: "패스워드랑 일치하지 않습니다."
            },
            name01 : {
                required : "이름은 필수 입력 항목 입니다."
            },
            n_name : {
                required : "닉네임은 필수 입력 항목 입니다."
            },
            addr02 : {
                required : "우편번호 찾기를 눌러 주소를 입력해주세요."
            },
            addr03 : {
                required : "상세주소는 필수 입력 항목 입니다."
            }
        },

    });
});
