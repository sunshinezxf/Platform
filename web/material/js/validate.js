/**
 * Created by sunshine on 2015/8/17.
 */
function login_validate() {
    var username = $("#account_email").val();
    var password = $("#account_password").val();
    if (not_null(username) && not_null(password)) {
        return true;
    }
    return false;
}

function not_null(item) {
    if (item == null || item == "" || item.length <= 0) {
        return false;
    }
    return true;
}
