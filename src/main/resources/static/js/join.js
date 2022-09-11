
// 아이디 중복체크 창 오픈
function idChkFormOpen() {
    let win = window.open('idChk','Check','left=600,top=300,width=400,height=300,menubar=no');
}

// udChk.html 아이디 유효성체크
function idChk() {
    // 아이디 체크 정규식
    // let regExpId = /^[0-9a-z]+$/;
    let regExpId = /^[\da-z]+$/;

    let searchId = document.getElementById('searchID');
    if ( !regExpId.test(searchId.value) ) {
        alert('아이디는 숫자, 영문만 입력 가능합니다.');

        if ( searchId.value.length < 3 ) {
            alert('아이디는 3글자 이상으로 입력해주세요');
            searchId.value = '';
            searchId.select();
        }

        return false;
    }

    return true;
}

// 회원가입 페이지로 이동
function backtoJoin(searchID) {
    // alert(searchID);
    opener.document.getElementById('memberid').value = searchID;
    this.close();
}


// join.html 회원가입 submit 버튼 체크사항
function check() {
    let memberpw = document.getElementById('memberpw');
    let pwConfirm = document.getElementById('pwConfirm');
    if (memberpw.value.length < 3) {
        alert("비밀번호는 3자 이상으로 입력해주세요");
        // memberpw.classList.add('invaild');
        memberpw.value = '';
        memberpw.focus();

        if (pwConfirm.value.length < 3) {
            alert("비밀번호 확인창도 입력해주세요");
            pwConfirm.select();
        }

        return false;

    } else if (memberpw.value !== pwConfirm.value) {
        alert("비밀번호 재확인과 같지않습니다.");
        memberpw.value = '';
        pwConfirm.value = '';
        memberpw.select();
        return false;
    }

    let membername = document.getElementById('membername');
    if (membername.value.length < 2) {
        alert("이름은 2글자 이상으로 입력해주세요");
        membername.value = '';
        return false;
    }

    return true;
}