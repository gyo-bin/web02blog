package kr.hs.dgsw.web02blog.Protocol;

public enum ResponseType {
    FAIL                (0, "명령을 실행하지 못했습니다"),

    USER_DELETE         (101, "사용자를 삭제했습니다"),
    USER_ADD            (102, "사용자를 추가했습니다"),
    USER_UPDATE         (103, "ID [%d]의 사용자를 수정했습니다"),
    USER_GET            (104, "[%s] 님의 정보 가져오기"),

    POST_GET            (201, ""),
    POST_ADD            (202, ""),
    POST_UPDATE         (203, ""),
    POST_DELETE         (204, ""),

    ATTACHMENT_STORED   (301,""),
    ;

    final private int code;
    final private String desc;
    ResponseType(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public int code(){ return this.code; }
    public String desc(){ return this.desc; }
}
