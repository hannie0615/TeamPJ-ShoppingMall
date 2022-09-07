
let checked = false;

// 상품명 체크 (한글,영어,숫자만 입력 가능하고 특수문자는 안되게 함)
function vali_prd_name(){
    let prd_name = document.forms["newproduct"]["prd_name"].value; // <form id="">
    let nameRule = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|]*$/;

    if (prd_name.length == 0) {
        alert("상품명을 입력해주세요");
        $("#prd_name").focus();
        return false;
    // } else return true;
    } else {
        if (prd_name.match(nameRule) != null) {
            return true;
        } else {
            alert("상품명은 한글,영어,숫자만 입력할 수 있습니다.");
            $("#prd_name").focus();
            return false;
        }
    }
}

// 상품 종류 체크 (공백 여부만 체크)
function vali_prd_type(){
    let prd_type = document.forms["newproduct"]["prd_type"].value;

    if (prd_type.length == 0) {
        alert("상품 종류를 입력해주세요");
        $("#prd_type").focus();
        return false;
    } else return true;
}

// 상품 업체 체크 (공백 여부만 체크)
function vali_prd_cmp(){
    let prd_cmp = document.forms["newproduct"]["prd_cmp"].value;

    if (prd_cmp.length == 0) {
        alert("상품 업체를 입력해주세요");
        $("#prd_cmp").focus();
        return false;
    } else return true;
}


// 상품 내용 체크 (공백 여부만 체크)
function vali_prd_ment(){
    let prd_ment = document.forms["newproduct"]["prd_ment"].value;

    if (prd_ment.length == 0) {
        alert("상품 내용을 입력해주세요");
        $("#prd_ment").focus();
        return false;
    } else return true;
}

// 상품 수량 체크 (숫자만 입력) => 근데 html 자체에서도 숫자 외의 다른 입력은 못받음.
function vali_prd_sales(){
    let prd_sales = document.forms["newproduct"]["prd_sales"].value;
    let num_Rule = /^[0-9]*$/;

    if (prd_sales.length == 0) {
        alert("상품 수량을 입력해주세요");
        $("#prd_sales").focus();
        return false;
    } else {
        if (prd_sales.match(num_Rule) != null) {
            return true;
        } else {
            alert("상품 수량은 숫자만 입력할 수 있습니다.");
            $("#prd_sales").focus();
            return false;
        }
    }
}

// 가격 체크 (숫자만 입력)
function vali_prd_price(){
    let prd_price = document.forms["newproduct"]["prd_price"].value;
    let num_Rule = /^[0-9]*$/;

    if (prd_price.length == 0) {
        alert("가격을 입력해주세요");
        $("#prd_price").focus();
        return false;
    } else {
        if (prd_price.match(num_Rule) != null) {
            return true;
        } else {
            alert("가격은 숫자만 입력할 수 있습니다.");
            $("#prd_price").focus();
            return false;
        }
    }
}


// 약관동의 체크해제 했을 경우
function checkBoxHandler() {
    if (checked == true) {
        checked = false;
    } else {
        checked = true;
    }
}

// 위의 유효조건을 다 지키는지 검사.
function reg_add_product_Handler() {
    if (vali_prd_name() == false) {
        $("#prd_name").focus();
        return false;
    } else if (vali_prd_type() == false) {
        $("#prd_type").focus();
        return false;
    } else if (vali_prd_cmp() == false) {
        $("#prd_cmp").focus();
        return false;
    } else if (vali_prd_ment() == false) {
        $("#prd_ment").focus();
        return false;
    } else if (vali_prd_sales() == false) {
        $("#prd_sales").focus();
        return false;
    } else if (vali_prd_price() == false) {
        $("#prd_price").focus();
        return false;
    } else if (checked == false) {
        alert("약관 동의에 체크해주세요");
        $("#Agree").focus();
        return false;
    } else {
        alert("상품 등록이 완료되었습니다!");
        return true;
    }
}

