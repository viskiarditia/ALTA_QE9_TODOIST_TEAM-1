package starter.Utils;

public class TodoistURL {
    public static final String URL = "https://api.todoist.com";

    // TASK
    public static String GET_LIST_TASK = URL + "/rest/v2/tasks";
    public static String GET_SINGLE_TASK = URL + "/rest/v2/tasks/{id}";
    public static String POST_CLOSE_TASK = URL + "/rest/v2/tasks/{id}/close";
    public static String POST_CREATE_TASK = URL + "/rest/v2/tasks";
    public static String POST_REOPEN_TASK = URL + "/rest/v2/tasks/{id}/reopen";
    public static String POST_UPDATE_TASK = URL + "/rest/v2/tasks/{id}";
    public static String DELETE_TASK = URL + "/rest/v2/tasks/{id}";

    // COMMENT
    public static final String GET_ALL_COMMENT = URL+"/rest/v2/comments/3224747581";
    public static final String CREATE_NEW_COMMENT = URL+"/rest/v2/comments";
    public static final String GET_COMMENT = URL+"/rest/v2/comments/{id}";
    public static final String UPDATE_COMMENT = URL+"/rest/v2/comments/{id}";
    public static final String DELETE_COMMENT = URL+"/rest/v2/comments/{id}";

    // PROJECT
    public static final String GET_ALL_PROJECTS = URL+"/projects";
    public static final String INVALID_GET_ALL_PROJECTS = URL+"/project";
    public static final String CREATE_NEW_PROJECT = URL+"/projects";
    public static final String GET_PROJECT = URL+"/projects/{id}";
    public static final String UPDATE_PROJECT = URL+"/projects/{id}";
    public static final String DELETE_PROJECT = URL+"/projects/{id}";
    public static final String GET_ALL_COLLABORATOR = URL+"/projects/{id}/collaborators";

    // SECTION
    public static String GET_ALL_SECTION = URL+"/rest/v2/sections?project_id={id}";
    public static String GET_SINGLE_SECTIONS =URL+ "/rest/v2/sections/{id}";
    public static String POST_NEW_SECTION = URL +"/rest/v2/sections";
    public static String POST_UPDATE_SECTION = URL+"/rest/v2/sections/{id}";
    public static String DELETE_SECTION =URL+"/rest/v2/sections/{id}";

}
