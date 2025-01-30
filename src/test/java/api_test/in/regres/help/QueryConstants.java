package api_test.in.regres.help;

public interface QueryConstants{
    String GET_LIST_USER="api/users?page=2",
            GET_SINGLE_USER="/api/users/2",
            GET_SINGLE_USER_NOT_FOUND="/api/users/23",
            GET_LIST_RESOURCE="/api/unknown",
            GET_SINGLE_RESOURCE="/api/unknown/2",
            POST_CREAT="/api/users",
            PUT_UPDATE="/api/users/2",
            PATH_UPDATE="/api/users/2",
            DELETE_DELETE="/api/users/2",
            POST_REGISTER_SUCCESSFUL="/api/register",
            POST_REGISTER_UNSUCCESSFUL="/api/register",
            POST_LOGIN_SUCCESSFUL="/api/login",POST_LOGIN_UNSUCCESSFUL="/api/login";
}
class fsfs implements QueryConstants{
    public static void main(String[] args) {
        System.out.println(PATH_UPDATE);
    }
}